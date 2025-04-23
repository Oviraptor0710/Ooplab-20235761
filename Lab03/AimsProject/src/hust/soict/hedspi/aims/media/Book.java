package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category,
                float cost, List<String> authors) {

        super(title, category, cost);
        if (authors != null) {
            authors.forEach(this::addAuthor);
        }
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public boolean addAuthor(String authorName) {
        if (authorName == null || authorName.isBlank()) return false;

        if (authors.contains(authorName)) {
            System.out.printf("Already exist");
            return false;
        }
        authors.add(authorName);
        System.out.printf("Author " + authorName + " is added");
        return true;
    }

    public boolean removeAuthor(String authorName) {
        if (authors.remove(authorName)) {
            System.out.printf("Remove successgully");
            return true;
        }
        System.out.printf("Not found");
        return false;
    }

    @Override
    public String toString() {
        return String.format("Book[id=%d, title='%s', category='%s', cost=%.2f, authors=%s]",
                getId(), getTitle(), getCategory(), getCost(), authors);
    }
}