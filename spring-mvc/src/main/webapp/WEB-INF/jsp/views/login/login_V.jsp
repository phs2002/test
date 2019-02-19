<%--
/***********************************************************************
 * @ 화면명  : 회원 로그인
 * @ 파일명  : login_V.jsp
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
<%-- <jsp:include page="/WEB-INF/jsp/com/common.jsp"> --%>

<script type="text/javascript">
//<![CDATA[
	
	$(document).ready(function() {
		
	});
	
	/**
	 * SNS로그인 호출
	 * @param type - 로그인 구분
	 */
	function fn_snsLogin(type) {
		
		var p_url = "";
		var p_winName = "";
		
		if($.trim(type) == "") {
			return;
		}
		
		if(type == "01") {
			p_winName = "googleLoginPop";
			p_url = "/login/googleLogin";
		} else if(type == "02") {
			p_winName = "naverLoginPop";
			p_url = "/login/naverLogin";
		} else if(type == "03") {
			p_winName = "kakaoLoginPop";
			p_url = "/login/kakaoLogin";
		} else if(type == "04") {
			p_winName = "facebookLoginPop";
			p_url = "/login/facebookLogin";
		}
		
		var win_width = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth;
		var win_height = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight;
		
		m_width  = 550;
		m_height = 550;
		
		var left = (screen.width - m_width) / 2;
		var top  = (screen.height - m_height) / 2;
		
		var popup = window.open(p_url, p_winName, "toolbar=0, location=0, directories=0, status=0, menubar=0, scrollbars=1, resizable=0, left=" + left + ", top=" + top + ", height=" + m_height + ", width=" + m_width + ", height=" + m_height);
	}
	
//>	
</script>

<div class="wrap">
	<a href="#" class="button" onclick="fn_snsLogin('01'); return false;">구글 로그인</a>
	<a href="#" class="button" onclick="fn_snsLogin('02'); return false;">네이버 로그인</a>
	<a href="#" class="button" onclick="fn_snsLogin('03'); return false;">카카오 로그인</a>
	<a href="#" class="button" onclick="fn_snsLogin('04'); return false;">페이스북 로그인</a>
</div>