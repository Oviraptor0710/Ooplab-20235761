package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

	//constructor_methods
	public DigitalVideoDisc(String title, String category, String director, int length, float  cost) {
		super(title, category, cost, director, length);
	}
	public DigitalVideoDisc(String title) {
		super(title, null, 0);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public DigitalVideoDisc(String title, String category, float cost, String director) {
		super(title, category, cost);
		this.setDirector(director);
	}
	public DigitalVideoDisc(String title, String category,  float cost, String director, int length) {
		super(title, category, cost, director, length);		
	}	
	
	@Override
	public void play() { 
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}
	
	@Override
	public String toString() {
		return String.format("DVD[id:%d, title:%s, category:%s, cost:%.2f, director:%s, length:%d]", getId(), getTitle(),
				getCategory(), getCost(), getDirector(), getLength());
	}
}