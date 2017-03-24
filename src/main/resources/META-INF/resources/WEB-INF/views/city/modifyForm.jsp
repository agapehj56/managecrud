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
<title>modifyForm.jsp</title>

<!-- Code Assist -->
<c:if test="false">
	<link rel="stylesheet" href="../code_assist/animate.css">
	<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>

</head>
<body>
<h1>City 수정</h1>
<form:form action="/city/modify?pageNo=${param.pageNo}" method="post" modelAttribute="cityForm">   <!-- 성공하면 파라미터 형태로 성공페이지로 돌아감 -->
	<form:errors/>
	<!-- id -->
	<div>
		<label for="id">id : </label>
		<form:input path="id" readonly="true"/>		<!-- 수정하면 안된다는 의미로 readonly 사용 -->
	</div>	

	<!-- name -->
	<div>
		<label for="name">Name : </label>
		<form:input path="name"/>	
		<form:errors path="name"/>	
	</div>	
	<!-- countryCode -->
	<div>
		<label for="countryCode">CountryCode : </label>
		<form:input path="countryCode"/>
		<form:errors path="countryCode"/>	
	</div>
	<!-- district -->
	<div>
		<label for="district">District : </label>
		<form:input path="district"/>
		<form:errors path="district"/>	
	</div>
	<!-- population -->
	<div>
		<label for="population">Population : </label>
		<form:input path="population"/>
		<form:errors path="population"/>	
	</div>
	
	<input type="submit" value="City 등록">
	
</form:form>
</body>
</html>