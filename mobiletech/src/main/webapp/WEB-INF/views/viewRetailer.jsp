
<%@ include file="header.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
		
<link href="<c:url value="/resources/css/colorbox.css" />" rel="stylesheet"  type="text/css" >
<script src="<c:url value="/resources/js/jquery.colorbox.js"/>"></script>
<link href="<c:url value="/resources/css/table.css" />" rel="stylesheet"  type="text/css" >
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


<c:if test="${menu ne 'viewrequest' and menu ne 'notification' }">
<c:choose>
<c:when test="${not empty userlst}">
<br>
<h1>&nbsp;&nbsp;&nbsp;<fmt:message key="label.users.list" /></h1>
<hr>

<div class="center">
<table cellspacing='0'  >
<thead>

 <tr>
        <th><fmt:message key="label.message.userid" /></th>
        <th><fmt:message key="label.message.firstname" /></th>
        <th><fmt:message key="label.message.email" /></th>
        <th><fmt:message key="label.message.dob" /></th>
        <th><fmt:message key="label.message.username" /></th>
        <th><fmt:message key="label.message.prntid" /></th>
        <th><fmt:message key="label.message.prntName" /></th>
        <th><fmt:message key="label.message.action" /></th>
   </tr> 
   </thead>
   <tbody>
   <c:set var="index" value="a"></c:set>
     <c:forEach var="ob" varStatus="status" items="${userlst}">
     
    <tr <c:if test="${index eq 'a' }">class="even"</c:if>>
        <td><c:out value="${ob.userId}"/></td>
        <td><c:out value="${ob.firstName}"/></td>
        <td><c:out value="${ob.emailId}"/></td>
        <td><c:out value="${ob.dob}"/></td>
        <td><c:out value="${ob.userName}"/></td>
        <td><c:out value="${ob.prntId}"/></td>
        <td><c:out value="${ob.prntName}"/></td>
        <td><a class='iframe' href="editUserLoad?userid=${ob.userId}"><img alt="Edit" src="<c:url value='/resources/images/edit.png'/>"></a> &nbsp;&nbsp;&nbsp;
        <a  href="deleteChild();" ></a><img alt="Detele" src="<c:url value='/resources/images/delete.gif'/>"></a>
        </td>
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
            
       <h1>No Childs Yet :(</h1>
    </c:otherwise>
    </c:choose>
   </c:if> 
   
   <c:if test="${menu eq 'viewrequest' or menu eq 'notification'}">
   
   <c:choose>
<c:when test="${not empty notflst}">
<br>
<h1>&nbsp;&nbsp;&nbsp;<fmt:message key="label.request.list" /></h1>
<hr>

<div class="center">
<table cellspacing='0'  >
<thead>

 <tr>
        <th><fmt:message key="label.request.reqid" /></th>
        <th><fmt:message key="label.request.type" /></th>
        <th><fmt:message key="label.request.requestername" /></th>
        
        <th><fmt:message key="label.request.reqremark" /></th>
        <th><fmt:message key="label.request.aprremark" /></th>
        <th><fmt:message key="label.message.action" /></th>
        
   </tr> 
   </thead>
   <tbody>
   <c:set var="index" value="a"></c:set>
     <c:forEach var="ob" varStatus="status" items="${notflst}">
     
    <tr <c:if test="${index eq 'a' }">class="even"</c:if>>
        <td><c:out value="${ob.reqId}"/></td>
        <td><c:out value="${ob.reqType}"/></td>
        <td><c:out value="${ob.requesterName}"/></td>
        
        <td><c:out value="${ob.requesterRemark}"/></td>
        <td><c:out value="${ob.approverRemark}"/></td>
        <td><a class='iframe' href="approveRequestLoad?reqid=${ob.reqId}&reqtype=${ob.reqType}&username=${ob.requesterName}"><img alt="Edit" src="<c:url value='/resources/images/edit.png'/>"></a> &nbsp;&nbsp;&nbsp;
        
        </td>
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
            
       <h1><fmt:message key="label.request.empty"/></h1>
    </c:otherwise>
    </c:choose>
   
   </c:if>        
   
  
   
  <%@ include file="footer.jsp"%>          
        


  
