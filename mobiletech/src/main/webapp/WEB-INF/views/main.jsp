<%@ include file="include.jsp" %>

	
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.user.role eq null}">
<jsp:forward page="/home.htm" />
</c:if>
<form name="userForm" method="post" id="page">
<H1><fmt:message key="welcome.message.home"/>  ${login.userName}</H1>

<fieldset id="actions">
		<a href="recharge.htm">Recharge</a>
		<a href="payBill.htm">Pay Bills</a>
		</fieldset>
		
		
</form>

</body>
</html>
