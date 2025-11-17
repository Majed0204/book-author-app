<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />

    <title>Edit Book</title>
</head>
<body>

<h1>Edit Book</h1>

<form action="/books/update" method="post">

    <input type="hidden" name="id" value="${book.id}"/>

    <label>Title:</label>
    <input type="text" name="title" value="${book.title}" required><br><br>

    <label>ISBN:</label>
    <input type="text" name="isbn" value="${book.isbn}" required><br><br>

    <label>Author:</label>
    <select name="authorId">
        <c:forEach var="author" items="${authors}">
            <option value="${author.id}"
                    <c:if test="${author.id == book.author.id}">selected</c:if>
            >
                    ${author.name}
            </option>
        </c:forEach>
    </select><br><br>

    <button type="submit">Update</button>

</form>

</body>
</html>
