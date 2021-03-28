package anas.com.nado.travelapp.model;

import java.util.List;

public class Place {

    private String title;
    private String description;
    private Location location;
    private String destinationType;
    private String tripDuration;
    private String transportation;
    private int numberOfBookings;
    private String featuredImageUrl;
    private List<String> galleryUrls;
    private List<Review> reviews;

    public Place(String title, String description, Location location, String destinationType, String tripDuration, String transportation, int numberOfBookings, String featuredImageUrl, List<String> galleryUrls, List<Review> reviews) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.destinationType = destinationType;
        this.tripDuration = tripDuration;
        this.transportation = transportation;
        this.numberOfBookings = numberOfBookings;
        this.featuredImageUrl = featuredImageUrl;
        this.galleryUrls = galleryUrls;
        this.reviews = reviews;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Location getLocation() {
        return location;
    }

    public String getDestinationType() {
        return destinationType;
    }

    public String getTripDuration() {
        return tripDuration;
    }

    public String getTransportation() {
        return transportation;
    }

    public int getNumberOfBookings() {
        return numberOfBookings;
    }

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public List<String> getGalleryUrls() {
        return galleryUrls;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
