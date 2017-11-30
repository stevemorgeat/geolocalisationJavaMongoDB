/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ms.mongodb.daos;

import com.mongodb.MongoClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author allth
 */
public class ConnexionsLocales {

    /**
     *
     * @return
     */
    public static Connection getConnexionMySQL() {
        Connection cnx = null;
        try {
            cnx = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cinescope2017", "root", "");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cnx;
    } /// getConnexionMySQL

    /**
     *
     * @return
     */
    public static MongoClient getConnexionMongoDB() {
        MongoClient mongoClient = null;
        try {
//            MongoClientURI uri = new MongoClientURI("mongodb://127.0.0.1:27017");
//            mongoClient = new MongoClient(uri);
            mongoClient = new MongoClient("172.26.10.144");
//            mongoClient = new MongoClient("127.0.0.1");

            //MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mongoClient;
    } /// getConnexionMongoDB

    /**
     *
     * @param pcnx
     * @return
     */
    public static boolean deconnexionSQL(Connection pcnx) {
        boolean lbOK = true;
        try {
            pcnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lbOK;
    } /// deconnexionSQL

    /**
     *
     * @param pcnx
     * @return
     */
    public static boolean deconnexionMDB(MongoClient pcnx) {
        boolean lbOK = true;
        try {
            pcnx.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lbOK;
    } /// deconnexionMDB

} /// class
