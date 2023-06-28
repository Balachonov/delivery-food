<%--
  Created by IntelliJ IDEA.
  User: Balac
  Date: 27.06.2023
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sing In</title>
</head>
<body>
<table>
    <form action="/user/sing-in" method="post">
        <tr>
            <td><p><u><b>Please enter your email and password</b></u></p></td>
        </tr>
        <tr>
            <td> Your email</td>
            <td><input name="email" placeholder="input in format mail@mail.mail" type="text"></td>
        </tr>
        <tr>
            <td> Your password</td>
            <td><input name="password" type="password"></td>
        </tr>
        <tr>
            <td><input type="submit" name="choice" value="Sing in"/></td>
        </tr>
    </form>
    <tr>
        <td>
            <button onclick="location.href='/'">Exit</button>
        </td>
    </tr>
</table>
</body>
</html>
