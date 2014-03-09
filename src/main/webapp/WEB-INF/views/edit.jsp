<%@ include file="include.jsp"%>
<link href="<c:url value="/resources/css/default.css" />"
	rel="stylesheet" type="text/css">
	<c:if test="${approved ne 'approved' }">

<form name="user" method="post" id="page" <c:if test="${menu ne 'viewrequest'}"> action="editUserSubmit" </c:if> <c:if test="${menu eq 'viewrequest'}"> action="approveRequestsubmit" </c:if>  >
	<br>
	<h1>
	
	
		&nbsp;&nbsp;&nbsp;<fmt:message key="title.edituser" />
	</h1>
	<hr>
	<font color="red"> <c:if test="${error ne null}"><fmt:message key="error.${error}"/></c:if> </font>
	<font color="green"><c:out value="${message}"/></font>
		
		<fieldset id="inputs">
			
			<table class="center">
			<tr><br></tr>
			<tr><br></tr>
				<tr>
					<td><fmt:message key="label.message.username" /></td><td>
				<spring:bind path="user.userName">
						<input type="text" readonly="readonly" class="right curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.username" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					<td><fmt:message key="label.message.firstname" /></td>
					<td>
				<spring:bind path="user.firstName">
						<input type="text" readonly="readonly" class="right curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.firstname" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					<tr>
					<td><fmt:message key="label.message.lastname" /></td><td>
				<spring:bind path="user.lastName">
						<input type="text" readonly="readonly" class="right curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.lastname" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td><td><fmt:message key="label.message.dob" /></td>
					<td>
				<spring:bind path="user.dob">
						<input type="text" class="right curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.dob" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					<tr>
					<td><fmt:message key="label.message.email" /></td><td>
				<spring:bind path="user.emailId">
						<input type="text" class="right curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.email" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					<td><fmt:message key="label.message.phone1" /></td><td>
					
				<spring:bind path="user.phoneNo1">
						<input type="text" class="right curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.phone1" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					<tr>
					<td><fmt:message key="label.message.phone2" /></td><td>
				<spring:bind path="user.phoneNo2">
						<input type="text" class="right curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.phone2" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
				<td><fmt:message key="label.message.password" /></td><td>
				<spring:bind path="user.password">
						<input type="password" class="right curved borderL" readonly="readonly" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.password" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					
	
					<tr>
					<td><fmt:message key="label.message.balance" /></td><td>
				<spring:bind path="user.availableBalance">
						<input type="text" class="right curved borderL" readonly="readonly" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.balance" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
				<td><fmt:message key="label.recharge" /></td><td>
				<spring:bind path="txn.amt">
						<input type="text" class="left curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.recharge.amount" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					
						<tr>
					<td><fmt:message key="label.message.city" /></td><td>
				<spring:bind path="user.city">
						<input type="text" class="right curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.city" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
				<td><fmt:message key="label.message.state" /></td><td>
				<spring:bind path="user.state">
						<input type="text" class="right curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.state" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					
					
					
				</table>
				<spring:bind path="user.prntId">
						<input type="hidden" name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					<spring:bind path="user.usedBalance">
						<input type="hidden" name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					<spring:bind path="user.loginStatus">
						<input type="hidden" name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					<spring:bind path="user.registeredOn">
						<input type="hidden" name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					<spring:bind path="user.lastLogin">
						<input type="hidden" name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					
					
					<spring:bind path="user.userId">
						<input type="hidden" name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					<spring:bind path="user.role">
						<input type="hidden" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.role" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
			
			

			
			</fieldset>
		
		
		<table class="center">
		<tr>
		<td><input type="submit" class="center curved borderL" id="submit"/></td>
		<td>&nbsp;</td>
		<td><input type="reset" class="center curved borderL" id="Reset"/></td>
		</tr>
		</table>
		
		
		
		
		
		
		
		
	</form>
	
	</c:if>
	<c:if test="${approved eq 'approved' }">
	<br>
	<h1>
	
	
		&nbsp;&nbsp;&nbsp;<fmt:message key="title.approved" />
	</h1>
	</c:if>