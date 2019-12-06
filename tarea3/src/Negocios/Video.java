package Negocios;

import java.io.Serializable;

public class Video implements Serializable {
    private static final long serialVersionUID = 1L;
    private String SKU;
    private String artist;
    private String title;
    private String year;
    private String rating;
    private String type;

    public Video() {}

    public Video(String SKU, String artist, String title, String year, String rating, String type) {
        this.SKU = SKU;
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.type = type;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
