
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<h1>Login</h1>
<br />
<form action="/TreinaWebSpringMVC/login" method="post">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Name:</label>
                <input type="text" name="username" class="form-control"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Password:</label>
                <input type="password" name="password" class="form-control"/>
            </div>
        </div>
    </div>

    <input type="submit" value="login" class="btn btn-default"/>
</form>

