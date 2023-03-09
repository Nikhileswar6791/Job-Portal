<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@ include file="all_component/all_css.jsp" %>
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<c:if test="${userobj.role ne 'company' }">
<c:redirect url="login.jsp"></c:redirect>
</c:if>

<div class = "container" style=" background-color: #03fc98;">
<form action="delete_job" method="post">
  <div class="form-group">
    <label for="exampleFormControlInput1">Enter the Job ID that you want to delete</label>
    <input type="text" name="job_id" class="form-control" id="exampleFormControlInput1" placeholder="title">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

<%@include file="all_component/footer.jsp" %>
</body>
</html>