package hust.soict.hedspi.aims.media;
import java.util.Objects;

public class DigitalVideoDisc extends Disc implements Playable {


    public DigitalVideoDisc(String title,
                            String category,
                            String director,
                            int    length,
                            float  cost) {
        super(title, category, cost, director, length);
    }

    public DigitalVideoDisc(String title) {
        this(title, null, null, 0, 0f);
    }

    public DigitalVideoDisc(String title,
                            String category,
                            float  cost) {
        this(title, category, null, 0, cost);
    }

    public DigitalVideoDisc(String title,
                            String category,
                            String director,
                            float  cost) {
        this(title, category, director, 0, cost);
    }


    public void setLength(int length) {
        super.setLength(Math.max(length, 0));
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.printf("ERROR: DVD cannot be played",
                    getTitle());
            return;
        }

        System.out.printf("Playing DVD: %s%nDVD length: %d minutes%n",
                getTitle(), getLength());
    }

    @Override
    public String toString() {
        return String.format("DVD[id=%d, title='%s', category='%s', "
                        + "director='%s', length=%d min, cost=%.2f]",
                getId(), getTitle(), getCategory(),
                getDirector(), getLength(), getCost());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)               return true;
        if (!(obj instanceof DigitalVideoDisc)) return false;
        DigitalVideoDisc other = (DigitalVideoDisc) obj;
        return Objects.equals(getTitle(), other.getTitle());
    }
}