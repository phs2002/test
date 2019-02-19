<%--
/***********************************************************************
 * @ 화면명  : 구글 로그인
 * @ 파일명  : googleLogin_V.jsp
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

<script src="https://apis.google.com/js/platform.js"></script>

<script type="text/javascript">
//<![CDATA[
	
	var clientId = '773769237966-nirgdleu7vq243229cimuj927eis1nk2.apps.googleusercontent.com';
	
	var redirectUri = 'http://localhost:8080/login/googleLogin';
	
	$(document).ready(function() {
	});
	
	gapi.load('auth2', function() {
		var auth2 = gapi.auth2.init({client_id: clientId
								   , redirect_uri: redirectUri
								   , ux_mode: 'redirect'
								   , fetch_basic_profile: true
// 								   , scope: 'profile, email, openid'
								   });
		auth2.then(function() {
			// 로그인 여부 체크
			if(auth2.isSignedIn.get()) {
				getGoogleUserProfile(auth2.currentUser.get())
			} else {
				auth2.signIn();
			}
			
		}, function() {
			alert("구글 초기화 도중 오류 발생");
		});
	});
	
	function getGoogleUserProfile(googleUser) {
		
		alert("getGoogleUserProfile");
		
		var profile = googleUser.getBasicProfile();
		
		console.log(googleUser.getId());
		console.log(profile.getId());
		console.log(profile.getName());
		console.log(profile.getGivenName());
		console.log(profile.getFamilyName());
		console.log(profile.getImageUrl());
		console.log(profile.getEmail());
	}
	
//>
</script>