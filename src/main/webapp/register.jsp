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
<div class= "container">
<form action="register" method="post">
  <div class="form-group">
    <label for="name">name</label>
    <input type="text" name="name" class="form-control" id="name" placeholder="name">
  </div>
  
  <div class="form-group">
    <label for="email">email</label>
    <input type="text" name="email" class="form-control" id="email" placeholder="email">
  </div>
  
  <div class="form-group">
    <label for="password">password</label>
    <input type="password" name="password" class="form-control" id="password" placeholder="password">
  </div>
  
  <div class="form-group">
    <label for="qualification">qualification</label>
    <input type="text" name="qualification" class="form-control" id="qualification" placeholder="qualification">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
<%@include file="all_component/footer.jsp" %>
</body>
</html>