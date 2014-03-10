
<HTML>
<HEAD><%@ include file="header.jsp"%>

<script>
$(document).ready(function(){
    $("#page").validationEngine();
   });
   </script>

<TITLE><fmt:message key="title.createuser" /></TITLE>


	
	<form name="user" method="post" id="page" action="createUserSubmit">
	<br>
	<h1>
	<c:if test="${access eq 'read'}">
	&nbsp;&nbsp;&nbsp;<fmt:message key="label.myprofile"/>
	</c:if>
	<c:if test="${access eq null}">
	
		&nbsp;&nbsp;&nbsp;<fmt:message key="title.createuser" /></c:if>
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
						<input type="text" class="right curved borderL  validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.username" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					<td><fmt:message key="label.message.firstname" /></td>
					<td>
				<spring:bind path="user.firstName">
						<input type="text" class="right curved borderL  validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.firstname" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					<tr>
					<td><fmt:message key="label.message.lastname" /></td><td>
				<spring:bind path="user.lastName">
						<input type="text" class="right curved borderL  validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.lastname" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td><td><fmt:message key="label.message.dob" /></td>
					<td>
				<spring:bind path="user.dob">
						<input type="text" class="right curved borderL inputDate" id="inputDate"  name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.dob" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					<tr>
					<td><fmt:message key="label.message.email" /></td><td>
				<spring:bind path="user.emailId">
						<input type="text" class="right curved borderL validate[email] validate[required] email" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.email" />"
							value="<c:out value="${status.value}"/>" >
					</spring:bind>
					</td>
					<td><fmt:message key="label.message.phone1" /></td><td>
					
				<spring:bind path="user.phoneNo">
						<input type="text" class="right curved borderL validate[phone]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.phone1" />"
							value="<c:out value="${status.value}"/>" >
					</spring:bind>
					</td>
					</tr>
					<tr>
					<td><fmt:message key="label.message.phone2" /></td><td>
				<spring:bind path="user.phoneNo2">
						<input type="text" class="right curved borderL" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.phone2" />"
							value="<c:out value="${status.value}"/>" >
					</spring:bind>
					</td>
				<td><fmt:message key="label.message.password" /></td><td>
				<spring:bind path="user.password">
						<input type="password" class="right curved borderL  validate[required] " name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.password" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					<c:if test="${access ne 'read'}">
	
					<tr>
					<td><fmt:message key="label.message.balance" /></td><td>
				<spring:bind path="user.availableBalance">
						<input type="text" class="right curved borderL  validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.balance" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
				<td><fmt:message key="label.message.agency" /></td><td>
				<spring:bind path="user.agency">
						<input type="text" class="right curved borderL validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.agency" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					</c:if>
						
					<tr>
					<td><fmt:message key="label.message.address" /></td>
					<td colspan="3">
					<spring:bind path="user.address">
						<textarea  class="right curved borderL w100 validate[required]" name="<c:out value="${status.expression}"/>"  ><c:out value="${status.value}"/></textarea>
					</spring:bind>
					
					</td>
					</tr>
					<tr>
					<td><fmt:message key="label.message.city" /></td><td>
				<spring:bind path="user.city">
						<input type="text" class="right curved borderL validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.city" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
				<td><fmt:message key="label.message.state" /></td><td>
				<spring:bind path="user.state">
						<input type="text" class="right curved borderL validate[required]" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.state" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
					</td>
					</tr>
					
					
				</table>
				<spring:bind path="user.prntId">
						<input type="hidden" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.prntid" />"
							value="<c:out value="${sessionScope.user.userId}"/>" class="field">
					</spring:bind>
					<spring:bind path="user.role">
						<input type="hidden" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.role" />"
							value="<c:out value="${status.value}"/>" class="field">
					</spring:bind>
			<spring:bind path="user.prntName">
						<input type="hidden" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.prntName" />"
							value="<c:out value="${sessionScope.user.firstName}"/>" class="field">
					</spring:bind>
			<spring:bind path="user.prntPhoneNo">
						<input type="hidden" name="<c:out value="${status.expression}"/>" placeholder="<fmt:message key="label.message.prntPhoneNo" />"
							value="<c:out value="${sessionScope.user.phoneNo}"/>" class="field">
					</spring:bind>		
			

			
			</fieldset>
		<c:if test="${access ne 'read'}">
		
		<table class="center">
		<tr>
		<td><input type="submit" class="center curved borderL" id="submit"/></td>
		<td>&nbsp;</td>
		<td><input type="reset" class="center curved borderL" id="Reset"/></td>
		</tr>
		</table>
		
		
		
		</c:if>
		
		<div class="w16 right">
				<c:if test="${access eq 'read'}">		<div class="height150 bkgDarker">
		<ul class="hoverList verticalList editText pushDown aLaUne">
               <li><font color="blue"><fmt:message key="label.details"/></font></li>
               <li><fmt:message key="label.availablebal"/>${sessionScope.user.availableBalance}</li>
               <li><fmt:message key="label.usedbalance"/>${sessionScope.user.usedBalance}</li>
               <li><fmt:message key="label.lastlogin"/> ${sessionScope.user.lastLogin}</li>
               <li><fmt:message key="label.registeredon"/>${sessionScope.user.registeredOn}</li>
               
               

               </ul>
               </div>
               </c:if>
						<!-- <div class="pushUp">
							<h3 class="h1">Some block here</h3>
							<div class="clearfix pushDown">
								<div class="clearfix tCenter">
									<div class="left w14 tCenter">
										<a href="http://www.binarymind.org" title="Binarymind.org">
											<img class="w1" src="http://www2.cnrs.fr/sites/communique/image/mona_unvarnish_web_image.jpg" title="La Joconde">
										</a>
									</div>
									</div></div></div> --></div>
		
		
	</form>
<%@ include file="footer.jsp"%>

