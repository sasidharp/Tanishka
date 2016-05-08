package com.example.sasidhar.tanishka;

/**
 * Created by sasidhar on 8/5/16.
 */
public class Width
{
    private String content;

    private String Units;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getUnits ()
    {
        return Units;
    }

    public void setUnits (String Units)
    {
        this.Units = Units;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", Units = "+Units+"]";
    }
}

