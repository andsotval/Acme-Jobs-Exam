<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="authenticated.job.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="authenticated.job.form.label.salary" path="salary"/>
	<acme:form-url code="authenticated.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="authenticated.job.form.label.description" path="description"/>
  	
  	<acme:form-submit 
		method="get" 
		code="authenticated.job.form.button.employer" 
		action="/authenticated/employer/show-by-job?id=${id}"/>
  	<acme:form-submit 
		method="get" 
		code="authenticated.job.form.button.duty" 
		action="/authenticated/duty/list?id=${id}"/>
	<acme:form-submit 
		method="get" 
		code="authenticated.job.form.button.wotela" 
		action="/authenticated/wotela/show-by-job?id=${id}"/>
	<acme:form-submit 
		method="get" 
		code="authenticated.job.form.button.auditrecord" 
		action="/authenticated/auditrecord/list-by-job?id=${id}"/>
	<acme:form-submit 
		test ="${principal.authorities[0]=='AUTH_Worker'}"
		method="get" 
		code="worker.job.form.button.apply" 
		action="/worker/application/create?id=${id}"/>
  	<acme:form-return code="authenticated.job.form.button.return"/>
</acme:form>
