<%--
/***********************************************************************
 * @ 화면명   : 직원 목록
 * @ 파일명   : empList_V
 * @ 작성자   : 박해상
 * @ 작성일   : 2019-01-23
************************************************************************
수정일			수정자		수정내용
************************************************************************
2019-01-23		박해상		최초작성
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
	EMP LIST
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
			<th>EMPNO</th>
			<th>ENAME</th>
			<th>JOB</th>
			<th>MGR</th>
			<th>HIREDATE</th>
			<th>SAL</th>
			<th>COMM</th>
			<th>DEPTNO</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${empList}" var="list" varStatus="status">
			<tr>
				<td>${empList[status.index].empno }</td>
				<td>${empList[status.index].ename }</td>
				<td>${empList[status.index].job }</td>
				<td>${empList[status.index].mgr }</td>
				<td>${empList[status.index].hiredate }</td>
				<td>${empList[status.index].sal }</td>
				<td>${empList[status.index].comm }</td>
				<td><button type="button" onclick="fn_deptInfoInq('${empList[status.index].deptno }'); return fasle;">회사정보 보기</button></td>
			</tr>
		</c:forEach>
	</tbody>
</table>