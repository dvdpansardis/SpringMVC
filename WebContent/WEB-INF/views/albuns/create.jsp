
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:url var="actionCreate" value="/albuns/create"/>
<h1>Create the new Album</h1>
<br />
<f:form action="${actionCreate}" method="post" modelAttribute="album">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Name:</label>
                <f:input path="name" cssClass="form-control"/>
                <f:errors path="name" cssStyle="color: red;"/>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Release Year:</label>
                <f:input path="releaseYear" cssClass="form-control"/>
                <f:errors path="releaseYear" cssStyle="color: red;"/>
            </div>
        </div>
    </div>
    <input type="submit" value="save" class="btn btn-default"/>
</f:form>


