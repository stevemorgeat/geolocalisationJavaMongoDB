/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ms.mongodb.controls;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import fr.ms.mongodb.daos.ConnexionsLocales;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CinemasCTRL", urlPatterns = {"/CinemasCTRL"})
public class CinemasCTRL extends HttpServlet {

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
            out.println("<title>Servlet CinemasCTRL</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CinemasCTRL at " + request.getContextPath() + "</h1>");
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
        MongoDatabase db;
        MongoCollection collection;
        FindIterable<Document> curseur;
        JSONObject objetJSON;
        JSONArray tableauJSON = new JSONArray();
        Document docProjection = new Document();
        docProjection.put("_id", 0);
        docProjection.put("nomCinema", 1);
        docProjection.put("coords", 1);

        try {
            mongoClient = ConnexionsLocales.getConnexionMongoDB();

            db = mongoClient.getDatabase("cinescope");
            collection = db.getCollection("cinemas");

            curseur = collection.find();

            for (Document doc : curseur) {
                System.out.println(doc.get("nomCinema"));
                System.out.println(doc.get("coords"));
                objetJSON = new JSONObject();
                objetJSON.put("nomCinema",doc.get("nomCinema"));
                objetJSON.put("coords",doc.get("coords"));
                tableauJSON.add(objetJSON);
            }

        } catch (Exception e) {
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
        }

        request.setAttribute("listeCinemas", tableauJSON);
        
        String lsURL = "cinemas.jsp";
        getServletContext().getRequestDispatcher("/" + lsURL).forward(request, response);
      //  out.print(tableauJSON);
    }///doget

}///class
