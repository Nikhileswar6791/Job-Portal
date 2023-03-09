<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.JobDao"%>
<%@page import="com.entity.Jobs"%>
<%@page import="java.util.List" %>
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
<c:if test="${userobj.role ne 'company' }">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
<% JobDao dao=new JobDao(DBConnect.getConnction());
List<Jobs> jlist = dao.getAllJobs();
for(Jobs j:jlist) {%>
	
	<div class="card container" style="width: 18rem;background-color:#B0E0E6;">
  
  <div class="card-body">
    Title:<h5 class="card-title"> <%=j.getTitle() %></h5>
    Description:<p class="card-text"><%=j.getDescription() %></p>
    Skills Required:<p class="card-text"><%=j.getskills() %></p>
    Salary:<p class="card-text"><%=j.getsalary() %></p>
    Status:<p class="card-text"><%=j.getStatus() %></p>
     ID:<p class="card-text"><%=j.getId() %></p>
  </div>
</div>
<%} %>

<%@include file="all_component/footer.jsp" %>
</body>
</html>