<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>
<form action="personController"   >
    <input type="hidden" name="command" value="login"/>
    <div>
        E-mail:<input type="text" name="e_mail" value=""/>
    </div>
    <div>
        Password: <input type="password" name="password" value=""/>
    </div>
    <input type="submit" name="push" value="login" />
    <br/>
</form>
</body>
</html>
