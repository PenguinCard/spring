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
</head>
<body>
<form action="${contextPath}/mem3.do">
	입력 : <input type="text" name="value" />&nbsp;&nbsp;
	<select name="action">
		<option value="listMembers">전체</option>
		<option value="selectMemberById">아이디</option>
		<option value="selectMemberByPw">비밀번호</option>
	</select>&nbsp;&nbsp;
	<input type="submit" value="검색" />
</form>
</body>
</html>