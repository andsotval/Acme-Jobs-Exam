<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="employer.Xxxrequest.form.label.text" path="text" placeholder="Text"/>
	<acme:form-textbox code="employer.Xxxrequest.form.label.xxx" path="xxx" placeholder="Text"/>
	
	<acme:form-submit 
		test="${command == 'create'}"
		code="employer.Xxxrequest.form.button.create" 
		action="/employer/xxxrequest/create"/>
		
  	<acme:form-return code="employer.Xxxrequest.form.button.return"/>
</acme:form>
