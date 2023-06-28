<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new user</title>
</head>
<body>
<table>
    <form action="/user/registration" method="post">
        <tr><u><b>Registration User</b></u></tr>
        <tr>
            <td>First name</td>
            <td><input name="first_name" type="text"></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><input name="last_name" type="text">
        </tr>
        <tr>
            <td>Email</td>
            <td><input name="email" placeholder="input in format mail@mail.mail" type="text"></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input name="address" type="text"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input name="password" type="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Register"></td>
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
