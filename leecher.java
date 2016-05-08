package com.example.sasidhar.tanishka;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sasidhar on 10/1/16.
 */
public class leecher {

    public ArrayList<amazonitem> main(StringReader str , ProdAPI_ItemSearch query_params) throws XmlPullParserException, IOException, ProdAPI_ItemSearchException {
        int num_of_pages = 0;
        ArrayList<amazonitem> itemlist = new ArrayList<amazonitem>();
        amazonitem item = null;
        String parent_tag = null;
        String call_stack = null;
        char[] ch = null;
        int[] var1 = {1, 2, 3, 4};
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xapp = factory.newPullParser();
        boolean first_loop = true;
        ProdAPI_ItemSearch itemSearch = new ProdAPI_ItemSearch();
        HashMap<String, String> params;


        boolean ASIN = false;
        int event_type = xapp.getEventType();
        xapp.setInput(str);
////      Read the number of the pages of the resultset.
        while (event_type != XmlPullParser.END_DOCUMENT) {
            if (xapp.getEventType() == XmlPullParser.START_TAG && xapp.getName() == "TotalPages") {
                num_of_pages = Integer.valueOf(xapp.nextText());
                break;
            }
            xapp.next();
        }
////      Read all the pages of the resultset
        while (num_of_pages != 0) {
///       Set the parameter
            itemSearch.setParamsAPI(query_params.getParamsAPI());
            itemSearch.set_itempage(String.valueOf(num_of_pages));
///       Fire the search
            event_type = 0;
            xapp.setInput(new StringReader(itemSearch.get()));

////      Read the content of each page and append the item list
            while (event_type!= XmlPullParser.END_DOCUMENT){

                if(xapp.getEventType() == XmlPullParser.START_TAG && first_loop == true){
                    System.out.println(xapp.getName()+"\t"+xapp.getDepth());
                }
                if(xapp.getEventType() == XmlPullParser.START_TAG && xapp.getName() =="Item"){
                    item = new amazonitem();
                }

                if(xapp.getEventType() == XmlPullParser.START_TAG && xapp.getName() =="ASIN"){
                    item.setASIN(xapp.nextText());
                }

                if(xapp.getEventType() == XmlPullParser.START_TAG && xapp.getName() =="Title"){
                    item.setITEMDESCRIPTION(xapp.nextText());
                }


                if(xapp.getEventType() == XmlPullParser.START_TAG && xapp.getName() =="Amount"){
                    if (parent_tag == "ListPrice"){
                        item.setCOST(Integer.valueOf(xapp.nextText()));
                    }
                } if(xapp.getEventType() == XmlPullParser.START_TAG && xapp.getName() =="URL"){
                    if (parent_tag == "LargeImage"){
                        item.setBIG_IMAGE(xapp.nextText());
                        item.setMEDIUM_IMAGE(xapp.getPrefix());
                    }
                } if(xapp.getEventType() == XmlPullParser.START_TAG && xapp.getName() =="URL"){
                    if (parent_tag == "SmallImage"){
                        item.setSMALL_IMAGE(xapp.nextText());
                    }
                }



                if(xapp.getEventType() == XmlPullParser.START_TAG && xapp.getName() =="Feature"){
                    item.setFEATURE(xapp.nextText());
                }


                if(xapp.getEventType() == XmlPullParser.END_TAG && xapp.getName() =="Item"){
                    parent_tag = null;
                    itemlist.add(item);
                }
                parent_tag = xapp.getName();
                call_stack = "-"+ parent_tag + call_stack;
                event_type = xapp.next();
            }
            System.out.println("Done reading page number" +itemlist.size());
           num_of_pages--;
        }
        return itemlist;
    }

}
