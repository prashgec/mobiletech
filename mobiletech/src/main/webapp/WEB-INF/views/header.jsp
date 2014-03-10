<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="include.jsp"%>
<html>
<head>
<title>:: MobileTech ::</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="X-UA-Compatible" content="chrome=1" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<link rel="stylesheet" href="<c:url value="/resources/css/validationEngine.jquery.css"/>" type="text/css"/>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.2.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.validationEngine-en.js"/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value="/resources/js/jquery.validationEngine.js"/>" type="text/javascript" charset="utf-8"></script>

<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css"/>
	
	<link rel="stylesheet" href="<c:url value="/resources/css/datepicker.css" />" type="text/css" />
    
    
	<%-- <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script> --%>
	<script type="text/javascript" src="<c:url value="/resources/js/datepicker.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/eye.js"/>"></script>
    
    <script type="text/javascript" src="<c:url value="/resources/js/layout.js?ver=1.0.2"/>"></script>
    <!--[if IE]>
<link href="<c:url value="/resources/css/ie.css"/>" rel="stylesheet" type="text/css" media="screen" />
<![endif]-->
	<!--[if IE 6]>
<link href="<c:url value="/resources/css/ie6.css"/>" rel="stylesheet" type="text/css" media="screen" />
<![endif]-->

<script>
$(document).ready(function(){
    $("#login").validationEngine();
   });
   </script>


	
