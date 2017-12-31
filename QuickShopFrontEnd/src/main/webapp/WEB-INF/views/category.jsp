<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/images" var="img"/>
<link rel="stylesheet" type="text/css" href="${css}/Cat.css">
<style>
body{
 
 background-color : blue;
 }
</style>
</head>


<body style="margin-top:1;">
<h2 style="color:white"> </h2>
 <div class="container" style="height:300; margin-top:1;">
 
 
  
     <h2>Category Details</h2>

     <hr>
     
     <c:url value="/addCategory" var="addcat"/>
     <form:form action="${addcat}" method="post" commandName="category">
     <table>
      
       <tr>
       <td><label style="class="lb">Category Id </label></td>
      </tr>

         <tr>
           <td> <form:input type="text" placeholder="Enter Category id"  path="catid"/><br></td>
         </tr>

       <tr>
          <td><label class="lb">Name</label></td>        
              
       </tr>

        <tr>
           <td><form:input type="text" class="sname" placeholder="Enter Category Name" name="cname" path="catname"/></td> 
        </tr> 

        </table>
     <hr>

<table>
    <tr>
       <td><input type="submit"  style="width :140px; color : white; margin-left : 20px;" value="Add Cateory" name="sbt"></td>
       <td> <input type="reset"  style="width :140px;  background-color : #3b5998; color : white;" value="Reset" name="rst"></td>
</table>


   </form:form>
</div>

  <div class="container" style="margin-top : 20px; width:310; margin-left:500; padding:20; color:white;">
   <table> 
    <tr>
          <th>Category Id</th>        
     
          <th>Category Name</th>        
      
          <th> Edit</th>        
              
          <th> Delete</th>     
       </tr>

<c1:forEach items="${categories}" var="cat">
        <tr>
           
           <td>${cat.getCatid()}</td>
           <td>${cat.getCatname()}</td>
           <td><a href="<c:url value="/editCategory/${cat.getCatid()}"/>">Edit</a></td>
           <td><a href="<c:url value="/deleteCategory/${cat.getCatid()}"/>">Delete</a></td>
        
        </tr> 
   </c1:forEach>
   
      
     
   </table>
</div>
 
</body>

</html>