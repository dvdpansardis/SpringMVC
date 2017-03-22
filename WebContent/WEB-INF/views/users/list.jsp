
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>List Users</h1>
<br />

<table class="table" >
    <thead>
    <th>ID</th>
    <th>User name</th>
    <th>Role</th>
</thead>
<tbody>
    <c:if test="${!empty users}">
        <c:forEach items="${users}" var="user" >
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
    </c:if>
</tbody>
</table>
<br />
<a href="/TreinaWebSpringMVC/users/create" class="btn btn-default">Create the new User</a>
