<%@ include file="include.jsp" %>
<c:if test="${sessionScope.user.role eq null}">
<jsp:forward page="/index.jsp" />
</c:if>

