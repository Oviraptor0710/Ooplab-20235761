package hust.soict.hedspi.aims.media;

import java.util.List;
import java.util.ArrayList;
public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	public Book(String title, String category, float cost, List<String>authors) {
		super(title, category, cost);
		if(authors != null) {
			authors.forEach(authorName->addAuthor(authorName));
		}
	}
	//add_author_method
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("Already exist");
		}else {
			System.out.println("Author: " + authorName + " is added successfully");
			authors.add(authorName);
		}
	}
	
	//remove_author_name
	public void removeAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			System.out.println("Not found");
		}else {
			System.out.println("Author: " + authorName + " is removed successfully");
			authors.remove(authorName);
		}
	}
	@Override
	public String toString() {
	    return String.format("Book[id=%d, title='%s', category='%s', cost=%.2f, authors=%s]",
	        getId(), getTitle(), getCategory(), getCost(), authors);
	    }
}
