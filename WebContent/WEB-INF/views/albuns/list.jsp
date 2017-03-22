
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>List Albuns</h1>
<br />
<div class="row">
    <div class="col-md-10">
        <div class="form-group">
            <label>Search any Album</label>
            <input type="text" id="text-search" class="form-control" />
            <button class="btn btn-default" id="btn-search" >Search</button>
        </div>
    </div>
</div>
<table class="table" id="table-albuns">
    <thead>
        <th>ID</th>
        <th>Name</th>
        <th>Release Year</th>
        <th>Options</th>
    </thead>
    <tbody>
        <c:if test="${!empty albuns}">
            <c:forEach items="${albuns}" var="album" >
                <tr>
                    <td>${album.id}</td>
                    <td>${album.name}</td>
                    <td>${album.releaseYear}</td>
                    <td>
                        <a href="/TreinaWebSpringMVC/albuns/update/${album.id}">update</a> | <a href="/TreinaWebSpringMVC/albuns/delete/${album.id}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>
<br />
<a href="/TreinaWebSpringMVC/albuns/create" class="btn btn-default">Create the new Album</a>
<script type="text/javascript">
    $(document).ready(function(){
        $('#btn-search').click(function(){
           var textToFind = $('#text-search').val();
           $.ajax({
               method: 'GET',
               url: '/TreinaWebSpringMVC/albuns/listByName?name=' + textToFind,
               success: function(data){
                   $('#table-albuns tbody > tr').remove();
                   $.each(data, function(index, album){
                       $('#table-albuns tbody').append(
                           '<tr>' +
                           '    <td>' + album.id + '</td>' +
                           '    <td>' + album.name + '</td>' +
                           '    <td>' + album.releaseYear + '</td>' +
                           '    <td>' + 
                           '        <a href="/TreinaWebSpringMVC/albuns/update/' + album.id + '">Update</a> | ' +
                           '        <a href="/TreinaWebSpringMVC/albuns/delete/' + album.id + '">Delete</a>' +
                           '    </td>' +
                           '</tr>'
                    );
                   });
               },
               error: function(jqXHR, exception){
                   alert('Error on the search');
               }
           });
        });
    });
</script>