<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />

    <title>Authors</title>
</head>
<body>

<h1>Authors List</h1>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach var="a" items="${authors}">
        <tr>
            <td>${a.id}</td>
            <td>${a.name}</td>
            <td>
                <a href="${pageContext.request.contextPath}/authors/edit/${a.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>


</table>

</body>
</html>
