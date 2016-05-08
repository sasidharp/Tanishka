package com.example.sasidhar.tanishka;

/**
 * Created by sasidhar on 27/2/16.
 */

public class amazonitem
{
    public String getASIN() {
        return ASIN;
    }

    public void setASIN(String ASIN) {
        this.ASIN = ASIN;
    }

    private String ASIN;

    private ItemAttributes ItemAttributes;

    public ItemAttributes getItemAttributes ()
    {
        return ItemAttributes;
    }

    public void setItemAttributes (ItemAttributes ItemAttributes)
    {
        this.ItemAttributes = ItemAttributes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ItemAttributes = "+ItemAttributes+"]";
    }
}
