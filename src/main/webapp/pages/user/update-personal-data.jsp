<%@ page import="balachonov.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: Balac
  Date: 27.06.2023
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update personal data</title>
</head>
<body>
<table>
    <form action="/user/update-personal-data" method="post">
        <tr><u><b>Update user</b></u></tr>
        <tr>
            <td>New first name</td>
            <td><input name="first_name" type="text"></td>
            <td>Previous first name</td>
            <td><%=((User) session.getAttribute("user")).getFirstName()%></td>
        </tr>
        <tr>
            <td>New last name</td>
            <td><input name="last_name" type="text">
            <td>Previous last name</td>
            <td><%=((User) session.getAttribute("user")).getLastName()%></td>
        </tr>
        <tr>
            <td>New email</td>
            <td><input name="email" placeholder="input in format mail@mail.mail" type="text"></td>
            <td>Previous email</td>
            <td><%=((User) session.getAttribute("user")).getEmail()%></td>
        </tr>
        <tr>
            <td>New address</td>
            <td><input name="address" type="text"></td>
            <td>Previous address</td>
            <td><%=((User) session.getAttribute("user")).getAddress()%></td>
        </tr>
        <tr>
            <td>New password</td>
            <td><input name="password" type="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
        </tr>
    </form>
    <tr>
        <td>
            <button type="button" name="back" onclick="history.back()"> Back</button>
        </td>
    </tr>
    <tr>
        <td>
            <button onclick="location.href='/pages/user/update-personal-data.jsp'">Exit</button>
        </td>
    </tr>
</table>
</body>
</html>
