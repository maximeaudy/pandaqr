<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head></head>
<body>
<h1>Login</h1>
<form:form name='f' action="j_security_check" method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='email' name='j_username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='j_password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>