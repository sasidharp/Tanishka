package com.example.sasidhar.tanishka;

/**
 * Created by sasidhar on 8/5/16.
 */

public class EANList
{
    private String EANListElement;

    public String getEANListElement ()
    {
        return EANListElement;
    }

    public void setEANListElement (String EANListElement)
    {
        this.EANListElement = EANListElement;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [EANListElement = "+EANListElement+"]";
    }
}

