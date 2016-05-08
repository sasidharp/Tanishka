package com.example.sasidhar.tanishka;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by sasidhar on 4/5/16.
 */
public class ProductPersist {

    DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
//  Returns the new instance of mongodatabse
    public MongoDatabase get_database(){
        MongoClient mongoClient = new MongoClient();
        return mongoClient.getDatabase(AmazonConfig.MONGODB);
    }
// Save record
    public void save_record(){
        MongoDatabase db = get_database();
        db.getCollection("records").insertOne(new Document("Greeting",new Document()));

    }


}
