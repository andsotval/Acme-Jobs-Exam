<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textarea code="employer.wotela.form.label.text" path="text" placeholder="Text"/>
	<acme:form-textbox code="employer.wotela.form.label.ticker" path="ticker" placeholder="Ticker"/>
		
	<jstl:if test="${command == 'create'}">
		<acme:form-checkbox code="employer.wotela.form.label.confirm" path="confirm"/>
	</jstl:if>
	
	<acme:form-hidden path="job.id"/>

	<acme:form-submit 
		test="${command == 'create'}"
		code="employer.wotela.form.button.create" 
		action="/employer/wotela/create"/>
		
  	<acme:form-return code="employer.wotela.form.button.return"/>
</acme:form>
