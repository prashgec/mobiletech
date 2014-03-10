
<HTML>

<HEAD><%@ include file="header.jsp"%>
<link href="<c:url value="/resources/css/table.css" />" rel="stylesheet"  type="text/css" >
<style>
	body{font:12px/1.2 Verdana, sans-serif; padding:0 0px;}
			a:link, a:visited{text-decoration:none;  border-bottom:0px ;}
			h2{font-size:13px; margin:15px 0 0 0;}
		</style>
<script>
$(document).ready(function(){
    $("#page").validationEngine();
   });
   </script>
<TITLE><fmt:message key="title.createrequest" /></TITLE>


	
	
	<form:form name="commission" method="post" id="page" action="saveCommission" modelAttribute="commission">
	<br>
	<h1>
	
		&nbsp;&nbsp;&nbsp;<fmt:message key="label.view.commission" />
	</h1>
	<hr>
	<font color="red"> <c:if test="${error ne null}"><fmt:message key="error.${error}"/></c:if> </font>
	<font color="green"><c:out value="${message}"/></font>
	
		
		<table class="center"  cellspacing='0' >
    <tr>
        <th>#</th>
        <th><fmt:message key="label.view.operatorname"/></th>
        <th><fmt:message key="label.view.operatorcode"/></th>
        <th><fmt:message key="label.view.commission"/></th>
       
    </tr>
    <c:forEach items="${commission.list}" var="commission1" varStatus="status">
        <tr>
            <td align="center">${status.count}</td>
            <td><form:input type ="hidden"  name="commission[${status.index}].dataValue" value="${commission1.dataValue}" path="list[${status.index}].dataValue"/><c:out value="${commission1.dataValue}"></c:out>
            <form:input type ="hidden"   name="commission[${status.index}].dataId" value="${commission1.dataId}" path="list[${status.index}].dataId"/>
            </td>
            <td><form:input type ="hidden"  name="commission[${status.index}].dataCode" value="${commission1.dataCode}" path="list[${status.index}].dataCode"/><c:out value="${commission1.dataCode}"></c:out></td>
            <td>
             <c:if test="${sessionScope.user.role ne 0}">  
           <c:out value="${commission1.commission}"/>
            </c:if>
            
             <c:if test="${sessionScope.user.role eq 0}">  
            <form:input  name="commission[${status.index}].commision"  class=" w100 right curved borderL" value="${commission1.commission}" path="list[${status.index}].commission"/>
            </c:if>
            
            </td>
           
        </tr>
    </c:forEach>
		
		</table>
		
		
		<c:if test="${sessionScope.user.role eq 0}">  
		
		<br>
		<input type="submit" class="center curved borderL" id="submit" value="Save"/> 
		
		
		
		
		</c:if>
		
		
		
		
	</form:form>
	
	</div>
<%@ include file="footer.jsp"%>

