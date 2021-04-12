<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	<style><%@include file="/WEB-INF/jsp/css/header.css"%></style>
	<style><%@include file="/WEB-INF/jsp/css/body.css"%></style> 
	<style><%@include file="/WEB-INF/jsp/css/footer.css"%></style>
</head>
<body style="background-color: black;">
	<header><%@ include file="header.jsp"%></header>
	<section><jsp:include page="${BODY}"/></section><br><br>
	<footer><%@ include file="footer.jsp"%></footer>
	
</body>
</html>