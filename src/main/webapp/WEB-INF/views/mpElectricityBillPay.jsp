
<HTML>
<HEAD><%@ include file="header.jsp"%>

<script type="text/javascript">
 $(document).ready(function(){
	 $("#page").validationEngine();
	 loadOperator();
	
 }); 

function loadOperator()
    {
	
    
	var option=document.getElementById("rechargeType")[document.getElementById("rechargeType").selectedIndex].value;
	 $("#operator > option").remove();
	var list;
	
		
			
				
					if (option=='5')
						list=${list5};	
				//	alert(JSON.stringify(list));
					//var list1=$.toJSON(list);
					for (var i=0;i<list.length;i++) {
					    $("#operator").append('<option commission="'+list[i].commission+'" value="'+list[i].dataCode+'">'+list[i].dataValue+'</option>');
		
	}}
</script>
<TITLE><fmt:message key="title.mpElectricityBillPay" /></TITLE>


	
	<form name="recharge" method="post" id="page" action="mpElectricityBillPaySubmit">
	<br>
	<h1>
	
	&nbsp;&nbsp;&nbsp;<fmt:message key="label.view.mpElectricityBillPay"/>
	
	
		
	</h1>
	<hr>
	<font color="red"> <c:if test="${error ne null}"><fmt:message key="error.${error}"/></c:if> </font>
	<font color="green"> <c:out value="${message}"></c:out></font>	
		<fieldset id="inputs">
			
			<table class="center">
			<tr><br></tr>
			<tr><br></tr>
				<tr>
					<td><fmt:message key="label.electricityBillPay.state" /></td><td>
				<%-- <spring:bind path="tnxrecharge.tnxType">
						
							
					<select class="right curved borderL w100">
  <option value="1">Prepaid Recharge</option>
  <option value="2">Postpaid Bill</option>
  <option value="3">DTH Recharge</option>
  <option value="4">Data Card</option>
  
</select>
					</spring:bind> --%>
					
					<form:select id="rechargeType" path="tnxrecharge.tnxType" class="right curved borderL w100" onchange="loadOperator();">

<form:option label="Select" value="" />

<form:options items="${option}"  />

</form:select>
					
					
					</td>
					
					</tr>
					<tr>
					<td><fmt:message key="label.recharge.operator" /></td>
					<td>
			<spring:bind path="tnxrecharge.operator">
					<select id="operator" name="<c:out value="${status.expression}"/>" class="right curved borderL w100">
					<OPTION VALUE="" <c:if test="${status.value eq null}">selected</c:if>><fmt:message key="label.common.select" /></OPTION>
						<%-- <OPTION VALUE="" <c:if test="${status.value eq null}">selected</c:if>><fmt:message key="label.common.select" /></OPTION>
						<c:forEach items="${list1}" var="list1">
							<option
								value="<c:out value='${list1.dataCode}'/>"
								<c:if test="${status.value eq list1.dataCode}"> selected </c:if>>
							<c:out value="${list1.dataValue}" /></option>
						</c:forEach> --%>
					</select>
				</spring:bind>
					
					</td>
					</tr>
					
					<tr>
					<td><fmt:message key="label.mpElectricityBillPay.serviceNo" /></td>
					<td>
				<spring:bind path="tnxrecharge.mobNo">
						<input type="text"  class="right curved borderL w100 validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.mpElectricityBillPay.serviceNo" />"
							value="<c:out value="${status.value}"/>" class="field"/>
					</spring:bind>
					</td>
					</tr>
					
					
					<tr>
					<td><fmt:message key="label.recharge.amount" /></td>
					<td>
				<spring:bind path="tnxrecharge.tnxAmount">
						<input type="text" class="right curved borderL w100 validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.recharge.amount" />"
							value="<c:out value="${status.value}"/>" class="field"/>
					</spring:bind>
					</td>
					</tr>
					
					<tr>
					<td><fmt:message key="label.mpElectricityBillPay.cycle" /></td>
					<td>
				<spring:bind path="tnxrecharge.cycle">
						<input type="text"  class="right curved borderL w100 validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.mpElectricityBillPay.ivrs" />"
							value="<c:out value="${status.value}"/>" class="field"/>
					</spring:bind>
					</td>
					</tr>
					<tr>
					<td><fmt:message key="label.mpElectricityBillPay.dueDate" /></td>
					<td>
				<spring:bind path="tnxrecharge.dueDate">
						<input type="text"  class="right curved borderL w100 validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.mpElectricityBillPay.dueDate" />"
							value="<c:out value="${status.value}"/>" class="field"/>
					</spring:bind>
					</td>
					</tr>
						
					
					
				</table>
				
			
			

			
			</fieldset>
		
		<c:if test="${access ne 'disable'}">
		<table class="center">
		<tr>
		<td><input type="submit" class="center curved borderL" id="submit" value="Submit" /></td>
		<td>&nbsp;</td>
		<td><input type="reset" class="center curved borderL" id="Reset"/></td>
		</tr>
		</table>
		</c:if>
		
		
		
		
		
	</form>
<%@ include file="footer.jsp"%>

