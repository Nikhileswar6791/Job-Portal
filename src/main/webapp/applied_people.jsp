<%@page import="com.DB.DBConnect"%>
<%@page import="com.dao.ApplyDao"%>
<%@page import="com.entity.apply"%>
<%@page import="com.entity.company"%>
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
<c:if test="${userobj.role ne 'company' }">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
<% 
company comp = (company) session.getAttribute("userobj");
int x = comp.getId();
ApplyDao dao=new ApplyDao(DBConnect.getConnction());
List<apply> jlist = dao.getpeople_applied(x);
for(apply j:jlist) {%>
	<div class="card container" style="width: 18rem;background-color:#B0E0E6;">	  
	  <div class="card-body">
	  
	    JobID<h5 class="card-title"> <%=j.getId() %></h5>
	    Email:<p class="card-text"><%=j.getemail() %></p> 
	    Degree:<p class="card-text"><%=j.get_eTitle() %></p>
	    College:<p class="card-text"><%=j.get_eCollege() %></p>
	    Year of Passing:<p class="card-text"><%=j.get_ePass() %></p>
	    12th College:<p class="card-text"><%=j.get_xCollege() %></p>
	    12th Year of Passing:<p class="card-text"><%=j.get_xPass() %></p>
	    experience:<p class="card-text"><%=j.getDescription() %>" </p> 
	    skills:<p class="card-text"><%=j.getskills() %></p>
	    status:  <p class="card-text"><%=j.getStatus() %></p>
	    <form action = "accept_reject" method = "post">
	     <input type="hidden" value="<%= j.getemail() %>" name="mail"> 
	    <button type = "submit" name="button1" class="btn btn-success">Accept</button>
	    <button type = "submit" name="button2" class="btn btn-danger">Reject</button>
	    </form>
	  </div>
	</div>
<%} %>

<%@include file="all_component/footer.jsp" %>
</body>
</html>