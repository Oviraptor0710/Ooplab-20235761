package hust.soict.hedspi.aims.media;

import java.lang.Object;
public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	private static int nbMedia = 0;
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public Media(String title, String category, float cost) {
        this.id       = ++nbMedia;
        this.title    = title;
        this.category = category;
        this.cost     = cost;
    }
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Media media = (Media) obj;
	    return this.title != null && this.title.equals(media.title);
	}
	
	@Override
	public String toString() {
		return String.format("Media[id:%d, title:%s, category:%s, cost:%.2f,]", id, title, category, cost);
	}
}
