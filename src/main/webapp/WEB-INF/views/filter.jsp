<HTML>

<HEAD><%@ include file="header.jsp"%>
<script>
$(document).ready(function(){
    $("#page").validationEngine();
    
   });
   
   
   </script>
   <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet"  type="text/css" >
<TITLE><fmt:message key="title.createrequest" /></TITLE>


	
	<form name="filterTransaction" method="post" id="page" action="filterTransaction">
	<br>
	<h1>
	
		&nbsp;&nbsp;&nbsp;<fmt:message key="label.filter.transaction" />
	</h1>
	<hr>
	<font color="red"> <c:if test="${error ne null}"><fmt:message key="error.${error}"/></c:if> </font>
		
		<div class="center">

<input type="text" name="fromDate" id="inputDate" readonly="readonly" class=" curved borderL inputDate">
<input type="text" name="toDate" id="inputDate1" readonly="readonly" class=" curved borderL inputDate1"> 
<input type="submit" class=" curved borderL "/>

</div>
		</form>
		<%=request.getAttribute("txns") %>
		
		
		<%@ include file="footer.jsp"%>