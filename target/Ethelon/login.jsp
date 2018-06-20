

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>
<h1>Login Form</h1>


<form name="loginForm" action="" method="post" >
    <table border="">
        <tbody>
        <tr>
            <td>Email Address : </td>
            <td><input type="text" name="username" value="" size="50"/></td>
        </tr>
        <tr>
            <td>Password : </td>
            <td><input type="password" name="password" value="" size="50"/></td>
        </tr>
        <tr>
            <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
                    : request.getAttribute("errMessage")%></span></td>
        </tr>
        </tbody>
    </table>
    <input type="reset" value="Clear" name="clear"/>
    <input type="submit" value="Submit" name="submit"/>
    No Account? <a href="index.jsp"> Create One</a>

</form>
</body>
</html>