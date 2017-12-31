<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Nav.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank You</title>
<c:url value="/resources/Images" var="img"/>
<c:url value="/resources/StyleSheet" var="css"/>
<c:url value="/resources/js" var="js"/>
<title>Thank you</title>
<style>

h6{
font-size:80px;
color:blue;
font-family: Algerian;
position:relative;
left:450px;
}
</style>
</head>
<body>
<h6>Thank You!</h6>
<p style="position:relative;bottom:190px;left:520px;font-size:22px;">Your submission has been received.</p><br>
<p style="position:relative;bottom:230px;left:466px;font-size:28px;color:DeepPink ">online offers will be coming your way<p><br></br>
<p style="position:relative;bottom:300px;left:580px;font-size:30px;font-family:Brush Script MT;"><a href="<c:url value="/"/>">Continue Shopping</a></p>
</body>
</html>