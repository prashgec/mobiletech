
<HTML>

<HEAD><%@ include file="header.jsp"%>
<script>
$(document).ready(function(){
    $("#page").validationEngine();
   });
   </script>
<TITLE><fmt:message key="title.createrequest" /></TITLE>


	
	<form name="createrequest" method="post" id="page" action="createRequestSubmit">
	<br>
	<h1>
	<c:if test="${action eq 'create'}">
	&nbsp;&nbsp;&nbsp;<fmt:message key="label.create.request"/>
	</c:if>
	<c:if test="${action eq 'approve'}">
	
		&nbsp;&nbsp;&nbsp;<fmt:message key="label.view.request" /></c:if>
	</h1>
	<hr>
	<font color="red"> <c:if test="${error ne null}"><fmt:message key="error.${error}"/></c:if> </font>
		
		<fieldset id="inputs">
			
			<table class="center">
			<tr><br></tr>
			<tr><br></tr>
				<tr>
					<td><fmt:message key="label.request.type" /></td><td>
				<spring:bind path="tnxrequest.reqType">
						
							
					<select class="right curved borderL w100">
  <option value="1">Balance Request</option>
  <option value="2">Plan Upgrade</option>
  
</select>
					</spring:bind>
					</td>
					<td><fmt:message key="label.request.requestername" /></td>
					<td>
				<spring:bind path="tnxrequest.requesterName">
						<input type="text" readonly="readonly" class="w100 right curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.firstname" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					<tr>
					<td><fmt:message key="label.request.createdate" /></td><td>
				<spring:bind path="tnxrequest.createDate">
						<input type="text" readonly="readonly" class=" w100 right curved borderL validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.request.createdate" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td><td><fmt:message key="label.request.amt" /></td>
					<td>
				<spring:bind path="tnxrequest.amt">
						<input type="text" class="right curved borderL w100 validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.request.amt" />"
							value="<c:out value="${status.value}"/>" class="field"/>
					</spring:bind>
					</td>
					</tr>
					
					<tr>
					<td><fmt:message key="label.request.reqremark" /></td>
					<td colspan="3">
					<spring:bind path="tnxrequest.requesterRemark">
						<textarea  class="right curved borderL w100 validate[required]" name="<c:out value="${status.expression}"/>"></textarea>
					</spring:bind>
					
					</td>
					</tr>
					
						
					
					
				</table>
				<spring:bind path="tnxrequest.requestedTo">
						<input type="hidden" name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					<spring:bind path="tnxrequest.requestedBy">
						<input type="hidden" name="<c:out value="${status.expression}"/>" 
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
			
			

			
			</fieldset>
		
		
		<table class="center">
		<tr>
		<td><input type="submit" class="center curved borderL" id="submit" value="Create"/></td>
		<td>&nbsp;</td>
		<td><input type="reset" class="center curved borderL" id="Reset"/></td>
		</tr>
		</table>
		
		
		
		
		
		
	</form>
<%@ include file="footer.jsp"%>

