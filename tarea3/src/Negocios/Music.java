package Negocios;

import java.io.Serializable;

public class Music implements Serializable {
    private static final long serialVersionUID = 1L;
    private String SKU;
    private String artist;
    private String title;
    private String genre;
    private String type;
    private String year;

    public Music() {}

    public Music(String SKU, String artist, String title, String year, String genre, String type) {
        this.SKU = SKU;
        this.artist = artist;
        this.title = title;
        this.genre = genre;
        this.type = type;
        this.year = year;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
