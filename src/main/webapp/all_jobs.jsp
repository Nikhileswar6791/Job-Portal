<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.JobDao"%>
<%@page import="com.entity.Jobs"%>
<%@page import="java.util.List" %>
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

<%--<c:if test="${not empty succMsg}">
	<h4 class="text-center text-danger">${succMsg}</h4>
	<c:remove var="succMsg" />
	</c:if>
 	 --%>
<c:if test="${userobj.role ne 'user' }">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
<% JobDao dao=new JobDao(DBConnect.getConnction());
List<Jobs> jlist = dao.getAllJobs();
for(Jobs j:jlist) {%>
	<div class="card container" style="width: 18rem;background-color:#B0E0E6;">	  
	  <div class="card-body">
	   Title: <h5 class="card-title"> <%=j.getTitle() %></h5>
	    Description:<p class="card-text"><%=j.getDescription() %></p>
	    Skills Required:<p class="card-text"><%=j.getskills() %></p>
	    Salary:<p class="card-text"><%=j.getsalary() %></p>
	   Status: <p class="card-text"><%=j.getStatus() %></p>
	    <form action = "apply.jsp">
	    <input type="hidden" value="<%= j.getId() %>" name="job_id"> 
	    
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Apply Job</button>
	    </form>	    
	  </div>
	</div>
<%} %>

<%@include file="all_component/footer.jsp" %>
</body>
</html>