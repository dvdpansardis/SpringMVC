<%-- 
    Document   : baseLayout
    Created on : Feb 16, 2017, 12:15:50 PM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <s:url value="/resources/js/jquery.min.js" var="jqueryJS" />
        <s:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />
        <s:url value="/resources/js/bootstrap.min.js" var="bootstrapJS" />
        <title><t:insertAttribute name="title" ignore="true"/></title>
        <script type="text/javascript" src="${jqueryJS}"></script>
        <script type="text/javascript" src="${bootstrapJS}"></script>
        <link href="${bootstrapCSS}" rel="stylesheet"/>
    </head>
    <body>
        <div style="width: 100%;">
            <t:insertAttribute name="header" ignore="false"/>
        </div>
        <div style="width: 100%; margin: 2%;">
            <t:insertAttribute name="body" ignore="false" />
        </div>
        <div style="width: 100%" ignore="false">
            <t:insertAttribute name="footer" ignore="false" />
        </div>
    </body>
</html>
