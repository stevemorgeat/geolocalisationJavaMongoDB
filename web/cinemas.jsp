<%-- 
    Document   : cinemas
    Created on : 27 nov. 2017, 10:13:25
    Author     : allth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cinémas</title>
    </head>
    <body>
        <h1>Cinémas</h1>

        <table>
            <thead>
                <tr>
                    <th>Nom du cinéma</th>
                    <th>Latitude</th>
                    <th>Longitude</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="element" items="${listeCinemas}">
                    <tr>
                        <td>${element["nomCinema"]}</td>
                        <td>${element["coords"]["lat"]}</td>
                        <td>${element["coords"]["lng"]}</td>
                    </tr> 
                </c:forEach>

            </tbody>
        </table>
    </body>
</html>
