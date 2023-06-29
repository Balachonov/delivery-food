<%@ page import="balachonov.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: Balac
  Date: 27.06.2023
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start user menu</title>
</head>
<body>
<table>
    <form action="/user/opening-menu" method="post">
        <tr>
            <td>
                <p><u><b>Glad to see you, <%= ((User) session.getAttribute("user")).getFirstName()%>
                    <%= ((User) session.getAttribute("user")).getLastName()%>!</b></u></p>
            </td>
        </tr>
        <tr>
            <td><p><u><b>Please, make your choice</b></u></p></td>
        </tr>
        <tr>
            <td><input type="submit" name="choice" value="Update your personal data"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="choice" value="View all foods"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="choice" value="Delete your account"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="choice" value="Exit"/></td>
        </tr>
    </form>
</table>
</body>
</html>
