package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        int result = Float.compare(o2.getCost(), o1.getCost()); // cost descending
        if (result == 0) {
            result = o1.getTitle().compareToIgnoreCase(o2.getTitle()); // title ascending
        }
        return result;
    }
}