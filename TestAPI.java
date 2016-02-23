package com.example.sasidhar.tanishka;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by sasidhar on 17/2/16.
 */
public class TestAPI {

    public void testapi() throws ProdAPI_ItemSearchException {

        ProdAPI_ItemSearch itemSearch = new ProdAPI_ItemSearch();
        simplexmlapp XAPP = new simplexmlapp();

        itemSearch.set_searchindex("Apparel");
        itemSearch.set_ResponseGroup("ItemAttributes");
        itemSearch.set_ResponseGroup("Images");
        try {
            XAPP.main(new StringReader(itemSearch.get()));
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    String get_timestamp(){
        Calendar cal = Calendar.getInstance();
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.000Z'");
        dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dfm.format(cal.getTime());
    }
}
