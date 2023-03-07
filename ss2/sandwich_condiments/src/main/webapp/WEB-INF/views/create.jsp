<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>SandWich Condiments</h1>
<form action="/list" method="post">
     <label>Lettuce</label>
    <input type="checkbox" name="condiments" value="Lettuce">
    <label>Tomato</label>
    <input type="checkbox" name="condiments" value="Tomato" >
    <label>Mustard</label>
    <input type="checkbox" name="condiments" value="Mustard" >
    <label>Sports</label>
    <input type="checkbox" name="condiments" value="Sports">
    <br>
    <input value="Submit" type="submit">
</form>
</body>
</html>