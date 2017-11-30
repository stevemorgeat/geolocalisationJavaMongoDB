/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.ms.mongodb.daos;

import com.mongodb.MongoClient;

/**
 *
 * @author allth
 */
public class ConnexionMongoDBTest {
    public static void main(String[] args) {
        //connexion à la base de données MongoDB via une classe de connexion
        ConnexionMongoDB cnx = new ConnexionMongoDB();
        
        //connexion a la base de données distante
        MongoClient mongoClient = cnx.seConnecter("172.26.10.144", "27017");
        System.out.println(mongoClient);
        
        // test d'existance de la BD
        boolean lbOK = cnx.seDeconnecter(mongoClient);
        System.out.println(lbOK);
        
        // déconnexion
        mongoClient = null;
        System.out.println(mongoClient);
        
    }
}
