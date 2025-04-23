package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private final List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title,
                       String category,
                       float  cost,
                       String artist,
                       String director) {
        super(title, category, cost, director, 0);
        this.artist = artist;
    }

    public String getArtist()         { return artist; }
    public List<Track> getTracks()    { return new ArrayList<>(tracks); }

    public void addTrack(Track track) {
        if (track == null) return;
        if (tracks.contains(track)) {
            System.out.println("Track already exists in CD: " + track.getTitle());
        } else {
            tracks.add(track);
            System.out.println("Added track: " + track.getTitle());
            // update total length
            setLength(getLength() + track.getLength());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Removed track: " + track.getTitle());
            setLength(getLength() - track.getLength());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }

    @Override
    public void play() {
        int totalLen = getLength();
        if (totalLen <= 0) {
            System.out.println("ERROR: CD '" + getTitle() +
                    "' cannot be played – total length ≤ 0!");
            return;
        }
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + artist);
        System.out.println("Total length: " + totalLen + " seconds");
        System.out.println("----- Track list -----");
        tracks.forEach(Track::play);
        System.out.println("----------------------");
    }

    @Override
    public String toString() {
        return String.format("CD - %-20s | %s | %s | %d sec | %.2f $",
                getTitle(), getCategory(), artist,
                getLength(), getCost());
    }
}