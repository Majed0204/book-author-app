<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css" />

    <title>Add Author</title>
</head>
<body>

<h1>Add New Author</h1>

<form action="${pageContext.request.contextPath}/authors/save" method="post">
    <input type="hidden" name="id" value="${author.id}"/>
    Name: <input type="text" name="name" value="${author.name}" />
    <button type="submit">Save</button>
</form>


<a href="/authors">Back to Authors List</a>

</body>
</html>
