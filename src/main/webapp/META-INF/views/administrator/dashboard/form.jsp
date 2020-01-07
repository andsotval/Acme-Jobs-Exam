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

<div>
	<canvas id="canvas"></canvas>
</div>

<script type="text/javascript"> 
	$(document).ready(function(){
		
		var data = {
				labels:[
					<jstl:forEach var="sector" items="${sectorsbyCompany}">
							"<acme:message code="${sector}"/>",
					</jstl:forEach>
					],
				datasets:[{	
						label : "<acme:message code="administrator.dashboard.form.lable.sectorspercompany"/>",
						data:[
							<jstl:forEach var="num" items="${numSectorbyCompany}">
								<acme:message code="${num}"/>,
							</jstl:forEach>
						]		
						}]
			};
		var options = {
				scales:{ 
					yAxes:[{
							ticks:{
									suggestedMin: 0.0,
									suggestedMax: 4.0
							}
					}]
				},
				legend: {display : true}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context,{
			type : "bar",
			data : data,
			options : options
		});
		
	});	
</script>
									
<div>
	<canvas id="canvas2"></canvas>
</div>

<script type="text/javascript"> 
	$(document).ready(function(){
		
		var data = {
				labels:[
					<jstl:forEach var="sectori" items="${sectorsbyInvestor}">
							"<acme:message code="${sectori}"/>",
					</jstl:forEach>
					],
				datasets:[{	
						label : "<acme:message code="administrator.dashboard.form.lable.sectorsperinvestor"/>",
						data:[
							<jstl:forEach var="numi" items="${numSectorbyInvestor}">
								<acme:message code="${numi}"/>,
							</jstl:forEach>
						]		
						}]
			};
		var options = {
				scales:{ 
					yAxes:[{
							ticks:{
									suggestedMin: 0.0,
									suggestedMax: 4.0
							}
					}]
				},
				legend: {display : true}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas2");
		context = canvas.getContext("2d");
		new Chart(context,{
			type : "bar",
			data : data,
			options : options
		});
		
	});	
</script>
<div>
	<canvas id="canvas3"></canvas>
</div>

<script type="text/javascript"> 
	$(document).ready(function(){
		
		var data = {
				labels:[
					"<acme:message code="administrator.dashboard.form.lable.ratiojobsgroupedstatus.published"/>",
					"<acme:message code="administrator.dashboard.form.lable.ratiojobsgroupedstatus.draft"/>"
					],
				datasets:[{	
						label : "<acme:message code="administrator.dashboard.form.lable.ratiojobsgroupedstatus"/>",
						data:[
								<acme:message code="${ratioJobsGroupedStatusPublished}"/>,
								<acme:message code="${ratioJobsGroupedStatusDraft}"/>
						]		
						}]
			};
		var options = {
				scales:{ 
					yAxes:[{
							ticks:{
									suggestedMin: 0.0,
									suggestedMax: 1.0
							}
					}]
				},
				legend: {display : true}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas3");
		context = canvas.getContext("2d");
		new Chart(context,{
			type : "bar",
			data : data,
			options : options
		});
		
	});	
</script>

<div>
	<canvas id="canvas4"></canvas>
</div>

<script type="text/javascript"> 
	$(document).ready(function(){
		
		var data = {
				labels:[
					"<acme:message code="administrator.dashboard.form.lable.ratioapplicationsgroupedstatus.pending"/>",
					"<acme:message code="administrator.dashboard.form.lable.ratioapplicationsgroupedstatus.accepted"/>",
					"<acme:message code="administrator.dashboard.form.lable.ratioapplicationsgroupedstatus.rejected"/>"
					],
				datasets:[{	
						label : "<acme:message code="administrator.dashboard.form.lable.ratioapplicationsgroupedstatus"/>",
						data:[
								<acme:message code="${ratioApplicationsGroupedStatusPending}"/>,
								<acme:message code="${ratioApplicationsGroupedStatusAccepted}"/>,
								<acme:message code="${ratioApplicationsGroupedStatusRejected}"/>
						]		
						}]
			};
		var options = {
				scales:{ 
					yAxes:[{
							ticks:{
									suggestedMin: 0.0,
									suggestedMax: 1.0
							}
					}]
				},
				legend: {display : true}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas4");
		context = canvas.getContext("2d");
		new Chart(context,{
			type : "bar",
			data : data,
			options : options
		});
		
	});	
</script>

<div>
	<canvas id="canvas5"></canvas>
</div>

<script type="text/javascript"> 
	$(document).ready(function(){
		
		var data = {
				labels:[
					<jstl:forEach var="daysApplicationsStatusPendingByDayCanvas" items="${daysApplicationsStatusPendingByDay}">
							"<acme:message code="${daysApplicationsStatusPendingByDayCanvas}"/>",
					</jstl:forEach>
					],
				datasets:[{	
						label : "<acme:message code="administrator.dashboard.form.lable.daysApplicationsStatusPendingByDay"/>",
						data:[
							<jstl:forEach var="numberApplicationsStatusPendingByDayCanvas" items="${numberApplicationsStatusPendingByDay}">
								<acme:message code="${numberApplicationsStatusPendingByDayCanvas}"/>,
							</jstl:forEach>
						]		
						}]
			};
		var options = {
				scales:{ 
					yAxes:[{
							ticks:{
									suggestedMin: 0.0,
									suggestedMax: 10.0,
									stepSize: 2.0
							}
					}]
				},
				legend: {display : true}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas5");
		context = canvas.getContext("2d");
		new Chart(context,{
			type : "line",
			data : data,
			options : options
		});
		
	});	
</script>	
<div>
	<canvas id="canvas6"></canvas>
</div>

<script type="text/javascript"> 
	$(document).ready(function(){
		
		var data = {
				labels:[
					<jstl:forEach var="daysApplicationsStatusAcceptedByDayCanvas" items="${daysApplicationsStatusAcceptedByDay}">
							"<acme:message code="${daysApplicationsStatusAcceptedByDayCanvas}"/>",
					</jstl:forEach>
					],
				datasets:[{	
						label : "<acme:message code="administrator.dashboard.form.lable.daysApplicationsStatusAcceptedByDay"/>",
						data:[
							<jstl:forEach var="numberApplicationsStatusAcceptedByDayCanvas" items="${numberApplicationsStatusAcceptedByDay}">
								<acme:message code="${numberApplicationsStatusAcceptedByDayCanvas}"/>,
							</jstl:forEach>
						]		
						}]
			};
		var options = {
				scales:{ 
					yAxes:[{
							ticks:{
									suggestedMin: 0.0,
									suggestedMax: 10.0,
									stepSize: 2.0
							}
					}]
				},
				legend: {display : true}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas6");
		context = canvas.getContext("2d");
		new Chart(context,{
			type : "line",
			data : data,
			options : options
		});
		
	});	
</script>

<div>
	<canvas id="canvas7"></canvas>
</div>

<script type="text/javascript"> 
	$(document).ready(function(){
		
		var data = {
				labels:[
					<jstl:forEach var="daysApplicationsStatusRejectedByDayCanvas" items="${daysApplicationsStatusRejectedByDay}">
							"<acme:message code="${daysApplicationsStatusRejectedByDayCanvas}"/>",
					</jstl:forEach>
					],
				datasets:[{	
						label : "<acme:message code="administrator.dashboard.form.lable.daysApplicationsStatusRejectedByDay"/>",
						data:[
							<jstl:forEach var="numberApplicationsStatusRejectedByDayCanvas" items="${numberApplicationsStatusRejectedByDay}">
								<acme:message code="${numberApplicationsStatusRejectedByDayCanvas}"/>,
							</jstl:forEach>
						]		
						}]
			};
		var options = {
				scales:{ 
					yAxes:[{
							ticks:{
									suggestedMin: 0.0,
									suggestedMax: 10.0,
									stepSize: 2.0
							}
					}]
				},
				legend: {display : true}
		};
		
		var canvas, context;
		
		canvas = document.getElementById("canvas7");
		context = canvas.getContext("2d");
		new Chart(context,{
			type : "line",
			data : data,
			options : options
		});
		
	});	
</script>							
							
<acme:form readonly="true">
	<acme:form-textbox code="administrator.dashboard.form.lable.countAnnouncement" path="countAnnouncement" />
	<acme:form-textbox code="administrator.dashboard.form.lable.countCompanyRecord" path="countCompanyRecords" />
	<acme:form-textbox code="administrator.dashboard.form.lable.countInvestorRecord" path="countInvestorRecords" />
	<acme:form-textbox code="administrator.dashboard.form.lable.minActiveRequest" path="minActiveRequest" />
	<acme:form-textbox code="administrator.dashboard.form.lable.maxActiveRequest" path="maxActiveRequest" />
	<acme:form-textbox code="administrator.dashboard.form.lable.avgActiveRequest" path="avgActiveRequest" />
	<acme:form-textbox code="administrator.dashboard.form.lable.stDerivationActiveRequest" path="stDerivationActiveRequest" />
	<acme:form-textbox code="administrator.dashboard.form.lable.minRangeMinActiveOffer" path="minRangeMinActiveOffer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.maxRangeMinActiveOffer" path="maxRangeMinActiveOffer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.avgRangeMinActiveOffer" path="avgRangeMinActiveOffer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.stDerivationRangeMinActiveOffer" path="stDerivationRangeMinActiveOffer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.minRangeMaxActiveOffer" path="minRangeMaxActiveOffer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.maxRangeMaxActiveOffer" path="maxRangeMaxActiveOffer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.avgRangeMaxActiveOffer" path="avgRangeMaxActiveOffer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.stDerivationRangeMaxActiveOffer" path="stDerivationRangeMaxActiveOffer" />
	
	<acme:form-textbox code="administrator.dashboard.form.lable.avgJobPerEmployer" path="avgJobPerEmployer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.avgApplicationPerEmployer" path="avgApplicationPerEmployer" />
	<acme:form-textbox code="administrator.dashboard.form.lable.avgApplicationPerWorker" path="avgApplicationPerWorker" />
	
	<!-- //TODO: Cambiar -->
	<acme:form-textbox code="administrator.dashboard.form.lable.ratioJobWithXxxrequest" path="ratioJobWithXxxrequest" />
	<acme:form-textbox code="administrator.dashboard.form.lable.ratioXxxWithXxx" path="ratioXxxWithXxx" />
	<acme:form-textbox code="administrator.dashboard.form.lable.ratioAplicationsWithxxx" path="ratioAplicationsWithxxx" />
	
	<acme:form-return code="administrator.dashboard.form.button.return" />
</acme:form>
