<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>List Condiments</h1>
<table border="1">
  <tr>
    <td>
      <c:forEach items="${condiments}" var="c">
        ${c}
      </c:forEach>
    </td>
  </tr>
</table>
</body>
</html>