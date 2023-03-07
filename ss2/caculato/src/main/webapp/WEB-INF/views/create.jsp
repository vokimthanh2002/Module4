<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 07/03/2023
  Time: 10:44 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Calculate</title>
</head>
<body>
<h1>Calculate</h1>
<form action="/calculate" method="post">
  <input type="number" placeholder="input number one" name="num1">
  <input type="number" placeholder="input number two" name="num2">
  <input type="submit" name="calculate" value="+">
  <input type="submit" name="calculate" value="-">
  <input type="submit" name="calculate" value="*">
  <input type="submit" name="calculate" value="/">
</form>
<h3>result: <span>${result}</span></h3>
</body>
</html>
