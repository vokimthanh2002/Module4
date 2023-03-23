<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Ten</th>
        <th>Ngay Sinh</th>
        <th>Dia Chi</th>
        <th>Anh</th>
    </tr>
        <c:forEach items="${product}"  var ="product">
        <tr>
            <td>${product.idProduct}</td>
            <td>${product.nameProduct}</td>
            <td>${product.price}</td>
            <td><img src="./image/${product.image}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>