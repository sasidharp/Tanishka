package com.example.sasidhar.tanishka;

/**
 * Created by sasidhar on 8/5/16.
 */

public class UPCList
{
    private String UPCListElement;

    public String getUPCListElement ()
    {
        return UPCListElement;
    }

    public void setUPCListElement (String UPCListElement)
    {
        this.UPCListElement = UPCListElement;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [UPCListElement = "+UPCListElement+"]";
    }
}


