<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />

    <title>Add Book</title>
</head>
<body>

<h1>Add New Book</h1>

<form action="${pageContext.request.contextPath}/books/save" method="post">
    <input type="hidden" name="id" value="${book.id}"/>

    Title: <input type="text" name="title" value="${book.title}" /><br/>
    ISBN: <input type="text" name="isbn" value="${book.isbn}" /><br/>

    Author:
    <select name="authorId">
        <c:forEach var="a" items="${authors}">
            <option value="${a.id}" ${book.author != null && book.author.id == a.id ? 'selected' : ''}>
                    ${a.name}
            </option>
        </c:forEach>
    </select>

    <button type="submit">Save</button>
</form>


</body>
</html>
