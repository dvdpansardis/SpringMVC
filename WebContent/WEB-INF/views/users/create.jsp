
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:url var="actionCreate" value="/users/create"/>
<h1>Create the new User</h1>
<br />
<f:form action="${actionCreate}" method="post" modelAttribute="user">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Name:</label>
                <f:input path="username" cssClass="form-control"/>
                <f:errors path="username" cssStyle="color: red;"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Password:</label>
                <f:password path="password" cssClass="form-control"/>
                <f:errors path="password" cssStyle="color: red;"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Album:</label>
                <select name="role" cssClass="form-control">
                    <option value="ROLE_ADMIN">Admin</option> 
                    <option value="ROLE_COMMON">Common</option> 
                </select>
            </div>
        </div>
    </div>
    <input type="submit" value="save" class="btn btn-default"/>
</f:form>


