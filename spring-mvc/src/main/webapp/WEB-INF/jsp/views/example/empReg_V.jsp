<%--
/***********************************************************************
 * @ 화면명  : 직원 등록
 * @ 파일명  : empReg_V.jsp
 * @ 작성자  : 박해상
 * @ 작성일  : 2019-01-24
************************************************************************
수정일			수정자		수정내용
************************************************************************
2019-01-24		박해상		최초작성
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
	 * 본인확인(휴대폰인증) 팝업 호출
	 * @param srvNo - 서비스번호
	 */
	function certnMpo(srvNo) {
		
		if(!checkAgree()) {
			return;
		}
		
		$("#siteTypeCd").val("1"); //사이트구분코드 : 1[굿잡]
		$("#srvNo").val(srvNo);
		
		$.ajax({
			type:"POST",
			dataType:"json",
			url:"/com/CO000006.kb",
			data:$("#userJoinForm").serialize(),
			success:function(data) {
				
				alert(JSON.stringify(data, "    ", 4));
				
				loading_close();
				if($.trim(data) == "") return;
				
				$("#reqInfo").val(data.reqInfo);
				$("#reqNum").val(data.reqNum);
				$("#retUrl").val('32https://<c:out value="${_jobDomain}" />/job/pop/GW990015.kb');
				
				openPCCWindow();
			},
			error:function(xhr, textStatus, errorThrown) {
				loading_close();
				alert("오류가 발생했습니다.");
			}
		});
	}
	
	/**
	 * 회사정보 조회
	 */
	function fn_deptInfoInq(deptno) {
		alert(deptno);
	}
	
//>	
</script>

<h1>
	EMP REG
</h1>
<table border="1">
	<colgroup>
		<col width="10%" />
		<col width="*" />
		<col width="10%" />
		<col width="10%" />
	</colgroup>
	<thead>
		<tr>
			<th>ENAME</th>
			<th>JOB</th>
			<th>MGR</th>
			<th>SAL</th>
			<th>COMM</th>
			<th>DEPTNO</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${empList}" var="list" varStatus="status">
			<tr>
				<td><input type="text" name="ename" value="" /></td>
				<td><input type="text" name="job" value="" /></td>
				<td><input type="text" name="mgr" value="" /></td>
				<td><input type="text" name="sal" value="" /></td>
				<td><input type="text" name="comm" value="" /></td>
				<td></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<button></button>