<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.CompanyDao"%>
<%@page import="com.entity.company"%>
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
<c:if test="${userobj.role ne 'admin' }">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
<% CompanyDao dao=new CompanyDao(DBConnect.getConnction());
List<company> jlist = dao.getAllCompanies();
for(company j:jlist) {%>
	
	<div class="card container" style="width: 18rem;background-color:#B0E0E6;">
  
  <div class="card-body">
    Company Name:<h5 class="card-title"> <%=j.getC_name() %></h5>
    Description:<p class="card-text"><%=j.getDescription() %></p>
    City:<p class="card-text"><%=j.getcity() %></p>
    Status:<p class="card-text"><%=j.getStatus() %></p>
    Mail:<p class="card-text"><%=j.getmail() %></p>
    ID:<p class = "card_text"><%=j.getId() %></p>
  </div>
</div>
<%} %>

<%@include file="all_component/footer.jsp" %>
</body>
</html>