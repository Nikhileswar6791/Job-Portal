<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@ include file="all_component/all_css.jsp" %>
</head>
<body style=" background-color: #03fc98;">
<%@include file="all_component/navbar.jsp" %>
<div class = "container">
<form action="add_company" method="post">
  <div class="form-group">
    <label for="c_name">Company name</label>
    <input type="text" name="c_name" class="form-control" id="c_name" placeholder="Company Name">
  </div>
  
  <div class="form-group">
    <label for="c_mail">email</label>
    <input type="email" name="c_mail" class="form-control" id="c_mail" placeholder="email">
  </div>
   <div class="form-group">
    <label for="c_city">city</label>
    <input type="text" name="c_city" class="form-control" id="c_city" placeholder="city">
  </div>
   <div class="form-group">
    <label for="about">about</label>
    <textarea type="text" name="about" class="form-control" id="about" placeholder="about"></textarea>
  </div>
  <div class="form-group">
    <label for="password">password</label>
    <input type="password" name="password" class="form-control" id="password" placeholder="password">
  </div>  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
<%@include file="all_component/footer.jsp" %>
</body>
</html>