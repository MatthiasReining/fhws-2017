<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World 222!</h1>
        
        <br>
        Timestamp vom Server <%= new Date() %><br>
        <hr>
        
        Timestamp vom Server <c:out value="${fhwsTime}"/>
        <br>
        <hr>
        <b>fett complex: <c:out value="${complexObj.calc(2.0)}"/>
        
        
    </body>
</html>
