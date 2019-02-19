<%--
/***********************************************************************
 * @ 화면명  : 카카오 로그인
 * @ 파일명  : kakaoLogin_V.jsp
 * @ 작성자  : 박해상
 * @ 작성일  : 2019-02-14
************************************************************************
수정일			수정자		수정내용
************************************************************************
2019-02-14		박해상		최초작성
************************************************************************/
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/com/common.jsp" %>

<%--
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
--%>  
<script src="/js/kakao.js"></script>

<script type="text/javascript">
//<![CDATA[
	
	var restApiKey = "1045f97fceffea3d90964140fd1afde7";  // REST API KEY
	
	var clientSecret = "axQDPZbdVm9zy8aIjkeBJOoKvwFMqZEh"; // Client Secret
	
	var snsParams = {};
	
	$(document).ready(function() {
		
// 		snsParams.code = "<c:out value="${code}" />";
		snsParams.accessToken = "<c:out value="${accessToken}" />";
		snsParams.redirectUri = "http://localhost:8080/login/kakaoLogin";
		
		Kakao.init('4f0c5043bc21351e8cb522e42cec1fdb');
		
		/* code 존재 유무 */
// 		if($.trim(snsParams.code) == "") {
// 			location.href = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + restApiKey + "&redirect_uri=" + encodeURIComponent(snsParams.redirectUri);
// 		} else {
// 			getKakaoAccessToken("authorization_code");
// 		}
		
		/* accessToken 존재 유무 */
		if($.trim(snsParams.accessToken) == "") {
			location.href = "https://kauth.kakao.com/oauth/authorize"
						  + "?response_type=code"
						  + "&client_id=" + restApiKey
						  + "&redirect_uri=" + encodeURIComponent(snsParams.redirectUri);
		} else {
			getKakaoUserInfo(snsParams.accessToken);
		}
		
	});
	
	/* 가지고 있는 access_token 발급 */
	function getKakaoAccessToken(grantType) {
		
		var ajaxUrl = "https://kauth.kakao.com/oauth/token";
		
		snsParams.grant_type = grantType;
		snsParams.client_id = restApiKey;
		snsParams.client_secret = clientSecret;
		
		$.ajax({
			url: ajaxUrl,
			type: "POST",
			data: snsParams,
			dataType: "json",
			async: false,
			success: function(result) {
// 				console.log("getKakaoAccessToken success[" + JSON.stringify(result, "    ", 4) + "]");
// 				alert("getKakaoAccessToken success[" + JSON.stringify(result, "    ", 4) + "]");
				
				// 정상인 경우
				if($.trim(result.access_token) != "" && $.trim(result.error) == "") {
					if(grantType == "authorization_code") {
						localStorage.setItem("kakaoRefreshToken", result.refresh_token);
					}
					getKakaoUserInfo(result.access_token);
					return;
					
				}
			},
			error: function(xhr, ajaxOptions, thrownError) {
				alert("카카오 로그인 실패1["+xhr.status+"]["+thrownError+"]");
// 				alert("카카오 로그인 실패");
// 				self.close();
			}
		});
	}
	
	/**
	 * 가지고 있는 access_token으로 사용자 정보를 조회한다.
	 * @ignore
	 * @return void
	 * @private
	 */
	function getKakaoUserInfo(accessToken) {
		
		Kakao.Auth.setAccessToken(accessToken);
		Kakao.API.request({
			url: '/v1/user/me',
			success: function(data) {
// 				console.log(JSON.stringify(data, "    ", 4));
				alert("getKakaoUserInfo success[" + JSON.stringify(data, "    ", 4) + "]");
			},
			fail: function(err) {
				alert("카카오 로그인 실패2["+err.code+"]["+err.msg+"]");
// 				alert("카카오 로그인 실패");
// 				self.close();
			}
		});
		
	}
	
//>
</script>