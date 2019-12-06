package Negocios;

import java.io.Serializable;

public class Videogame implements Serializable {
    private static final long serialVersionUID = 1L;
    private String SKU;
    private String title;
    private String year;
    private String edition;
    private String rating;
    private String console;

    public Videogame() {}

    public Videogame(String SKU, String title, String year, String edition, String rating, String console) {
        this.SKU = SKU;
        this.title = title;
        this.year = year;
        this.edition = edition;
        this.rating = rating;
        this.console = console;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }
}
