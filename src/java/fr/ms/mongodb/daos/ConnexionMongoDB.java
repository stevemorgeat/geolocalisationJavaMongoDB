/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ms.mongodb.daos;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class ConnexionMongoDB {

    public MongoClient seConnecter(String psIP, String psPort) {

        MongoClientURI uri = new MongoClientURI("mongodb://" + psIP + ":" + psPort);
        MongoClient mongoClient = new MongoClient(uri);
        return mongoClient;

    } /// seConnecter

    public MongoClient seConnecterServerAvecIdentifiant(String psIP, String psPort, String psUser, String psPwd) {

        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://" + psUser + ":" + psPwd + "@"+ psIP);
        MongoClient mongoClient = new MongoClient(mongoClientURI);
        return mongoClient;

    } /// seConnecter

    /**
     *
     * @param mongoClient
     * @return
     */
    public boolean seDeconnecter(MongoClient mongoClient) {
        boolean lb0K = true;

        try {
            if (mongoClient != null) {
                mongoClient.close();
                mongoClient = null;
            }
        } catch (Exception e) {
            lb0K = false;
        }

        return lb0K;
    } /// seDeconnecter

} /// class
