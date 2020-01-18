<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Connexion</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style type="text/css">
        body{
            background-color:#f1f1f1;
        }

        .container{
            background-color:white;
            min-height: 100vh;
            padding-top:5%;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="col-md-12">
            <h1>Login</h1>
            <form:form name='f' action="j_security_check" method='POST'>
            <div class="form-group">
                <label>Email</label>
                <input type='email' class="form-control" name='j_username' value=''>
            </div>
            <div class="form-group">
                <label>Mot de passe</label>
                <input type='password' class="form-control" name='j_password' />
            </div>
            <div class="form-group">
                <input name="submit" class="btn btn-primary" type="submit" value="submit" />
            </div>
            </form:form>
        </div>
    </div>
</body>
</html>