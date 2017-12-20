<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Ads Listing" />
    </jsp:include>
</head>
<body>
    <%@ include file="../partials/navbar.jsp"%>
    <c:forEach var="ad" items="${adList}">
        <h3>${ad.title}</h3>
        <h5>ID#${ad.id}</h5>
        <h5>User ID#${ad.userId}</h5>
        <p>Description: ${ad.description}</p>
        <hr>
    </c:forEach>
</body>
</html>
