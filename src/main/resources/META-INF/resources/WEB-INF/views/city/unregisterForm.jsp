<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>unregisterForm.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
<h1>City 삭제</h1>
${city}
<hr>
<form action="/city/unregister/${id}?pageNo=${param.pageNo}" method="post">			<!-- method가 안 정해줄땐 기본으로 get방식으로 설정되어 있음. get이면 삭제 안됨. -->
	<input class="btn btn-primary" type="submit" value="City 삭제">
</form>

</body>
</html>