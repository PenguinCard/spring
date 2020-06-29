<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.tac {
	text-align: center;
}
</style>
</head>
<body>
<table class="tac" width="100%" border="1">
	<tr class="tac" bgcolor="lightgreen">
		<td><b>아이디</b></td>
		<td><b>비밀번호</b></td>
		<td><b>이름</b></td>
		<td><b>이메일</b></td>
		<td><b>가입일</b></td>
		<td><b>삭제</b></td>
	</tr>
	     
   <tr align="center">
      <td>${member.id}</td>
      <td>${member.pw}</td>
      <td>${member.name}</td>
      <td>${member.email}</td>
      <td>${member.joinDate}</td>
      <td><a href="${contextPath }/mem3.do?action=deleteMember&id=${member.id}">삭제하기</a></td>
    </tr>
    <tr>
    	<td class="tac" colspan="6">
    		<a href="${contextPath }/test02/modMember.jsp">수정하기</a>
    		<a href="${contextPath }/test02/search.jsp">되돌아가기</a>
    	</td>
    </tr>
</table>
<a  href="${contextPath}/mem3.do?action=memberForm"><h1 style="text-align:center">회원가입</h1></a>
</body>
</html>