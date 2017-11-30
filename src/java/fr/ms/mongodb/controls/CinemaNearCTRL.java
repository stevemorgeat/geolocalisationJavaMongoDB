/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ms.mongodb.controls;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import fr.ms.mongodb.daos.ConnexionsLocales;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author allth
 */
@WebServlet(name = "CinemaNearCTRL", urlPatterns = {"/CinemaNearCTRL"})
public class CinemaNearCTRL extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CinemaNearCTRL</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CinemaNearCTRL at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        MongoClient mongoClient = null;
        JSONObject objetJSON;
        JSONArray tableauJSON = new JSONArray();

        try {
            mongoClient = ConnexionsLocales.getConnexionMongoDB();
            MongoDatabase db = mongoClient.getDatabase("cinescope");
            // La collection
            MongoCollection collection = db.getCollection("cinemas");
            // QUERY
            Document document;
            String coordonnee = request.getParameter("coordonnee");

            double latitude = Double.valueOf(request.getParameter("lat"));
            double longitude = Double.valueOf(request.getParameter("lng"));
            
            List<Double> listeCoordonnees = new ArrayList();
            listeCoordonnees.add(longitude);
            listeCoordonnees.add(latitude);
            int liMaxDistance = Integer.valueOf(request.getParameter("distance"));

            BasicDBObject requeteNear = (BasicDBObject) BasicDBObjectBuilder.start()
                    .push("coords")
                    .push("$near")
                    .add("$maxDistance", liMaxDistance)
                    .push("$geometry")
                    .add("coordinates", listeCoordonnees)
                    .get();
            /*
             Balayage du curseur
             */
            FindIterable<Document> resultat = collection.find(requeteNear);
            MongoCursor<Document> curseur = resultat.iterator();
            while (curseur.hasNext()) {
                document = curseur.next();
                objetJSON = new JSONObject();
                objetJSON.put("nomCinema", document.get("nomCinema"));
                objetJSON.put("coords", document.get("coords"));
                tableauJSON.add(objetJSON);
            }
            // Fermeture du curseur
            curseur.close();

        } catch (Exception e) {
            out.println(e.getMessage());
        } finally {
            ConnexionsLocales.deconnexionMDB(mongoClient);
        }
        out.print(tableauJSON);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