</head>
<body>
	<div id="header" class="bkgDark whiteLink">
		<div class="bkgLighter tCenter">
			<div
				class="center siteWidth tLeft clearfix pushUp pushDown whiteLink">
				<div class="h1 left w35 tWhite">
					<a href="/mobiletech">MobileTech</a>

				</div>
				<font color="red"> <c:if test="${error ne null and error eq '001'}">
						<fmt:message key="error.${error}" />
					</c:if>
				</font>
				<c:choose>
					<c:when test="${sessionScope.user.firstName eq null}">
						<form id="login" method="post" action="loginSubmit" name="search"
							class="w25 right">
							<input type="submit" class="darkButton right   button height30"
								value="Login" width="20px" height="5px"> <spring:bind
									path="loginForm.password">
									<input type="password" placeholder="Password" tabindex="2"
										name="<c:out value="${status.expression}"/>"
										value="<c:out value="${status.value}"/>"
										placeholder="<fmt:message key="home.password"/>" size="20"
										maxlength="20" class="validate[required] right curved borderL w25 height20 " />
								</spring:bind> <spring:bind path="loginForm.userName">
									<input type="text" placeholder="Username" autofocus=""
										tabindex="1" name="<c:out value="${status.expression}"/>"
										value="<c:out value="${status.value}"/>"
										placeholder="<fmt:message key="home.username"/>" size="20"
										maxlength="20" class="right curved borderL w25 height20 validate[required]" />
								</spring:bind>
						</form>
					</c:when>
					<c:otherwise>
						<div class=" tCenter whiteLink right clearfix">
							<strong>Welcome ${sessionScope.user.firstName} &nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="logout"><fmt:message key="label.logout" /></a></strong><br />
							<strong>Parent </strong> &nbsp;<strong> ${sessionScope.user.prntName}  (${sessionScope.user.prntPhoneNo})&nbsp;&nbsp; </strong><br />
							<strong>Balance </strong> &nbsp;<strong> ${sessionScope.user.availableBalance}&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; </strong>
							
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<!-- bloody menu section starts from here  -->
		<div class="bkgMedium tCenter">
			<div class="center tLeft siteWidth clearfix whiteLink">
				<ul id="mainMenu" class="height30 horizontalList menu  ">
					<c:if test="${sessionScope.user.role ne null}">
						<li
							<c:if test="${menu eq 'profile' }"> class="selected bkgWhite"</c:if>>
							<a href="viewProfile?userid=${sessionScope.user.userId}"><fmt:message
									key="label.myprofile" /></a>
						</li>
						<c:if test="${sessionScope.user.role ne 2}">
							<li
								<c:if test="${menu eq 'create' }"> class="selected bkgWhite"</c:if>>
								<a
								href="createUserLoad?role=${sessionScope.user.role+1}&prntid=${sessionScope.user.role}">
									<c:if test="${sessionScope.user.role eq 0}">
										<fmt:message key="label.create.distributor" />
									</c:if> <c:if test="${sessionScope.user.role eq 1}">
										<fmt:message key="label.create.retailer" />
									</c:if>
							</a>
							</li>

							<li
								<c:if test="${menu eq 'viewchild' }"> class="selected bkgWhite"</c:if>>
								<a href="viewChild?userid=${sessionScope.user.userId}"> <c:if
										test="${sessionScope.user.role eq 0}">
										<fmt:message key="label.view.distributor" />
										
									</c:if> <c:if test="${sessionScope.user.role eq 1}">
										<fmt:message key="label.view.retailer" />
									</c:if>
							</a>
							</li>
                            <li
								<c:if test="${menu eq 'viewRetailer' }"> class="selected bkgWhite"</c:if>>
								<a href="viewRetailer?userid=${sessionScope.user.userId}"> <c:if
										test="${sessionScope.user.role eq 0}">
										
										<fmt:message key="label.view.retailer" />
									</c:if> 
							</a>
							</li>
							<li
								<c:if test="${menu eq 'notification' }"> class="selected bkgWhite"</c:if>>
								<a href="viewNotification?userid=${sessionScope.user.userId}">
									<fmt:message key="label.mynotification" />
									 <c:if test="${sessionScope.notification gt 0}">
										
									</c:if> 

							</a>
							</li>
							<%-- <li><div id="noti_Container">
										<div class="noti_bubble">
										<c:out
													value="${sessionScope.notification}" />
													</div></div></li> --%>

						</c:if>
						<c:if test="${sessionScope.user.role ne 0}">

							<li
								<c:if test="${menu eq 'createrequest' }"> class="selected bkgWhite"</c:if>>
								<a href="createRequestLoad"> <fmt:message
										key="label.create.request" />

							</a>
							</li>

							<li
								<c:if test="${menu eq 'viewrequest' }"> class="selected bkgWhite"</c:if>>
								<a href="viewRequestLoad?userid=${sessionScope.user.userId}">
									<fmt:message key="label.view.request" />

							</a>
							</li>
							<c:if test="${sessionScope.user.role eq 2}">
							<li
								<c:if test="${menu eq 'recharge' }"> class="selected bkgWhite"</c:if>>
								<a href="rechargeLoad?userid=${sessionScope.user.userId}">
									<fmt:message key="label.view.recharge" />

							</a> 
							</li>
							<li
								<c:if test="${menu eq 'mpElectricityBillPay' }"> class="selected bkgWhite"</c:if>>
								<a href="mpElectricityBillPayLoad?userid=${sessionScope.user.userId}">
									<fmt:message key="label.view.mpElectricityBillPay" />

							</a>
							</li>
							<li
								<c:if test="${menu eq 'landLineBillPay' }"> class="selected bkgWhite"</c:if>>
								<a href="landLineBillPayLoad?userid=${sessionScope.user.userId}">
									<fmt:message key="label.view.landLineBillPay" />

							</a>
							</li>
							
							</c:if>
							

						</c:if>
						<li
								<c:if test="${menu eq 'viewtransaction' }"> class="selected bkgWhite"</c:if>>
								<a href="viewTnxLoad?userid=${sessionScope.user.userId}">
									<fmt:message key="label.view.tnx" />

							</a>
							</li>
							
							<li
								<c:if test="${menu eq 'commission' }"> class="selected bkgWhite"</c:if>>
								<a href="viewCommission">
									<fmt:message key="label.view.commission" />

							</a>
							</li>
					</c:if>
					<c:if test="${sessionScope.user.role eq null}">
                   <li > <a href="/" ><fmt:message key="label.home"/></a></li>
                <li > <a href="commonRequestLoad?info=services" ><fmt:message key="label.services"/></a></li>
                <li > <a href="commonRequestLoad?info=enquiry" ><fmt:message key="label.enquiry"/></a></li>
                <li > <a href="commonRequestLoad?info=contact" ><fmt:message key="label.contact"/></a></li>
                </c:if>

				</ul>
			</div>
		</div>
		<!-- bloody menu section Ends here  -->

	</div>


	<div id="content"
		class="center siteWidth clearfix relative tLeft bkgWhite ">
		<div class="center ">