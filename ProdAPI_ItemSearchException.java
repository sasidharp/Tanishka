package com.example.sasidhar.tanishka;

/**
 * Created by sasidhar on 16/1/16.
 */
public class ProdAPI_ItemSearchException extends Exception {

    private String message;



    @Override
    public String getMessage() {
        return "ProdAPI_ItemSearchException::"+message;
    }


    public ProdAPI_ItemSearchException(String message) {
        this.message = message;
    }
}
