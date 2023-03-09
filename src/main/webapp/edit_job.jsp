<%@page import="com.dao.JobDao"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.entity.Jobs"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edir job</title>
<%@ include file="all_component/all_css.jsp" %>
</head>
<body style=" background-color: #03fc98;">
<%@include file="all_component/navbar.jsp" %>
<c:if test="${userobj.role ne 'company' }">
<c:redirect url="login.jsp"></c:redirect>
</c:if>
<% 
int id= Integer.parseInt(request.getParameter("job_id"));
JobDao dao=new JobDao(DBConnect.getConnction());
Jobs job = dao.getJobByID(id);
%>

<form action="update_job" method="post">
<input type="hidden" value="<%= job.getId() %>" name="job_id"> 
  <div class="form-group">
    <label for="exampleFormControlInput1">title</label>
    <input type="text" name="title" value="<%=job.getTitle() %>" class="form-control" id="exampleFormControlInput1" placeholder="title">
  </div>
  
  <div class="form-group">
    <label for="exampleFormControlInput2">Salary</label>
    <input type="text" name="salary" value="<%=job.getsalary() %>" class="form-control" id="exampleFormControlInput2" placeholder="Salary">
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput3">Status</label>
    <input type="text" name="status" value="<%=job.getStatus() %>" class="form-control" id="exampleFormControlInput3" placeholder="Status">
  </div>
   <div class="form-group">
    <label for="exampleFormControlInput4">Skills</label>
    <input type="text" name="skills" value="<%=job.getskills() %>" class="form-control" id="exampleFormControlInput4" placeholder="Skills">
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">description</label>
    <textarea class="form-control" name="description" id="exampleFormControlTextarea1" rows="3"><%= job.getDescription() %></textarea>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


<%@include file="all_component/footer.jsp" %>
</body>
</html>