<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>

<c:url value="/resources/css" var="sign"/>
<c:url value="/resources/images" var="img"/>
<link rel="stylesheet" type="text/css" href="${sign}/sign.css">


</head>


<body>

 <div class="container">
  
     <div class="lbl" style="color:white;"><h2><center>Create Account</center></h2></div>
      <hr>
              
     <c:url value="/addUser" var="user"/>
     <form:form action="${user}" method="post" commandName="user">
	 <table>
       <tr>
          <td style="margin-top : 20px"> <label>User Id</label><br></td>
       </tr>
       <tr>
          <td><form:input type="text" class="id" style="width :390px" path="uid" placeholder="Enter UserId"/> </td>
       </tr>
         
        <tr>
	         <td><label>User Name</label></td>
        </tr>
        <tr>
	           <td> <form:input type="text" class="user" name="name" path="uname"  placeholder="Enter User name"/></td>
	    </tr>
	       
         <tr>
           <td><label>Contact Number</label></td>
         </tr>
      
        <tr>
          <td><form:input type="tel" style="width :390px;" path="mobile" placeholder="Enter Mobile Number" name="phn"/> </td>   
        </tr>
       
       <tr>
          <td><label>Address</label></td>
       </tr>
       
       <tr>
           <td> <form:input type="text" style="margin-left:25px; margin-top:4px; width:390px; margin-bottom:4px;  border: 1px solid; border-radius : 6px; margin-bottom:4px;  padding :10px; padding-left :12px" path="uaddress" placeholder="Enter full address" name="mail"/><br></td>
       
       <tr>
         <td><label>Email id</label></td>
       </tr>
       
      <tr>
        <td><form:input type="text" class="id"  style="width:390px" placeholder="Enter Email id" path="umail"/> </td>
      </tr>

       <tr>
          <td><label>Create Password</label></td>
      
          <td><label>Confirm Password</label></td>
       </tr>

     <tr>
 <td> <form:input type="password"  placeholder="Enter password" path="upwd" name="mail"/></td> 
 <td> <form:input type="password"  placeholder="Re Enter password" path="rpwd" name="mail"/></td>
     </tr>
   
 </table>
    <hr>
   <input type="submit"  style="margin-top : 9px; background-color : #3b5998; color : white;" "value="Sumbit" name="sbt">
   <input type="reset"  style="margin-top : 9px; background-color : green; color : white;" value="Reset" name="rst">
    
   </form:form>
</div>
</div>

</body>

</html>