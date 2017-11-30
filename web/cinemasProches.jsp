<%-- 
    Document   : cinemasProches
    Created on : 27 nov. 2017, 11:29:23
    Author     : allth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/MongoDBWeb/css/main.css" />
        <link rel="stylesheet" type="text/css" href="/MongoDBWeb/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="/MongoDBWeb/jquery/jquery-ui.css" />
        <script src="/MongoDBWeb/jquery/jquery.js"></script>
        <script src="/MongoDBWeb/jquery/jquery-ui.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="row">  
            <div class="col-md-4 col-md-offset-1">
                <form id="formulaireCinemaProche" class="form-group" method="GET" action="">
                    <div class="form-group">
                        <label class="">Recherche cinéma proche : </label>
                    </div>
                    <div class="form-group">
                        <input type="text" name="recherche" id="recherche" class="form-control" placeholder="taper votre cinéma ici" />
                    </div> 
                    <div class="form-group">
                        <label class="">Périmètre : </label>
                    </div>
                    <div class="form-group">
                        <input type="text" name="distance" id="distance" class="form-control" placeholder="1000" value="1000" />
                    </div> 
                    <div class="form-group">
                        <button type="button" id="btSubmit" class="btn btn-primary">Valider</button>
                    </div>
                </form>
            </div>
            <div class="col-md-4 col-md-offset-1">

                <h3>Géo Map Dynamique HTML5</h3>
                <div id="divMap"></div>
                <p>
                    <label id="lblMessage">Message</label>
                </p>


            </div>

        </div>
        
        <script src="http://maps.google.com/maps/api/js?key=AIzaSyD07327vXN54GrtvToNdXXAMWGa-C-AnUI"></script>
        <script src="/MongoDBWeb/js/bootstrap.min.js"></script>
        <script src="/MongoDBWeb/js/main.js"></script>
    </body>
</html>
