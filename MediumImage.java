package com.example.sasidhar.tanishka;

/**
 * Created by sasidhar on 8/5/16.
 */
public class MediumImage
{
    private Height Height;

    private Width Width;

    private String URL;

    public Height getHeight ()
    {
        return Height;
    }

    public void setHeight (Height Height)
    {
        this.Height = Height;
    }

    public Width getWidth ()
    {
        return Width;
    }

    public void setWidth (Width Width)
    {
        this.Width = Width;
    }

    public String getURL ()
    {
        return URL;
    }

    public void setURL (String URL)
    {
        this.URL = URL;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Height = "+Height+", Width = "+Width+", URL = "+URL+"]";
    }
}

