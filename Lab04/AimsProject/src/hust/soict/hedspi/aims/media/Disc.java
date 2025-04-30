package hust.soict.hedspi.aims.media;

public class Disc extends Media {	
	private String director;
	private int length;
	
	//getters
	public String getDirector() {
			return director;
	}
	public int getLength() {
			return length;
	}
	//setters
	public void setDirector(String director) {
			this.director = director;
	}
	public void setLength(int length) {
			this.length = length;
	}
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public Disc(String title, String category, float cost, String director, int length) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
	}
	
	
	public Disc(String title, String category, float cost, String director) {
		super(title, category, cost);
		this.director = director;
	}
}
