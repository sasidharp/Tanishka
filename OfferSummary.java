package com.example.sasidhar.tanishka;

/**
 * Created by sasidhar on 7/5/16.
 */
public class OfferSummary {

    private Integer TotalNew = 0;
    private Integer TotalUsed= 0;
    private Integer TotalCollectible = 0;
    private Integer TotalRefurbished = 0;

    private LowestUsedPrice lowestUsedPrice;
    private LowestNewPrice lowestNewPrice;

    public LowestUsedPrice getLowestUsedPrice() {
        return lowestUsedPrice;
    }

    public void setLowestUsedPrice(LowestUsedPrice lowestUsedPrice) {
        this.lowestUsedPrice = lowestUsedPrice;
    }

    public LowestNewPrice getLowestNewPrice() {
        return lowestNewPrice;
    }

    public void setLowestNewPrice(LowestNewPrice lowestNewPrice) {
        this.lowestNewPrice = lowestNewPrice;
    }

    public Integer getTotalNew() {
        return TotalNew;
    }

    public void setTotalNew(String totalNew) {
        TotalNew = Integer.valueOf(totalNew);
    }

    public Integer getTotalUsed() {
        return TotalUsed;
    }

    public void setTotalUsed(String totalUsed) {
        TotalUsed = Integer.valueOf(totalUsed);
    }

    public Integer getTotalCollectible() {
        return TotalCollectible;
    }

    public void setTotalCollectible(String totalCollectible) {
        TotalCollectible = Integer.valueOf(totalCollectible);
    }

    public Integer getTotalRefurbished() {
        return TotalRefurbished;
    }

    public void setTotalRefurbished(String totalRefurbished) {
        TotalRefurbished = Integer.valueOf(totalRefurbished);
    }


}
