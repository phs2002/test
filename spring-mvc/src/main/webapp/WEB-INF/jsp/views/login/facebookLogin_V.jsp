<%--
/***********************************************************************
 * @ 화면명  : 페이스북 로그인
 * @ 파일명  : facebookLogin_V.jsp
 * @ 작성자  : 박해상
 * @ 작성일  : 2019-02-14
************************************************************************
수정일			수정자		수정내용
************************************************************************
2019-02-14		박해상		최초작성
************************************************************************/
--%>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/com/common.jsp" %>

<script type="text/javascript">
//<![CDATA[
	
	var clientId = '2310487892564819';
	
	var redirectUri = 'http://localhost:8080/login/facebookLogin';
	
	$(document).ready(function(){
		$.getScript('https://connect.facebook.net/ko_KR/sdk.js', function(){
			FB.init({
				appId            : clientId,
				autoLogAppEvents : true,
				xfbml            : true,
				version          : 'v3.2'
			});
			
			FB.getLoginStatus(function(response) {
				// 로그인 상태 체크
				if(response.status == "connected") {
					getFacebookUserProfile(response.authResponse.accessToken);
				} else {
					callFacebookLogin()
				}
			});
		});
	});
	
	/**
	 * 페이스북 로그인 페이지를 호출
	 * @ignore
	 * @return void
	 * @private
	 */
	function callFacebookLogin() {
		location.href = "https://www.facebook.com/v2.11/dialog/oauth"
					  + "?client_id="+clientId
					  + "&response_type=code%20token"
					  + "&display=popup"
					  + "&redirect_uri="+encodeURIComponent(redirectUri);
	}
	
	/**
	 * 페이스북 프로필 정보 호출
	 * @ignore
	 * @return void
	 * @private
	 */
	function getFacebookUserProfile(accessToken) {
		var callUrl = "https://graph.facebook.com/v2.11/me"
					+ "?fields=id,name,gender,age_range,email,birthday"
					+ "&access_token=" + accessToken;
		$.ajax({
			url: callUrl,
			type: "GET",
			dataType: "json",
			success: function(result) {
				console.log(JSON.stringify(result, "    ", 4));
				parseFacebookData(result);
			},
			error: function(xhr, ajaxOptions, thrownError) {
// 				alert("페이스북 로그인 실패["+xhr.status+"]["+thrownError+"]");
				alert("페이스북 로그인 실패");
				self.close();
			}
		});
	}
	
	/**
	 * 가지고 있는 사용자 정보를 파싱한다.
	 * @ignore
	 * @return void
	 * @private
	 */
	function parseFacebookData(data) {
// 		console.log("parseFacebookData success[" + JSON.stringify(data, "    ", 4) + "]");
// 		alert("parseFacebookData success[" + JSON.stringify(data, "    ", 4) + "]");
		
// 		if($.trim(data.age_range) != "" && $.trim(data.age_range.min) != "") {
// 			data.age = data.age_range.min.substring(0,2);
// 		}
		if(data.gender == "male") {
			data.gender = "1";
		} else if(data.gender == "female") {
			data.gender = "2";
		} else {
			data.gender = "";
		}
		if($.trim(data.birthday) != "") {
			data.birthday = data.birthday.replace(/\//gi, "");
			data.birthday = $.trim(data.birthday.substring(4, 8)) + $.trim(data.birthday.substring(0, 4));
		}
		
// 		window.opener.snsLoginCallback('22', data);
// 		self.close();
	}
	
//]]>
</script>