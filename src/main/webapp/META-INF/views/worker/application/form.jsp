<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="${command == 'show'}" >
 	<acme:form-hidden path="job.id"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-textbox code="worker.application.form.lable.job.employer.identity.fullName" path="job.employer.identity.fullName"/>
		<acme:form-textbox code="worker.application.form.lable.job.title" path="job.title"/>
	</jstl:if>
	<acme:form-textbox code="worker.application.form.lable.referenceNumber" path="referenceNumber"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="worker.application.form.lable.creationMoment" path="creationMoment"/>
	</jstl:if>
	<acme:form-textarea code="worker.application.form.lable.statement" path="statement"/>
	<acme:form-textarea code="worker.application.form.lable.skills" path="skills"/>
	<acme:form-textarea code="worker.application.form.lable.qualifications" path="qualifications"/>
	

	<jstl:if test="${hasWotela}">
		<acme:form-textarea 
				code="worker.application.form.label.wotelaResponse" 
				path="wotelaResponse"/>
				
		<acme:form-textbox 
				code="worker.application.form.label.ticker" 
				path="ticker"/>
		<jstl:if test="${command == 'create'}">		
			<acme:form-password
					code="worker.application.form.label.password" 
					path="password"/>
      <acme:form-password code="worker.application.label.confirmation" path="confirmation"/>
		</jstl:if>		
	</jstl:if>			
  	
  	<acme:form-submit 
  		test="${command == 'show'}" 
		method="get" 
		code="worker.application.form.button.job" 
		action="/worker/job/show?id=${job.id}"/>
		
	<acme:form-submit 
		test="${command == 'create'}" 
		code="worker.application.form.button.create" 
		action="/worker/application/create"/>
		
  	<acme:form-return code="worker.application.form.button.return"/>
  	
</acme:form>


