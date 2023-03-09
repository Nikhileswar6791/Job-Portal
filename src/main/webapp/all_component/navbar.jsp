<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #03fc98;">
  <a class="navbar-brand" href="#">JobPortal</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      
      <c:if test="${userobj.role eq 'admin'}">
      		<li class="nav-item"><a class="nav-link" href="change.jsp"><i class="fas fa-plus-circle"></i>Change Company Status</a></li>
      		<li class="nav-item"><a class="nav-link" href="view_companies.jsp"><i class="fas fa-eye"></i>View companies</a></li>
      </c:if>
      <c:if test="${userobj.role eq 'company'}">
      		<li class="nav-item"><a class="nav-link" href="add_job.jsp"><i class="fas fa-plus-circle"></i><span style = "font-size:15px;">Add Jobs</span></a></li>
      		<li class="nav-item"><a class="nav-link" href="view_jobs.jsp"><i class="fas fa-eye"></i><span style = "font-size:15px;">View Jobs</span></a></li>
      		<li class="nav-item"><a class="nav-link" href="delete _jobs.jsp"><i class="fas fa-eye"></i><span style = "font-size:15px;">Delete Jobs</span></a></li>
      		 <li class="nav-item"><a class="nav-link" href="applied_people.jsp"><i class="fas fa-eye"></i><span style = "font-size:15px;">Applied People</span></a></li>
      		<form class="form-inline my-2 my-lg-0" action = "edit_job.jsp" method = "post">
      		   <input class="form-control mr-sm-2" type="text" name = "job_id"placeholder="Enter the job id to update" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><span style = "font-size:15px;">Update Job</span></button>
     
      </form>
      
      </c:if>
      
      <c:if test="${userobj.role eq 'user'}">      		
      		<li class="nav-item"><a class="nav-link" href="all_jobs.jsp"><i class="fas fa-eye"></i>View Jobs</a></li>
      		<li class="nav-item"><a class="nav-link" href="applied_jobs.jsp"><i class="fas fa-eye"></i>View Applied Jobs</a></li>
      </c:if>
      
    </ul>
    
    	<c:if test="${not empty userobj }">
    		
    		<c:if test="${userobj.role eq 'admin' }">
    			<a href="admin.jsp" class="btn btn-light mr-1"><i class="fas fa-sign-in-alt"></i>Admin</a>
    		</c:if>
    		<c:if test="${userobj.role eq 'user' }">
    			<a href="admin.jsp" class="btn btn-light mr-1"><i class="fas fa-sign-in-alt"></i>${userobj.name}</a>
    		</c:if>
			<c:if test="${userobj.role eq 'company' }">
    			<a href="admin.jsp" class="btn btn-light mr-1"><i class="fas fa-sign-in-alt"></i>${userobj.c_name}</a>
    		</c:if>
			<a href="logout" class="btn btn-light"><i class="fas fa-user"></i>Logout</a>
		</c:if>	
		<c:if test="${empty userobj }">
			<a href="login.jsp" class="btn btn-light mr-1" ><i class="fas fa-sign-in-alt"></i>Login</a>
			<a href="register.jsp" class="btn btn-light"><i class="fas fa-user"></i>Signup</a>
		</c:if>
		<div style = "padding-left:5px;">
    	<c:if test="${empty userobj }">
			<a href="company.jsp" class="btn btn-light"><i class="fas fa-user"></i>Recruiter</a>
		</c:if>
		</div>
  </div>
</nav>
<div class="container">
	<c:if test="${not empty succMsg}">
		
		<h4 class="alert alert-primary" role="alert">${succMsg}</h4>
		<c:remove var="succMsg" />
	</c:if>
	</div>