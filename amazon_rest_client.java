package com.example.sasidhar.tanishka;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sasidhar on 2/2/16.
 */
public class amazon_rest_client {

    //  Variables
    private static final String UTF8_CHARSET = "UTF-8";
    private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";


    private SecretKeySpec secretKeySpec = null;
    private Mac mac = null;

    //  Request parameters
    private HashMap params = new HashMap();

    public void SignedRequestsHelper() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] secretyKeyBytes = AmazonConfig.AWS_SECRETKEY.getBytes(UTF8_CHARSET);
        secretKeySpec =
                new SecretKeySpec(secretyKeyBytes, HMAC_SHA256_ALGORITHM);
        mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
        mac.init(secretKeySpec);
    }


    //  Throws Exception
    public void throw_exception(String message) throws  Exception{
        throw new ProdAPI_ItemSearchException(message);
    }
//    //  Check if all the required parameters have been used
//    private void missing_params() throws Exception {
////  Is empty ? Raise exception.
//        if (params.size()==0) {throw_exception("No Parameters Found");}
//// Search index is mandatory
//        if((params.containsKey(ProdAPI_ItemSearchParams.SEARCHINDEX))? true:false){ throw_exception("SEARCHINDEX Required");
//        }
////  RelationshipType is required,if RelatedItems is used for Response Group
//        if(params.get(ProdAPI_ItemSearchParams.RESPONSEGROUP)=="RelatedItems"){
//            boolean  required_missing = (params.containsKey(ProdAPI_ItemSearchParams.RELATIONSHIPTYPE))? true:false;
//            if (required_missing == true ){throw_exception("Relationship Type Required");}
//        }
////  Avl* parameter must be used No with the Condition parameter. When Availability is
////  set to Available , the Condition parameter cannot be set to New. } Add the item search parameters
//        if(params.get(ProdAPI_ItemSearchParams.CONDITION)!=null){
//            boolean condition_failed = (params.get(ProdAPI_ItemSearchParams.CONDITION) != "New");
//            if (condition_failed == true) { throw_exception("Condition cannot be New"); }
//        }
//
//    }
    //  Set the request parameter using key and value
    public void add_param(String K,String V){
        if ( K != null ){params.put(K,V); }  else { }
    }
    //  Set the request parameter using key and value
    public Object get_param(String K) {
        if (params.containsKey(K)){return params.get(K); } else { return null; }
    }
    //  Set the request parameters
    public void add_params(HashMap parameters){
        this.params = parameters;
    }
    //Return the parameters
    public HashMap get_params(HashMap parameters){
        return this.params;
    }
    //Add the timestamp to the parameters
    private void add_timestamp(){
        add_param("Timestamp", timestamp());
    }
    // Return Client
    public static OkHttpClient newclient(){
        return  new OkHttpClient();
    }
    // Call the service
    public String get() throws IOException {
//      Create the http client
        OkHttpClient client = new OkHttpClient();
//      Add timestamp for the url
        Request request = new Request.Builder().url(sign()).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    // Build URL
    public String sign( ) {
    // Set the config parameters from the Amazon config class
    // Begin of configurable parameters
        params.put("AWSAccessKeyId", AmazonConfig.AWS_ACCESSKEY);
        params.put("AssociateTag", AmazonConfig.AWS_ASSOCIATEID);
        params.put("Version", AmazonConfig.VERSION);
        params.put("Timestamp", timestamp());
        params.put("Keywords","test");
    // End of configurable parameters

        SortedMap<String, String> sortedParamMap =
                new TreeMap<String, String>(params);
        String canonicalQS = canoncialize(sortedParamMap);

        String toSign =
                AmazonConfig.REQUEST_METHOD+ "\n"
                        + AmazonConfig.AFFLIATE_URL + "\n" + "/onca/xml" + "\n"
                        + canonicalQS;
        System.out.println(toSign);
        try {
            SignedRequestsHelper();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        String hmac = hmac(toSign);
        System.out.println(hmac);
        String sig =  EncodeParam(hmac);
        System.out.println(sig);
        String url = "http://" +AmazonConfig.AFFLIATE_URL  + "/onca/xml?" + canonicalQS + "&Signature=" + sig;
        System.out.println(url);
        return url;
    }

    private String hmac(String stringToSign) {
        String signature = null;
        byte[] data;
        byte[] rawHmac;
        try {
            data = stringToSign.getBytes(UTF8_CHARSET);

            rawHmac = mac.doFinal(data);
            Base64 encoder = new Base64(100,null);

            signature = new String(encoder.encode(rawHmac));


        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(UTF8_CHARSET + " is unsupported!", e);
        }
        return signature;
    }
    //Build the Amazon API signature
    public byte[] get_signature(String to_sign) throws UnsupportedEncodingException {
        String str = null;
        byte [] data;
        data = to_sign.getBytes("UTF-8");
        System.out.println(data.toString());
        return data;
    }
    //Canonicalize the string
    private  String canoncialize(SortedMap<String,String> sortedParamMap){
        if (sortedParamMap.isEmpty()) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        Iterator<Map.Entry<String, String>> iter = sortedParamMap.entrySet().iterator();

        while( iter.hasNext()){

            Map.Entry<String, String> kvpair = iter.next();
            buffer.append(EncodeParam(kvpair.getKey()));
            buffer.append("=");
            buffer.append(EncodeParam(kvpair.getValue()));

            if (iter.hasNext()){
                buffer.append("&");
            }
        }
        String Canonical = buffer.toString();
        return Canonical;
    }

    // Encode Parametrs
    private String EncodeParam(String param){
        String encoded_value;
        try {
            encoded_value = (URLEncoder.encode(param, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~"));
        } catch (UnsupportedEncodingException e) {
            encoded_value = param;
        }
        return encoded_value;
    }

    private String timestamp(){
        Calendar cal = Calendar.getInstance();
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.000Z'");
        dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dfm.format(cal.getTime());
    }
}
