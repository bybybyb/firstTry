package model;

public class Film {
    private int id;
    private String title;
    private int year;
    private String genre;
    private boolean watched;

    public void setTitle(String inception) {
        this.title = inception;
    }

    public void setYear(int i) {
        this.year = i;
    }

    public void setGenre(String s) {
        this.genre = s;
    }

    public void setWatched(boolean b) {
        this.watched = b;
    }

    @Override
    public String toString() {
        return (title + "    " + year + "    " + genre + "   " + watched);
    }

    public void setId(int andIncrement) {
        this.id = andIncrement;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public Boolean getWatched() {
        return watched;
    }



// + Getters and setters
}
