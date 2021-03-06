
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Treina Web MVC</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <sec:authorize access="isAuthenticated()">
            <sec:authentication property="principal" var="principal" />
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Albuns <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/TreinaWebSpringMVC/albuns/list">List</a></li>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="/TreinaWebSpringMVC/albuns/create">Create</a></li>
                            </sec:authorize>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Music <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/TreinaWebSpringMVC/musics/list">List</a></li>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="/TreinaWebSpringMVC/musics/create">Create</a></li>
                            </sec:authorize>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/TreinaWebSpringMVC/users/list">List</a></li>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li><a href="/TreinaWebSpringMVC/users/create">Create</a></li>
                            </sec:authorize>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Welcome, ${principal.username} <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/TreinaWebSpringMVC/logout">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </sec:authorize>
    </div><!-- /.container-fluid -->
</nav>