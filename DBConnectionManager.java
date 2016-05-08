package com.example.sasidhar.tanishka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by sasidhar on 25/2/16.
 */
public class DBConnectionManager {
    public Connection getMconnection() {
        return mconnection;
    }

    //  To hold the connection string
    public Connection mconnection;
//  To the hold the url
    private String url;
//  Return the connection with configured parameters as required
    public static DBConnectionManager getInstance() throws  SQLException{
        return new DBConnectionManager();
    }
//  Local constructor
    private DBConnectionManager() throws SQLException {
    url = "jdbc:postgresql://localhost:5432/ITEMDATA";
    Properties props = new Properties();
    props.setProperty("user","postgres");
    props.setProperty("password","sasidhar");
    mconnection = DriverManager.getConnection(url,props);
    }
}
