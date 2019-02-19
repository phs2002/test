package com.reonsoft.spring.example.user.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reonsoft.spring.example.user.service.UserService;
import com.reonsoft.spring.example.vo.EMPVO;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name="UserService")
	private UserService userService;
	
	@RequestMapping(value = {"/login"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String userLogin(Model model, EMPVO vo) throws Exception {
		
		logger.info("UserController call userLogin");
		
		return "login/login_V";
	}
	
	@RequestMapping(value = {"/login/googleLogin"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String googleLogin(Model model) throws Exception {
		
		logger.info("UserController call googleLogin");
		
		return "login/googleLogin_V";
	}
	
	@RequestMapping(value = {"/login/naverLogin"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String naverLogin(Model model) throws Exception {
		
		logger.info("UserController call naverLogin");
		
		return "login/naverLogin_V";
	}	
	
	@RequestMapping(value = {"/login/kakaoLogin"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String kakaoLogin(Model model, HttpServletRequest request, String code) throws Exception {
		
		final String kakao = "1"; 
		
		logger.info("UserController call kakaoLogin");
		logger.info("UserController code[" + code + "]");
		logger.info("UserController referer 체크[" + request.getHeader("referer") + "]");
		
		if(code != null && !"".equals(code)) {
			
//			JsonNode jsonToken = getAccessToken(code);
			
//			logger.info("JSON 반환1-1 : " + jsonToken.get("access_token2")); 결과 : null
//			logger.info("JSON 반환1-2 : " + jsonToken.path("access_token2")); 결과 : 공백
//			logger.info("JSON 반환1-3 : " + jsonToken.findPath("access_token2")); 결과 : 공백
//			logger.info("JSON 반환1-4 : " + jsonToken.findValuesAsText("access_token2")); 결과 : []
//			
//			logger.info("JSON 반환2-1 : " + jsonToken.get("access_token"));
//			logger.info("JSON 반환2-2 : " + jsonToken.path("access_token"));
//			logger.info("JSON 반환2-3 : " + jsonToken.findPath("access_token"));
//			logger.info("JSON 반환2-4 : " + jsonToken.findValuesAsText("access_token"));
			
//			logger.info("JSON 반환 : " + jsonToken.path("access_token").textValue());
			
//			model.addAttribute("accessToken", jsonToken.path("access_token").textValue());
			
			model.addAttribute("accessToken", getAccessTokenString(code));
			
		}
		
//		model.addAttribute("code", code);
		
		return "login/kakaoLogin_V";
	}
	
	@RequestMapping(value = {"/login/facebookLogin"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String facebookLogin(Model model) throws Exception {
		
		logger.info("UserController call facebookLogin");
		
		return "login/facebookLogin_V";
	}
	
	public static JsonNode getAccessToken(String autorize_code) {
		
		final String RequestUrl = "https://kauth.kakao.com/oauth/token";
		
		final List<NameValuePair> postParams = new ArrayList<NameValuePair>();
		
		postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
		postParams.add(new BasicNameValuePair("client_id", "1045f97fceffea3d90964140fd1afde7")); // REST API KEY
//		postParams.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/login/kakaoLogin")); // 리다이렉트 URI ※ API 가이드 상으로는 필수 값이라고 명시되어 있는데 없어도 기능함
		postParams.add(new BasicNameValuePair("code", autorize_code)); // 로그인 과정중 얻은 code 값
		
		final HttpClient client = HttpClientBuilder.create().build();
		
		final HttpPost post = new HttpPost(RequestUrl);
		
		JsonNode returnNode = null;
		
		try {
			
			post.setEntity(new UrlEncodedFormEntity(postParams));
			
			final HttpResponse response = client.execute(post);
			final int responseCode = response.getStatusLine().getStatusCode();
			
			logger.info("\nSending 'POST' request to URL : " + RequestUrl);
			logger.info("Post parameters : " + postParams);
			logger.info("Response Code : " + responseCode);
			
			// JSON 형태 반환값 처리
			ObjectMapper mapper = new ObjectMapper();
			
			returnNode = mapper.readTree(response.getEntity().getContent());
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch(ClientProtocolException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			// clear resources
		}
		
		return returnNode;
		
	}
	
	public static String getAccessTokenString(String autorize_code) {
		
		String accessToken = "";
		
		try {
			
			URL url = new URL("https://kauth.kakao.com/oauth/token");
			
			Map<String,Object> params = new HashMap<>();
//			Map<String,Object> params = new LinkedHashMap<>(); // 
			params.put("grant_type", "authorization_code");
			params.put("client_id", "1045f97fceffea3d90964140fd1afde7");
			params.put("redirect_uri", "http://localhost:8080/login/kakaoLogin");
			params.put("code", autorize_code);
			
			StringBuilder postData = new StringBuilder();
			for(Map.Entry<String,Object> param : params.entrySet()) {
				if(postData.length() != 0) postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
			
			logger.info("postData[" + postData.toString() + "]");
			
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");
			
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			conn.setDoOutput(true);
			conn.getOutputStream().write(postDataBytes); // POST 호출
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			
			String inputLine;
			while((inputLine = in.readLine()) != null) { // response 출력
				logger.info(inputLine);
				
				if(inputLine.indexOf("access_token") > -1) {
				
					ObjectMapper mapper = new ObjectMapper();
					
					JsonNode jsonToken = mapper.readTree(inputLine);
					
					logger.info("accessToken jsonNode[" + jsonToken.path("access_token").textValue() + "]");
					
					Map<String, Object> map = new HashMap<String, Object>();
					
					map = mapper.readValue(inputLine, new TypeReference<HashMap<String, String>>() {});
					
					accessToken = map.get("access_token") == null ? "" : map.get("access_token").toString();
					
					logger.info("accessToken map[" + accessToken + "]");
					
					break;
				}
			}
			
			in.close();
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch(ClientProtocolException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			// clear resources
		}
		
		return accessToken;
	}
}
