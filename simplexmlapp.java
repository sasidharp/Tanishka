package com.example.sasidhar.tanishka;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by sasidhar on 10/1/16.
 */
public class simplexmlapp {
    public void main( StringReader str) throws XmlPullParserException, IOException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xapp = factory.newPullParser();

        xapp.setInput( str );

        int event_type = xapp.getEventType();

        while (event_type!= XmlPullParser.END_DOCUMENT){
            switch ( event_type){
                case XmlPullParser.START_DOCUMENT:
                    System.out.println("Start_of_document");
                    break;
                case XmlPullParser.START_TAG:
                    System.out.println("Start TAG");
                    System.out.println(xapp.getText());
                    break;
                case XmlPullParser.END_TAG:
                    System.out.println("End TAG");
                    break;

                case XmlPullParser.END_DOCUMENT:
                    System.out.println("Start_of_document");
                    break;
            }

        event_type = xapp.next();

        }



    }
}
