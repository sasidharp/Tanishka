package com.example.sasidhar.tanishka;
import java.io.IOException;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by sasidhar on 16/1/16.
 */
public class ProdAPI_ItemSearch {
//  Response
    Response OKResponse;
//  HashMap to store the variabels
    private HashMap<String,String> paramsAPI;
    private OkHttpClient client;
//  Request parameters permissible for Item search
    private static final  String OPERATION = "ItemSearch";
    private static final  String SEARCHINDEX = "SearchIndex";
    private static final  String KEYWORDS = "Keywords";
    private static final  String CONDITION = "Condition";
    private static final  String NEW = "New";
    private static final  String IDTYPE = "IdType";
    private static final  String INCLUDEREVIEWSSUMMARY = "IncludeReviewsSummary";
    private static final  String ITEMID = "ItemId";
    private static final  String MERCHANTID = "MerchantId";
    private static final  String RELATEDITEMPAGE = "RelatedItemPage";
    private static final  String RELATIONSHIPTYPE = "RelationshipType";
    private static final  String TRUNCATEREVIEWSAT = "TruncateReviewsAt";
    private static final  String VARIATIONPAGE = "VariationPage";
    private static final  String RESPONSEGROUP = "ResponseGroup";
//**************************************************************************************//
//  Set Condition.If param is blank then set the default to New. If not , check the values
//  Against valid allowed condition types
    public void set_Condition( String condition) throws ProdAPI_ItemSearchException{
        if (condition == null){
//  if no condition is maintained, set the indicator to New
            condition = NEW;
            add_parameter(CONDITION,condition);
        }else {
//  Valid values Used,Collectible,Refurbished,All
            if (ProdAPI.get_valid_condtypes().contains(condition))
                {
//  Append to the list
                    add_parameter(CONDITION,condition);
                }
            else
                {
//  Raise exception or do nothing
                    throw new ProdAPI_ItemSearchException("Condtion");
                }
        }
    }
//**************************************************************************************//
//  Set the IncludeReviewsSummary.Default value is
    public void set_IncludeReviewsSummary(Boolean IncludeReviewsSummary){
        if (IncludeReviewsSummary == null || IncludeReviewsSummary == true)
            {
                add_parameter(INCLUDEREVIEWSSUMMARY,"True");
            }
        else
            {
                add_parameter(INCLUDEREVIEWSSUMMARY,"False");
            }
    }
//**************************************************************************************//
// Set the Item Id
    public void set_itemId(String itemID){
        if (itemID == null){ return ;}
        add_parameter(ITEMID,itemID);
    }
//**************************************************************************************//
// Set the Merchant Id
    public void set_merchantid_amazon(){
        add_parameter(MERCHANTID,"Amazon");
    }
//**************************************************************************************//
// Set the related item page
    public void set_relateditempage(int page) throws ProdAPI_ItemSearchException{
    if (page == 0 || page > 10 ) {
        throw new ProdAPI_ItemSearchException("Invalid ItemPage");
    }else{
        add_parameter(RELATEDITEMPAGE,String.valueOf(page));
    }
    }
//**************************************************************************************//
// Set the relationship type
    public void set_relationshiptype(String relationshiptype){
            add_parameter(RELATIONSHIPTYPE,relationshiptype);
    }
//**************************************************************************************//
// Set the search index.If one of the itemid is ASIN , then seachindices need to be remobed
    public void set_searchindex(String searchindex){
        add_parameter(SEARCHINDEX, searchindex);
    }
//**************************************************************************************//
// Set the TruncateReviewsAt. If its less than zero ...set to zero. 0 returns full review
    public void set_TruncateReviewsAt(Integer TruncateReviewsAt){
       if (TruncateReviewsAt < 0 ){
           TruncateReviewsAt = 0;
       }
       add_parameter(TRUNCATEREVIEWSAT,String.valueOf(TruncateReviewsAt));
    }
//**************************************************************************************//
// Set the VariationPage.If the variation page is less than o and greater than 150 throw
// Exeption
    public void set_VariationPage(Integer VariationPage) throws ProdAPI_ItemSearchException{
        if ( VariationPage < 0 || VariationPage > 150){
            throw new ProdAPI_ItemSearchException("VariationPage should be between 0 and 150");
        }
        add_parameter(VARIATIONPAGE,String.valueOf(VariationPage));
    }
//**************************************************************************************//
// Set the ResponseGroup. If nothing is provided,set the default small.If multiple values
// provided,seperate them by comma and add to the list
    public void set_ResponseGroup(String ResponseGroup) throws ProdAPI_ItemSearchException {
            if (ProdAPI.get_valid_ResponseGroup().contains(ResponseGroup)){
// Check if there is response group already exists, if yes..append them to separate by commas
                if (paramsAPI.containsKey(RESPONSEGROUP)){

                    ResponseGroup = ResponseGroup+","+get_parameter(RESPONSEGROUP);
                }
                add_parameter(RESPONSEGROUP,ResponseGroup);

            }
            else{
               throw new ProdAPI_ItemSearchException("Invalid ResponseGroup");
            }
    }
//**************************************************************************************//
//  Constructor
    public  ProdAPI_ItemSearch( ){
            paramsAPI = new HashMap< String, String >();
            add_parameter("Operation","ItemSearch");
            add_parameter("Service","AWSECommerceService");
    }
//**************************************************************************************//
    //Code for adding the parameters to the product item search
    private void add_parameters(HashMap<String,String> parameters){
    // if parameters are empty do nothing
        if (parameters.isEmpty()){
            return;
        }
    // if yes..exisiting overwritten
        paramsAPI.putAll(parameters);
    }
//**************************************************************************************//
//Code for adding the parameters to the product item search
    private void add_parameter(String key , String Value ){
        // if yes..exisiting overwritten
        paramsAPI.put(key, Value);
    }
//**************************************************************************************//
//Code for adding the parameters to the product item search
    private void delete_parameter(String key ){
        paramsAPI.remove(key);
    }
//**************************************************************************************//
    public void  check_request_params(){
//        Type of item identifier used to look up an item. All IdTypes No
//        except ASINx require a SearchIndex to be specified.

//        This optional parameter is only valid when the Related- No
//        Items response group is used

    }
//**************************************************************************************//
//Code for adding the parameters to the product item search
    public String get_parameter(String key ){
        if( key == null){
            return null;
        }
        return  paramsAPI.get(key);
    }
//**************************************************************************************//
    //Execute the get call and set the response
    public String get(){
        amazon_rest_client client = new amazon_rest_client();
        client.add_params(paramsAPI);

        try {
            return client.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
