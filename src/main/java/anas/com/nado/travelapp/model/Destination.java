package anas.com.nado.travelapp.model;

import java.util.List;

public class Destination {
    // Model is name POJO ==> plain old java object

    private int id;
    private String title;
    private String featuredImageUrl;
    private int placeCount;

    public Destination(int id, String title, String featuredImageUrl , int placeCount) {
        this.id = id;
        this.title = title;
        this.featuredImageUrl = featuredImageUrl;
        this.placeCount = placeCount;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public int getPlaceCount() {
        return placeCount;
    }
}