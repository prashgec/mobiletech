
<%@ include file="header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		
<link href="<c:url value="/resources/css/colorbox.css" />" rel="stylesheet"  type="text/css" >
<script src="<c:url value="/resources/js/jquery.colorbox.js"/>"></script>

 <script>
			$(document).ready(function(){
				//Examples of how to assign the Colorbox event to elements
			
				$(".iframe").colorbox({iframe:true, width:"80%", height:"80%"});
				

				
			});
			
			function deleteChild()
			{
				alert('this functionality is not available now');
			}
</script>
<style>
	body{font:12px/1.2 Verdana, sans-serif; padding:0 0px;}
			a:link, a:visited{text-decoration:none;  border-bottom:0px ;}
			h2{font-size:13px; margin:15px 0 0 0;}
		</style>


<c:if test="${menu eq 'viewtransaction' }">
<c:choose>
<c:when test="${not empty tnxList}">
<br>
<h1>&nbsp;&nbsp;&nbsp;<fmt:message key="label.view.tnx" /></h1>
<hr>

<link href="<c:url value="/resources/css/table.css" />" rel="stylesheet"  type="text/css" >
<div class="center">
<table cellspacing='0'  >
<thead>

 <tr>
 <th><fmt:message key="label.recharge.type" /></th>
        <th><fmt:message key="label.tnx.tnxid" /></th>
        <th><fmt:message key="label.tnx.jolotnxid" /></th>
        <th><fmt:message key="label.message.userid" /></th>
        <th><fmt:message key="label.tnx.date" /></th>
        <th><fmt:message key="label.recharge.mobno" /></th>
        <th><fmt:message key="label.tnx.amount" /></th>
        <th><fmt:message key="label.recharge.chargedamt" /></th>
        <th><fmt:message key="label.recharge.remainingamt" /></th>
        
        <th><fmt:message key="label.tnx.status" /></th>
        
   </tr> 
   </thead>
   <tbody>
   <c:set var="index" value="a"></c:set>
     <c:forEach var="ob" varStatus="status" items="${tnxList}">
     
    <tr <c:if test="${index eq 'a' }">class="even"</c:if>>
    <td><fmt:message key="tnxtype.${ob.tnxType}"/></td>
        <td><c:out value="${ob.tnxId}"/></td>
        <td><c:out value="${ob.joloTnxId}"/></td>
        <td><c:out value="${ob.userId}"/></td>
        <td><fmt:formatDate pattern="dd/MM/yyyy 'at' hh:mm a" 
            value="${ob.tnxDate}" /></td>
        <td><c:out value="${ob.mobNo}"/></td>
        <td><c:out value="${ob.tnxAmount}"/></td>
        <td><c:out value="${ob.chargedAmount}"/></td>
        <td><c:out value="${ob.remainingAmount}"/></td>
        
        <td><c:if test="${ob.tnxRemark eq 'FAILED' }"> <font color="red"></c:if> <c:out value="${ob.tnxRemark}"/></font></td>
        
   </tr> 
    <c:choose>
    <c:when test="${index eq 'a' }">
    <c:set var="index" value="b"/></c:when>
    <c:otherwise>
    <c:set var="index" value="a"/></c:otherwise>
    </c:choose>
   
     
             </c:forEach>
             </tbody>
            
             </table>
              </div>
            </c:when>
             <c:otherwise>
            
       <h1>No Transaction</h1>
    </c:otherwise>
    </c:choose>
   </c:if> 
   
     
  
   
  <%@ include file="footer.jsp"%>          
        


  
