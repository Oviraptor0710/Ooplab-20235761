package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        int result = o1.getTitle().compareToIgnoreCase(o2.getTitle()); // title ascending
        if (result == 0) {
            result = Float.compare(o2.getCost(), o1.getCost()); // cost descending
        }
        return result;
    }
}