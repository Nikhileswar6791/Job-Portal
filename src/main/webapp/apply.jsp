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
<style>
.border{
padding:3%;
}
</style>
</head>
<body style=" background-color: #03fc98;">
<%@include file="all_component/navbar.jsp" %>
<c:if test="${userobj.role ne 'user' }">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
<%@page import="com.DB.DBConnect"%>

<div class = "container">
<form action="apply_job" method="post">

  <div class="form-group">
     <input type="hidden" value="<%= request.getParameter("job_id") %>" name="job_id"> 
    <label for="exampleFormControlInput1"><h2>Latest Education Details:</h2></label>
    <div class="border border-black rounded-top">
    Degree:<input type="text" name="e_title" class="form-control" id="exampleFormControlInput1" placeholder="title">
    College:<input type="text" name="e_college" class="form-control" id="exampleFormControlInput1" placeholder="title">
    Year Of Passing:<input type="text" name="e_pass" class="form-control" id="exampleFormControlInput1" placeholder="title">
  </div>
 </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1"><h2>XII education details:</h2></label></br>
    <div class="border border-black rounded-top">
    College:<input type="text" name="x_college" class="form-control" id="exampleFormControlInput1" placeholder="title">
    Year Of Passing:<input type="text" name="x_pass" class="form-control" id="exampleFormControlInput1" placeholder="title">
  </div>
  </div>
   <div class="form-group">
    <label for="exampleFormControlInput2"><h2>Skills:</h2></label>
    <input type="text" name="skills" class="form-control" id="exampleFormControlInput2" placeholder="skills">
  </div>
   <div class="form-group">
    <label for="exampleFormControlTextarea1"><h2>Experience:</h2></label>
   <textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="3"></textarea>
  </div>  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

<%@include file="all_component/footer.jsp" %>
</body>
</html>