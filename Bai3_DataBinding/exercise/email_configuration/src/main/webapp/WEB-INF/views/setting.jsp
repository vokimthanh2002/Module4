<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<form:form action="/getmail" method="post" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="language">Languages: </form:label></td>
            <td><form:select path="language">
                <form:options items="${languages}"></form:options>
            </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td>
                Show <form:select path="pageSize"><form:options items="${pageSizes}"></form:options></form:select> email per page
            </td>
        </tr>
        <tr>
            <td><form:label path="spams">Spams fillter </form:label></td>
            <td>
                <form:checkbox path="spams" value="Enable spams fillter"/> Enable spams fillter
            </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>

</body>
</html>