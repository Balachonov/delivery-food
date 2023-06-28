<%@ page import="balachonov.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: Balac
  Date: 28.06.2023
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete your account</title>
</head>
<body>
<table>
    <form action="/user/delete-yourself" method="post">
        <tr><u><b>Delete user</b></u></tr>
        <tr>
            <td>
                <p><u><b>If you are sure, enter your email <%= ((User) session.getAttribute("user")).getFirstName()%>
                    <%= ((User) session.getAttribute("user")).getLastName()%>!</b></u></p>
            </td>
        </tr>
        <tr>
            <td>
                <p><u><b><%= ((User) session.getAttribute("user")).getEmail()%>
                </b></u></p>
            </td>
        </tr>
        <tr>
            <td><input name="email" placeholder="input in format mail@mail.mail" type="text"></td>
        </tr>

        <tr>
            <td><input type="submit" value="Delete"></td>
        </tr>
    </form>
    <tr>
        <td>
            <button type="button" name="back" onclick="history.back()"> Back</button>
        </td>
    </tr>
    <tr>
        <td>
            <button onclick="location.href='/'">Exit</button>
        </td>
    </tr>
</table>
</body>
</html>