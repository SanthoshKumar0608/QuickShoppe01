<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/images" var="img"/>
<link rel="stylesheet" type="text/css" href="${css}/supplier.css">
</head>

<body>

 <div class="container">
 <c:url value="/addSupplier" var="supplier"/>
   <form:form action="${supplier}" method="post" commandName="supplier">
    
     <h2>Supplier Details</h2>

     <hr>

   <table>
      
       <tr>
       <td><label class="lb">Supplier Id </label></td>
      </tr>

         <tr>
           <td> <form:input type="text" path="sid" placeholder="Enter Customer id"/><br></td>
         </tr>

       <tr>
          <td><label class="lb">Name</label></td>        
              
       </tr>

        <tr>
           <td><form:input type="text" class="sname" name="sname" path="sname" placeholder="Enter Supplier Name"/></td> 
        </tr> 

       <tr>
              <td> <label class="lb">Number</label></td>
        </tr>
        </tr>
      
                   <td> <form:input type="tel" placeholder="Enter Mobile Number" path="snumber" name="phn"/> </td>
       </tr>

       <tr>
              <td> <label class="lb" style="margin-right :20px; ">Address</label></td>
        </tr>
         </tr>
                     <td><form:textarea  style="width :305px; margin-left :15px; border-radius : 10px; padding-left : 10px;"	placeholder="Enter your full address" path="sadd" name="mail"/></textarea></td>
        </tr>
   </table>
     <hr>

<table>
    <tr>
       <td><input type="submit"  style="width :140px; color : white; margin-left : 20px;" value="Add Supplier" name="sbt"></td>
       <td> <input type="reset"  style="width :140px;  background-color : #3b5998; color : white;" value="Reset" name="rst"></td>
</table>
  </form:form>
  </div>
  
  <div class="container" style="margin-top : 20px; width:310; margin-left:500; padding:20; color:white;">
   <table> 
    <tr>
          <th>Supplier Id</th>        
     
          <th>Name</th>   
          <th>Number</th>   
          <th>Address</th>     
      
          <th> Edit</th>        
              
          <th> Delete</th>     
       </tr>

<c1:forEach items="${suppliers}" var="supp">
        <tr>
           
         <td>${supp.getSid()}</td>
           <td>${supp.getSname()}</td>
           <td>${supp.getSnumber()}</td>
            <td>${supp.getSadd()}</td>
           <td><a href="<c:url value="/editSupplier/${supp.getSid()}"/>">Edit</a></td>
           <td><a href="<c:url value="/deleteSupplier/${supp.getSid()}"/>">Delete</a></td>
        
        </tr> 
   </c1:forEach>
   
   </table>
</div>

</body>

</html>