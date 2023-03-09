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
<body style=" background-color: #03fc98;">
<%@include file="all_component/navbar.jsp" %>
<c:if test="${userobj.role ne 'admin' }">
<c:redirect url="login.jsp"></c:redirect>
</c:if>


<form action="company_status" method="post">
  <div class="form-group">
    <label for="c_id">company ID:</label>
    <input type="text" name = "c_id" class="form-control" id="c_id" placeholder="Company ID">
  </div>
  <div class="form-group">
    <label for="status">status</label>
    <select class="form-control" name="status" id="status">
      <option>yes</option>
      <option>no</option>
    </select>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


<%@include file="all_component/footer.jsp" %>
</body>
</html>