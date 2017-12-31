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
<title>Order Confirmation</title>
</head>
<style>
table, th, td {
    
    border: 1px solid black;
    border-collapse: collapse;
	
}

.ts
{
width:1000px;
position:relative;
top:100px;
}
button {
    background-color:skyblue ;
    
    
    padding: 10px 25px;
    border: none;
    cursor: pointer;
    width:10%;
    border-radius:4px;
    position:relative;
    top:200px;
    left:700px;
}
</style>
<body>
<h2 style="position:relative;top:90px;">Billing Address</h2>
<table  class="ts" style="width:100%">
  <tr>
    <th style="text-align:center">EMAIL</th>
    <th style="text-align:center">MOBILE NO </th>
    <th style="text-align:center">CITY</th>
	<th style="text-align:center">COUNTRY</th>
	<th style="text-align:center">HOUSE NUMBER</th>
	<th style="text-align:center">PINCODE</th>
  </tr>


  <tr>
   <td style="text-align:center">${billing.getEmail()}</td>
   <td style="text-align:center">${billing.getMobile_No()}</td>
   <td style="text-align:center">${billing.getCity()}</td>
   <td style="text-align:center">${billing.getCountry()}</td>
   <td style="text-align:center">${billing.getHouse_No()}</td>
   <td style="text-align:center">${billing.getPinCode()}</td>
 </tr>
 </table><br></br><br></br>
 <h2 style="position:relative;top:100px">Shipping Address</h2>
<table  class="ts" style="width:100%">
  <tr>
    <th style="text-align:center">NAME</th>
    <th style="text-align:center">EMAIL</th>
	<th style="text-align:center">MOBILE NO</th>
    <th style="text-align:center">CITY</th>
	<th style="text-align:center">COUNTRY</th>
	<th style="text-align:center">HOUSE NUMBER</th>
	<th style="text-align:center">PINCODE</th>
  </tr> 
  <tr>
  <td style="text-align:center">${shippingAddress.getFirst_Name()}${shippingAddress.getLast_Name()}</td>
  <td style="text-align:center">${shippingAddress.getEmail()}</td>
  <td style="text-align:center">${shippingAddress.getMobile_No()}</td>
  <td style="text-align:center">${shippingAddress.getCity()}</td>
  <td style="text-align:center">${shippingAddress.getCountry()}</td>
  <td style="text-align:center">${shippingAddress.getHouse_No()}</td>
  <td style="text-align:center">${shippingAddress.getPinCode()}</td>
  </table><br></br><br></br>
  
  
  <table  class="ts" style="width:100%">
  <tr>
    <th style="text-align:center">PRODUCT IMAGE</th>
	<th style="text-align:center">PRODUCT NAME</th>
	<th style="text-align:center">CATEGORY NAME</th>
	<th style="text-align:center">SELLER NAME</th>
	<th style="text-align:center">PRICE</th>
  </tr>
  <c1:if test="${prot!=null}">
  <tr> 
  <td><img src="<c:url value='/resources/Images/${prot.getPid()}.jpg'/>" style="width:120px; height:100px;left:100px;bottom:1px;"></td>
  <td style="text-align:center">${prot.getPname()}</td>
  <td style="text-align:center">${prot.getCategory().getCname()}</td>
  <td style="text-align:center">${prot.getSupplier().getSname()}</td>
  <td style="text-align:center">${prot.getPprice()}</td>
  </tr></c1:if>


  

<%-- <c1:if test="${prot==null}"> --%>
<%--      <c1:forEach items="${cartItem1}" var="car"> --%>
<!--      <tr> -->
<%--      <td style="text-align:center"><img src="<c:url value='/resources/Images/${car.getProduct().getPid()}.jpg'/>" style="width:px; height:100px;left:100px;bottom:1px;"></td> --%>
<%--      <td style="text-align:center">${car.getProduct().getPname()}</td> --%>
<%--      <td style="text-align:center">${car.getProduct().getCategory().getCname()}</td> --%>
<%--      <td style="text-align:center">${car.getProduct().getSupplier().getSname()}</td> --%>
<%--      <td style="text-align:center">${car.getProduct().getPprice()}</td> --%>
<%--      </tr></c1:forEach></c1:elif> --%>

<c1:if test="${prot==null}">
<c1:forEach items="${cartItem1}" var="car">
 <tr>
     <td style="text-align:center"><img src="<c:url value='/resources/Images/${car.getProduct().getPid()}.jpg'/>" style="width:px; height:100px;left:100px;bottom:1px;"></td>
     <td style="text-align:center">${car.getProduct().getPname()}</td>
     <td style="text-align:center">${car.getProduct().getCategory().getCname()}</td>
     <td style="text-align:center">${car.getProduct().getSupplier().getSname()}</td>
     <td style="text-align:center">${car.getProduct().getPprice()}</td>
    </tr>
    </c1:forEach>
</c1:if>



</table>
<a href="<c:url value="/pay"/>"><button type="Submit" name="Submit" style="color:MediumVioletRed;font-size:20px;">Pay</button></a>
</body>

</html>


