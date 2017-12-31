<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/images" var="img"/>
<link rel="stylesheet" type="text/css" href="${css}/product.css">

</head>


<body>

 <div class="container">
 <c:url value="/addProduct" var="prod"/>
   <form:form action="${prod}" method="post" commandName="product" enctype="multipart/form-data">
     <div class="lbl" style="color: white;"><h2><center>Product Details</center></h2></div>
      <hr>

       <div style="margin-top : 20px;"><label>Product Id</label><br></div>
       <form:input type="text" class="pid" path="pid" style="width :390px; " placeholder="Enter Product Id"/>
         
       <table>
        <tbody>
             <tr>
	       <td><label>Product Name</label></td>
             </tr>
             	
             <tr>
               <td> <form:input type="text" style="width :390px" class="pname" name="pname" path="pname" placeholder="Enter product name"/></td>
             </tr>
       </tbody>
    </table>

  <table>
    <tbody>
     <tr>
        <td><label>Description</label></td>
     </tr>
      
      <tr>
       <td>
    <form:textarea class= "desp" name="pdesp" path="pdesp" style="width :390px height :50px padding-top : 8px" placeholder="Description of product"/></textarea></td>
 
          </tr>
  </table>
     
    
  <table>
    <tbody>
     <tr>
      <td><label>Price</label></td>
      <td><label>Quantity</label></td>
     </tr>

     <tr>
      <td> <form:input type="text" path="price" placeholder="Enter price" name="price"/></td>  
      <td> <form:input type="text"  path="qty" placeholder="Total quantity" name="qlty"/></td>
     </tr>
    </tbody>
  </table>

<table>
    <tbody>
     <tr>
      <td><label>Category Name</label></td>
      <td><label>Supplier Name</label></td>
     </tr>

     <tr>
      <td><form:select path="category.catid" style="margin-left:30px; margin-top:2px; width : 200px; border-radius=5"> 
      <c1:forEach  items="${categories}" var="cat" > 
      <option value="${cat.getCatid()}" label="${cat.getCatname()}"> ${cat.getCatname()}</option>
      </c1:forEach>
      </form:select></td>
      
      <td><form:select path="supplier.sid"> 
      <c1:forEach  items="${suppliers}" var="sup"> 
     <option value="${sup.getSid()}" label="${sup.getSname()}">${sup.getSname()} </option>
      </c1:forEach> </form:select>
      <tr><td><form:input path="pimg" type="file" name="image" value="Upload file"/></td></tr>
     </td> 
     </tr>	
    </tbody>
  </table>
 <td><label>Select Product</label></td>
<%-- <form:input type="file" style="width:390px padding :4px background : white"/> --%>
<hr>

<div class="footer">

   <input type="submit"  style="margin-top : 10px; background-color : #3b5998; color : white;" value="Add Produt" name="sbt">
   <input type="reset"  style="margin-top : 10px; background-color : #3b5998; color : white;" value="Reset" name="rst">

</div>
</form:form>

<div class="container" style="margin:5px; width:670px; margin-top:100px; margin:c;">
   <table> 
    <tr>
     <th> Image </th>   
          <th>Product Id</th>        
     
          <th>Product Name</th>    
             
          <th>Description</th> 
         
          <th>Price</th> 
          <th>Quantity</th> 
          <th>Category Name</th>
          <th>Supplier Name</th>
           
          <th> Edit</th>        
              
          <th> Delete</th>  
         
       </tr>

 <c1:forEach items="${products}" var="prod">
        <tr>
               
           <td><img src="<c:url value="/resources/images/${prod.getPid()}.jpg"/>" style="width:100px; height:100px; margin-left:15px;"></td>
           <td>${prod.getPid()}</td>
           <td>${prod.getPname()}</td>
           <td>${prod.getPdesp()}</td>
           <td>${prod.getPrice()}</td>
           <td>${prod.getQty()}</td>
          <td>${prod.getCategory().getCatid()}</td>
          <td>${prod.getSupplier().getSid()}</td>
           
          
           <td><a href="<c:url value="/editProduct/${prod.getPid()}"/>">Edit</a></td>
           <td><a href="<c:url value="/deleteProduct/${prod.getPid()}"/>">Delete</a></td>
        
        </tr> 
   </c1:forEach>
   
   </table>
</div>
</body>

</html>