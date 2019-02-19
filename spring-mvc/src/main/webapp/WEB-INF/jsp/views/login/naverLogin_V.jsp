<%--
/***********************************************************************
 * @ 화면명  : 네이버 로그인
 * @ 파일명  : naverLogin_V.jsp
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
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"></script>
--%>
<script src="/js/naveridlogin_js_sdk_2.0.0.js"></script>

<script type="text/javascript">
//<![CDATA[
	
	$(document).ready(function() {
		
	});
	
	var naverLogin = new naver.LoginWithNaverId({
		clientId: "jb3gbOIjLYbw29EQK06D",
		callbackUrl: "http://localhost:8080/login/naverLogin",
		isPopup: false
		<%-- 실제 기능적인 역할을 모르겠음
		callbackHandle: true /* callback 페이지가 분리되었을 경우에 callback 페이지에서는 callback처리를 해줄수 있도록 설정 */
		--%>
	});
	
	/* 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
	naverLogin.init();
	
	/* 현재 로그인 상태를 확인 */
	window.addEventListener('load', function() {
		naverLogin.getLoginStatus(function(status) {
			
			console.log("naverLogin.getLoginStatus[" + JSON.stringify(status, "    ", 4) + "]");
			alert("naverLogin.getLoginStatus[" + JSON.stringify(status, "    ", 4) + "]");
			
			/* 로그인 상태가 "true" 인 경우  */
			if(status) {
				/* 사용자 정보를 출력 */
				setLoginStatus();
			} else {
				location.href = naverLogin.generateAuthorizeUrl();
			}
		});
	});
	
	function setLoginStatus() {
		console.log(JSON.stringify(naverLogin.user, "    ", 4));
		alert(JSON.stringify(naverLogin.user, "    ", 4));
		
// 		getNaverUserInfo();
		
	}
	
	function getNaverUserInfo() {
		
		if($.trim(naverLogin) == "" || $.trim(naverLogin.accessToken) == "") {
			return;
		}
		
		$.ajax({
			url: "https://openapi.naver.com/v1/nid/me",
			type: "GET",
			data: {"access_token":naverLogin.accessToken.accessToken},
			dataType: "jsonp",
			jsonp: "oauth_callback",
			async: false,
			success: function(result) {
// 				console.log(JSON.stringify(result, "    ", 4));
				alert("getNaverUserInfo success[" + JSON.stringify(result, "    ", 4) + "]");
			},
			error: function(xhr, ajaxOptions, thrownError) {
// 				alert("네이버 로그인 실패["+xhr.status+"]["+thrownError+"]");
				alert("네이버 로그인 실패");
				self.close();
			}
		});
	}
	
//>
</script>