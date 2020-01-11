<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textarea code="authenticated.wotela.form.label.text" path="text" placeholder="Text"/>
	<acme:form-textbox code="authenticated.wotela.form.label.ticker" path="ticker" placeholder="Ticker"/>
		
  	<acme:form-return code="authenticated.wotela.form.button.return"/>
</acme:form>
