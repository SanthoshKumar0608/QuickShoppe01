<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<html>
	<head>
		  <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		  <c:url value="resources/images" var="img"/>
          <style>
              button{ 
              	                 height: 33.5px;
                     }

          </style>
		 
	</head> 

		<div class="navbar navbar-default" style="background-color :#243a51; color: white; margin : 0;" >
		   <div class="container-fluid">
		       <div class="navbar-header">
		            <div class="brand"> <img src="quick1.png" style="height : 60px; width: 100px; padding: 0;"> <b style="font-size: 25px;">Quick Shop</b>
                      
                    </div> <!-- Close Navbar Brand -->
		       </div><!-- Close Navbar Header-->
                            <div class="container-fluid">
		                        <div class="nav navbar-right">
			                         <div class="glyphicon glyphicon-phone" style="padding-top: 5px;"> 9483834393 </div><br>
			                         <div class="glyphicon glyphicon-envelope" style="padding-top: 10px;"> support@quickshop.com </div>
			                    </div>
		    
					            <ul class="nav navbar-nav navbar-right" style="margin-right: 50px"  >
			                        <li>
			                            <form class=" navbar-form "  role="search">
			                                <div class="input-group">
			                                    <input type="text" class="form-control" placeholder="Search product name or brand " name="q" style="width: 600px;">
			                                        <div class="input-group-btn">
			                                           <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			                                        </div> <!-- Form-control -->
			                                </div> <!-- Input Group -->
			                            </form> <!-- Navbar-form -->
			                        </li>
			                    </ul>
                            </div> <!-- Close Container -->
            </div> <!-- Close Container -->
		</div> <!-- Close Navbar Default-->

	    <div class="navbar navbar-default" style="background-color :#243a51;">
				    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#abc">
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				    </button>
					    <div class="container-fluid">
						    <div class="collapse navbar-collapse" id="abc">
							    <ul class="nav navbar-nav" style="color: white;">	     
							      <li ><a href="#" style="color: white;">Home</a></li>
							        <c1:if test="${pageContext.request.userPrincipal.name!=null}"> 
                                           <security:authorize access="hasRole('ROLE_ADMIN')"> 
							      <li><a href="<c:url value="/Category"/>" style="color: white;">Categaory</a></li>
							      <li><a href="<c:url value="/Product"/>" style="color: white;">Product</a></li>
							      <li><a href="<c:url value="/Supplier"/>" style="color: white;">Supllier</a></li>
							          </security:authorize></c1:if>
							      <li><a href="#" style="color: white;">Contact Us</a></li>
							    </ul>

							
							   
								<ul class="nav navbar-right navbar-nav" >	
							<c1:if test="${pageContext.request.userPrincipal.name == null}">     
								    <li><a class="glyphicon glyphicon-user" href="<c:url value="/User"/>" style="color: white;"> SignUp</a></li>
                                    <li><a class="glyphicon glyphicon-user" href="<c:url value="/login"/>" style="color: white;"> Login</a></li>
								</c1:if>
								<c1:if test="${pageContext.request.userPrincipal.name!= null}"> 
							
								<li style="float:right"> <a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
								<li style="float:right; color:#f8ee2e; font-size:18px; border:none;">Welcome ${pageContext.request.userPrincipal.name}!</li>
					
							</c1:if>
							</ul>	
							
								
							
							</div>	 <!--collapse navbar-collapse -->
					    </div> <!-- Container-fluid -->
	    </div> <!-- Navbar-default-->
    
 <!---- Carousel----->

 <!---- <div class="container-fluid">--->
     <div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-bottom : 0px;">
                                        <! Indicators --->
         <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
         </ol>
                                       <! Indicators --->
         <div class="carousel-inner">
          <div class="item active"><img src="${img}/Desert.jpg" style="width :100%; height : 300px;" alt="first">
                               <div class="carousel-caption">
                                              First Image 
                                </div> <!-- Carousel Caption -->
          </div> <!-- item active -->
          <div class="item"><img src="${img}/Jellyfish.jpg" style="width :100%; height : 300px;"alt="second" class="img-responsive">
                                 <div class="carousel-caption">
                                             Second Image 
                                </div> <!-- Carousel Caption -->
          </div> <!-- item active -->
          <div class="item"><img src="${img}/Hydrangeas.jpg" style="width :100%; height : 300px;" alt="second">
                                   <div class="carousel-caption">
                                              Third Image 
                                </div> <!-- Carousel Caption -->
          </div> <!-- item active -->
          <a class="left carousel-control" href="#myCarousel" data-slide="prev">
              <span class="glyphicon glyphicon-chevron-left"></span>
              <span class="sr-only">Previous</span>
         </a>

           <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
               <span class="sr-only">Next</span>
          </a>
          
       
         
         
         
         </div> <!---- class="carousel-inner" --->

     <div> <!---- Close  id="myCarousel" class="carousel slide"  ---->

 <!---- </div><!---- Close Container --->
</html>