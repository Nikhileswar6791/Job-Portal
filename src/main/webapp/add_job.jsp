<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@page import="com.entity.company"%>
<%@page import="com.dao.CompanyDao"%>
<%@page import="com.DB.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@ include file="all_component/all_css.jsp" %>
</head>
<body style=" background-color: #03fc98;">
<%@include file="all_component/navbar.jsp" %>
<c:if test="${userobj.role ne 'company' }">
<c:redirect url="login.jsp"></c:redirect>
</c:if>

<div class = "container">
<form action="add_job" method="post">

  <div class="form-group">
    <label for="exampleFormControlInput1">title</label>
    <input type="text" name="title" class="form-control" id="exampleFormControlInput1" placeholder="title">
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">description</label>
    <textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="3"></textarea>
  </div>
   <div class="form-group">
    <label for="exampleFormControlInput2">skills:</label>
    <input type="text" name="skills" class="form-control" id="exampleFormControlInput2" placeholder="skills">
  </div>
   <div class="form-group">
    <label for="exampleFormControlInput3">Salary:</label>
    <input type="text" name="salary" class="form-control" id="exampleFormControlInput3" placeholder="salary">
  </div>  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

<%@include file="all_component/footer.jsp" %>
</body>
</html>