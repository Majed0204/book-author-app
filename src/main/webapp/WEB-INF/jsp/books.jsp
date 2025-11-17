<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />

    <title>Books</title>
</head>
<body>

<h1>Books List</h1>

<a href="/books/new">Add New Book</a>

<form method="get" action="${pageContext.request.contextPath}/books">
    Search by Author Name:
    <input type="text" name="authorName" value="${authorName}"/>
    <button type="submit">Search</button>
</form>

<table>
    <tr>
        <th>ID</th><th>Title</th><th>ISBN</th><th>Author</th><th>Action</th>
    </tr>
    <c:forEach var="b" items="${books}">
        <tr>
            <td>${b.id}</td>
            <td>${b.title}</td>
            <td>${b.isbn}</td>
            <td>${b.author.name}</td>
            <td>
                <a href="${pageContext.request.contextPath}/books/edit/${b.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
