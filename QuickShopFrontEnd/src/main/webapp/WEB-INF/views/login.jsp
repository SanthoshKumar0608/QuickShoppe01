<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
body{
     padding :0px;
     margin :0px;
     background: url(background.jpeg) no-repeat;
     background-size :100% 710px;
    
    }

.container{
	    background-color : white;
            width : 400px;
   	    height : 270px;
	    margin-left : 500px;
            margin-top : 70px;
            border-radius: 25px;
     
          }
.container h1{
               text-align :center;
	      padding-top : 20px;

             }
.container input{
		   margin-left   : 50px;
  		   margin-bottom : 10px;
                   width : 300px;
	           height : 35px;
                   border: 1px solid;
                   border-radius: 5px;
                  } 
a{
  text-decoration :none;
  padding-right :40px;
   padding-left :60px;
 }
  
.login{
	    background-color : #3b5998;
            text-shadow: 4px 4px 2px rgba(59,89,152, 0.8);
	    color : white;
            font-size :15px;
            font-weight :bold;
}
 
input.login {
             margin-bottom: 1;
             }

.user 
{  
background: url(user.png) no-repeat;  
background-size: 20px 20px; 
background-position: 0 50%;  
padding-left: 30px;
 
}  

.pass 
{  
background: url(user.png) no-repeat;  
background-size: 20px 20px; 
background-position: 0 50%;  
padding-left: 30px;  
} 
</style>
</head>
<body>


 <div class="container">
 
     <h1>Log In </h1>
     <form action="<c:url value="/j_spring_security_check"/>" method="post">
       <div> <input type="text" class="user" name="j_username" placeholder="Enter Your User Name"/><br>
       
       <input type="password" class="pass" name="j_password" placeholder="Enter Your Password"/><br>
       <input type="submit" class="login" value="Login"/></div><br>

            <div> <a href="/User"> Sing Up</a>
            <a href="#"> Forgoten Password?</div>
   </form>

 </div>

</body>
</html>