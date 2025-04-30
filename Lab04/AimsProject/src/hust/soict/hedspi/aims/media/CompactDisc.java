package hust.soict.hedspi.aims.media;
import java.util.List;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track>tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	public CompactDisc(String title, String category, float cost, String director, String artist, List<Track>tracks) {
		super(title, category, cost, director);
		this.artist = artist;
		if(tracks != null) {
			tracks.forEach(track->addTrack(track));
		}
	}
	public CompactDisc(String title, String category,float  cost, String artist, String director) {
		super(title, category, cost, director);
		this.artist = artist;
}
	//add_track_method
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("Already exist");
		}else {
			System.out.println("Track: " + track + "is added successfully");
			tracks.add(track);
		}
	}
	
	//remove_track_method
	public void removeTrack(Track track) {
		if(tracks == null) return;
		if(!tracks.contains(track)) {
			System.out.println("Not found");
		}else {
			System.out.println("Track: " + track + "is removed successfully");
			tracks.remove(track);
		}
	}
	
	//sum_of_all_tracks
	public int getLength(List<Track>tracks) {
		int sum = 0;
		for(Track track:tracks) {
			sum += track.getLength();
		}
		return sum;
	}
	
	@Override
	public void play() {
		System.out.println("Title: " + this.getTitle());
		System.out.println("Category: " + this.getCategory());
		System.out.println("Cost: " + this.getCost());
		System.out.println("Director: " + this.getDirector());
		System.out.println("Artist: " + this.getArtist());
		System.out.println("-------------TrackList--------------");
		for(Track track: tracks) {	
			System.out.println(track.getTitle() + " - " + track.getLength());
		}
		System.out.println("=============");
	}
	@Override
	public String toString() {
		return String.format("CD[id:%d, title:%s, category:%s, cost:%.2f, director:%s, artist: %s", getId(), getTitle(),
				getCategory(), getCost(), getDirector(), artist);
		}
	}

