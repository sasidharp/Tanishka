package com.example.sasidhar.tanishka;

import java.util.ArrayList;

/**
 * Created by sasidhar on 8/2/16.
 */
public class ProdAPI {
//  Hold the arraylist
    private static ArrayList<String> VALID_CONDITION_VALUES= new ArrayList<String>();
    private static ArrayList<String> IDTYPE_VALUES = new ArrayList<String>();
    private static ArrayList<String> RESPONSEGROUP_VALUES = new ArrayList<String>();
//  Return the arraylist containing the valid value of condition types
    public static ArrayList<String> get_valid_condtypes(){
        VALID_CONDITION_VALUES.add("New");
        VALID_CONDITION_VALUES.add("Used");
        VALID_CONDITION_VALUES.add("Collectible");
        VALID_CONDITION_VALUES.add("Refurbished");
        VALID_CONDITION_VALUES.add("All");
        return VALID_CONDITION_VALUES;
    }
    //  Return the arraylist containing the valid value of ID types
    public static ArrayList<String> get_valid_idtypes(){
        IDTYPE_VALUES.add("ASIN");
        IDTYPE_VALUES.add("SKU");
        IDTYPE_VALUES.add("UPC");
        IDTYPE_VALUES.add("EAN");
        IDTYPE_VALUES.add("ISBN");
        return IDTYPE_VALUES;
    }
    //  Return the arraylist containing the valid value of ID types
    public static ArrayList<String> get_valid_ResponseGroup(){
        RESPONSEGROUP_VALUES.add("Accessories");
        RESPONSEGROUP_VALUES.add("BrowseNodes");
        RESPONSEGROUP_VALUES.add("EditorialReview");
        RESPONSEGROUP_VALUES.add("Images");
        RESPONSEGROUP_VALUES.add("ItemAttributes");
        RESPONSEGROUP_VALUES.add("ItemIds");
        RESPONSEGROUP_VALUES.add("Large");
        RESPONSEGROUP_VALUES.add("Medium");
        RESPONSEGROUP_VALUES.add("OfferFull");
        RESPONSEGROUP_VALUES.add("Offers");
        RESPONSEGROUP_VALUES.add("Promotion");
        RESPONSEGROUP_VALUES.add("Summary");
        RESPONSEGROUP_VALUES.add("OfferSummary");
        RESPONSEGROUP_VALUES.add("RelatedItems");
        RESPONSEGROUP_VALUES.add("Reviews");
        RESPONSEGROUP_VALUES.add("SalesRank");
        RESPONSEGROUP_VALUES.add("Similarities");
        RESPONSEGROUP_VALUES.add("Small");
        RESPONSEGROUP_VALUES.add("Tracks");
        RESPONSEGROUP_VALUES.add("Variations");
        RESPONSEGROUP_VALUES.add("VariationSummary");
        return RESPONSEGROUP_VALUES;
    }

}
