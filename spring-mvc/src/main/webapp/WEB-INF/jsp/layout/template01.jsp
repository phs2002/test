<%--
/***********************************************************************
 * @ 화면명   : 템플릿01
 * @ 파일명   : template01.jsp
 * @ 작성자   : 박해상
 * @ 작성일   : 2019-02-14
************************************************************************
수정일			수정자	수정내용
************************************************************************
2019-02-14		박해상	최초작성
************************************************************************/
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>

<html>
<head>
</head>
<body>
	
	<tiles:insertAttribute name="header" />
	
	<div id="container">
		<tiles:insertAttribute name="body" />
	</div>
	
	<tiles:insertAttribute name="footer" />
	
</body>
</html>