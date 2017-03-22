
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>List Musics</h1>
<br />

<table class="table" >
    <thead>
    <th>ID</th>
    <th>Name</th>
    <th>Release Date</th>
    <th>Name Album</th>
    <th>Options</th>
</thead>
<tbody>
    <c:if test="${!empty musics}">
        <c:forEach items="${musics}" var="music" >
            <tr>
                <td>${music.id}</td>
                <td>${music.name}</td>
                <td><fmt:formatDate value="${music.releaseDate}" pattern="dd/MM/yyyy" timeZone="UTC" /></td>
                <td>${music.album.name}</td>
                <td>
                    <a href="/TreinaWebSpringMVC/musics/update/${music.id}">update</a> | <a href="/TreinaWebSpringMVC/musics/delete/${music.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</tbody>
</table>
<br />
<a href="/TreinaWebSpringMVC/musics/create" class="btn btn-default">Create the new Music</a>
