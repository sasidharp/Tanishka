package com.example.sasidhar.tanishka;

/**
 * Created by sasidhar on 8/5/16.
 */
public class PackageDimensions
{
    private Weight Weight;

    private Length Length;

    private Height Height;

    private Width Width;

    public Weight getWeight ()
    {
        return Weight;
    }

    public void setWeight (Weight Weight)
    {
        this.Weight = Weight;
    }

    public Length getLength ()
    {
        return Length;
    }

    public void setLength (Length Length)
    {
        this.Length = Length;
    }

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

    @Override
    public String toString()
    {
        return "ClassPojo [Weight = "+Weight+", Length = "+Length+", Height = "+Height+", Width = "+Width+"]";
    }
}
