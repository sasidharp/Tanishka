package com.example.sasidhar.tanishka;

/**
 * Created by sasidhar on 8/5/16.
 */

public class CatalogNumberList
{
    private String CatalogNumberListElement;

    public String getCatalogNumberListElement ()
    {
        return CatalogNumberListElement;
    }

    public void setCatalogNumberListElement (String CatalogNumberListElement)
    {
        this.CatalogNumberListElement = CatalogNumberListElement;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [CatalogNumberListElement = "+CatalogNumberListElement+"]";
    }
}

