<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<%@ include file="Nav.jsp"%>
<c:url value="/resources/image" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>
<link href="${css}/bootstrap.min.css">
<title>Cart</title>
</head>
<style>
table, th, td  {
    
    border: 1px solid black;
    border-collapse: collapse;
	
}

.ts
{
width:1000px;
position:relative;
top:100px;
left:160px;
}
 center
 {
 position:relative;
 top:200px;
 }
</style>
<body>
<table  class="ts" style="width:"100%">

  <tr>
    <th style="text-align:center">CARTITEM ID</th>
    <th style="text-align:center">PRODUCT NAME</th> 
    <th style="text-align:center">DESCRIPTION</th>
    <th style="text-align:center">QUANTITY</th>
	<th style="text-align:center">PRICE</th>
	<!-- 	<th style="text-align:center">GRAND TOTAL</th> -->
	<th style="text-align:center">BUY/REMOVE</th>
	
  </tr>
  <c1:forEach items="${cartItem}" var="crt">
  <tr>
  <td>${crt.getCartitem_Id()}</td>
  <td>${crt.getProduct().getPname()}</td>
  <td>${crt.getProduct().getPdiscription()}</td>
  <td>${crt.getProduct().getPquantity()}</td>
  <td>${crt.getProduct().getPprice()}</td>
  
<%--   <td>${crt.getCart().getGrand_total()}</td>  --%>
  <td><a href="<c:url value='/Remove/${crt.getCartitem_Id()}'/>">Remove</a>&nbsp;/&nbsp;<a href="<c:url value='/Buy/${crt.getProduct().getPid()}/${crt.getCartitem_Id()}'/>">Buy</a></td>
  </tr> </c1:forEach>
</table>
<center> <h2>Total price=${gtotal}</h2></center>
<center> <a href="<c:url value='Removeall'/>">Remove All</a>&nbsp/&nbsp<a href="<c:url value='/Buyall'/>">Buy All</a>
</center>
 
</body>

</html>