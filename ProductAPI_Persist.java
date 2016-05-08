package com.example.sasidhar.tanishka;

import org.xmlpull.v1.XmlPullParserException;

import java.io.StringReader;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by sasidhar on 11/4/16.
 */
public class ProductAPI_Persist {
    Connection connection  = null;
    //Get the underlying database manager
    Connection get_dbconnection(){
        try{
             return DBConnectionManager.getInstance().getMconnection();
        }catch ( SQLException e){
            e.printStackTrace();
        };
    return connection;
    }
    //Get the product data
    ArrayList<amazonitem>get_data(StringReader str , ProdAPI_ItemSearch query_params) throws ProdAPI_ItemSearchException {

        ArrayList<amazonitem> itemlist = null ;
        //Get the leecher class
        leecher l1 = new leecher();
        //get the entries in object format
        try{
            itemlist = l1.main(str , query_params);
        }catch (XmlPullParserException e){
            e.printStackTrace();
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
        return itemlist;
    }
  //Save to DB
    void save_db(ArrayList<amazonitem> itm_list){
        connection = get_dbconnection();
        Statement statement = null;
        ResultSet rs = null;
        //Create SQL statement
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Send into DB
        //asin
        //title
        //description
        //image_small
        //image_medium
        //image_big

        String update_sql = "INSERT INTO items\n" +
                "VALUES ('%s' ,'%s' , '%s' ,'%s' ,'%s' , '%s', '%s' );";
        for (amazonitem itm :itm_list) {
//          String.format(update_sql, itm.getASIN(),itm.getITEMDESCRIPTION());

            String query = String.format( update_sql,
                                          itm.getASIN(),
                                          itm.getITEMDESCRIPTION(),
                                          itm.getASIN(),
                                          itm.getSMALL_IMAGE(),
                                          itm.getMEDIUM_IMAGE(),
                                          itm.getBIG_IMAGE(),
                                          itm.getFEATURE());

            try {
                statement.executeUpdate(query);

            } catch (SQLException e) {
                System.out.println(e.toString());
            }

        }


    }




}
