
<HTML>
<HEAD><%@ include file="header.jsp"%>

<TITLE><fmt:message key="title.recharge" /></TITLE>

 <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet"  type="text/css" >
	
	<form name="recharge" method="post" id="page" action="rechargeSubmit">
	<br>
	<h1>
	
	&nbsp;&nbsp;&nbsp;<fmt:message key="label.view.receipt"/>
	
	
		
	</h1>
	<hr>
	<font color="red"> <c:if test="${error ne null}"><fmt:message key="error.${error}"/></c:if> </font>
	
		<fieldset id="inputs">
			
			<table class="center w23">
			<th > <img alt="Success" width="32" height="32" src="<c:url value='/resources/images/success.png'/>"> &nbsp;&nbsp; <font color="green"> <c:out value="${message}"></c:out></font>	</th>
				<tr>
				<td><fmt:message key="label.recharge.datetime"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy 'at' hh:mm a" 
            value="${tnxrecharge.tnxDate}" /></td>
				</tr>
				<tr>
				<td><fmt:message key="label.recharge.type"/></td>
				<td><fmt:message key="tnxtype.${tnxrecharge.tnxType}"/></td>
				</tr>
				<tr>
				<td><fmt:message key="label.tnx.tnxid"/></td>
				<td><c:out value="${tnxrecharge.tnxId}"/></td>
				</tr>
				<tr>
				<td><fmt:message key="label.tnx.jolotnxid"/></td>
				<td><c:out value="${tnxrecharge.joloTnxId}"/></td>
				</tr>
				<tr>	
				<td><fmt:message key="label.recharge.operator"/></td>
				<td><c:out value="${tnxrecharge.operator}"/></td>
				</tr>
				<tr>
				<td><fmt:message key="label.recharge.mobno"/></td>
				<td><c:out value="${tnxrecharge.mobNo}"/></td>
				</tr>
				<tr>
				<td><fmt:message key="label.recharge.remark"/></td>
				<td><c:out value="${tnxrecharge.tnxRemark}"/></td>
				</tr>
				<tr>
				<td><fmt:message key="label.recharge.amount"/></td>
				<td><c:out value="${tnxrecharge.tnxAmount}"/></td>
				</tr>
				<tr>
				<td><fmt:message key="label.recharge.chargedamt"/></td>
				<td><c:out value="${tnxrecharge.chargedAmount}"/></td>
				</tr>
				<tr>
				<td><fmt:message key="label.recharge.remainingamt"/></td>
				<td><c:out value="${tnxrecharge.remainingAmount}"/></td>	
					</tr>
						
					
					
				</table>
				
			
			

			
			</fieldset>
		
		
		
		
		
		
		
	</form>
<%@ include file="footer.jsp"%>

