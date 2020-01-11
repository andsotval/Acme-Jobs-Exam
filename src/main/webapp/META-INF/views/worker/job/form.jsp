<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="worker.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="worker.job.form.label.title" path="title"/>
	<acme:form-moment code="worker.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="worker.job.form.label.salary" path="salary"/>
	<acme:form-url code="worker.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="worker.job.form.label.description" path="description"/>
  	
  	<acme:form-submit 
		method="get" 
		code="worker.job.form.button.employer" 
		action="/worker/employer/show-by-job?id=${id}"/>
  	<acme:form-submit 
		method="get" 
		code="worker.job.form.button.duty" 
		action="/worker/duty/list?id=${id}"/>
	<acme:form-submit 
		method="get" 
		code="worker.job.form.button.wotela" 
		action="/worker/wotela/show-by-job?id=${id}"/>
	<acme:form-submit 
		method="get" 
		code="worker.job.form.button.auditrecord" 
		action="/worker/auditrecord/list-by-job?id=${id}"/>
  	<acme:form-return code="worker.job.form.button.return"/>
</acme:form>