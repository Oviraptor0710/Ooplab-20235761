package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {

    private final int    id;          // unique per object
    private String       title;
    private String       category;
    private float        cost;

    private static int nbMedia = 0;   // class‑wide counter

    public Media(String title, String category, float cost) {
        this.id       = ++nbMedia;
        this.title    = title;
        this.category = category;
        this.cost     = cost;
    }

    public int getId()             { return id; }
    public String getTitle()      { return title; }
    public String getCategory()   { return category; }
    public float getCost()        { return cost; }

    public void setTitle(String title)       { this.title = title; }
    public void setCategory(String category) { this.category = category; }
    public void setCost(float cost)          { this.cost = cost; }

    @Override
    public String toString() {
        return String.format("Media[id=%d, title='%s', category='%s', cost=%.2f]",
                id, title, category, cost);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Media media)) {
            return false;
        }
        return media.getTitle().equalsIgnoreCase(this.getTitle());
    }

    // Registering your custom comparators for reuse
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}