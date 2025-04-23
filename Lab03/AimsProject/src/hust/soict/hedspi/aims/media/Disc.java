package hust.soict.hedspi.aims.media;

public abstract class Disc extends Media {
    private int    length;
    private String director;

    protected Disc(String title, String category, float cost) {
        super(title, category, cost);
    }
    protected Disc(String title, String category, float cost,
                   String director, int length) {
        super(title, category, cost);
        this.director = director;
        this.length   = length;
    }

    public int    getLength()   { return length; }
    public String getDirector() { return director; }
    public void setLength(int length)     { this.length = length; }
    public void setDirector(String dir)   { this.director = dir;  }
}

