<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Nav.jsp"%>
<c:url value="/resources/StyleSheet" var="css"/>
<link type="text/css" rel="stylesheet" href="${css}/StyleSheet.css">
<style>
.border table,.border td,.border th{
border-collapse: collapse;
border:1px solid black;
}</style></head>
<body>
<fieldset style="width:300px ;height:220px">
    <legend style="text-align:center">Billing Address</legend>
<form>
<table >
<tr><td>Billing_Id:</td>
<td><form:input type="text" path="user.billing.Bill_Id" name="bid"/></td>
</tr>
<tr><td>House Number:</td>
<td><form:input type="text" path="user.billing.House_No" name="hn"/></td>
</tr>
<tr><td>Country:</td><td><form:input type="text" path="user.billing.Country" name="country"/></td></tr>
<tr><td>City:</td><td><form:input type="text" path="user.billing.City" name="city"/></td></tr>
<tr><td>Pincode:</td><td><form:input type="text" path="user.billing.PinCode" name="pin" /></td></tr>
<tr><td>Email Address:</td><td><form:input type="text" path="user.uemail" name="email"/></td></tr>
<tr><td>Phone Number:</td><td><form:input type="tel" path="user.uph"  name="usrtel" /></td></tr>

</table></form></fieldset>
    <fieldset style="width:300px ;height:320px"><legend style="text-align:center">Shiiping Address</legend>


<c:url value="/orderConfirm" var="con"/>
<form:form action="${con}" commandName="shipping" method="post">
<table>
<tr><td>Shipping_Id:</td>
<td><form:input type="text" path="Shiping_Id" name="sid"/></td>
</tr>
<tr><td>First Name</td><td><form:input type="text" path="First_Name" name="fname"/></td></tr>
<tr><td>Last Name</td><td><form:input type="text" path="Last_Name" name="lname"/></td></tr>
<tr><td>Country:</td><td><form:input type="text" path="Country" name="country"/></td></tr>
<tr><td>House Number:</td>
<td><form:input type="text" path="House_No" name="hn"/></td>
</tr>
<tr><td>Country:</td><td><form:input type="text"  path="Country" name="country"/></td></tr>
<tr><td>City:</td><td><form:input type="text" path="City" name="city"/></td></tr>
<tr><td>Pincode:</td><td><form:input type="text" path="PinCode" name="pin" /></td></tr>
<tr><td>Email Address:</td><td><form:input type="text" path="Email" name="email" /></td></tr>
<tr><td>Phone Number:</td><td><form:input type="tel" path="Mobile_No" name="usrtel" /></td></tr>
<tr><td></td><td style="padding-left:30px"><input type="submit" value="Submit" name="submit"/>
<input type="reset" value="Reset" name="reset"/></td></tr></table>
</form:form>
</fieldset>
</body>
</html>

