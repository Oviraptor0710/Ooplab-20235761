package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;


public class StoreManagerScreen extends JFrame {

    private final Store  store;        // shared store object
    private final JPanel centerPanel;  // 3×3 grid we can refresh

    public StoreManagerScreen(Store store) {
        this.store = store;

        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        add(north, BorderLayout.NORTH);

        centerPanel = new JPanel(new GridLayout(3, 3, 2, 2));
        refreshCenter();
        add(centerPanel, BorderLayout.CENTER);

        setTitle("Store – Manager");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar bar = new JMenuBar();
        bar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JMenu options = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> refreshCenter());
        options.add(viewStore);

        JMenu update = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(
                e -> new AddBookToStoreScreen(store, this));

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(
                e -> new AddCompactDiscToStoreScreen(store, this));

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(
                e -> new AddDigitalVideoDiscToStoreScreen(store, this));

        update.add(addBook);
        update.add(addCD);
        update.add(addDVD);

        options.add(update);
        bar.add(options);

        /* Keep a reference so the “Add-item” screens can copy it */
        setJMenuBar(bar);
        return bar;
    }


    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }
    

    public void refreshCenter() {
        centerPanel.removeAll();

        ArrayList<Media> items = new ArrayList<>(store.getItemsInStore());
        int cells = Math.min(items.size(), 9);
        for (int i = 0; i < cells; i++) {
            centerPanel.add(new MediaStore(items.get(i)));
        }
        for (int i = cells; i < 9; i++) {
            centerPanel.add(new JPanel());   // filler for empty slots
        }

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private class MediaStore extends JPanel {
        MediaStore(Media m) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel lbTitle = new JLabel(m.getTitle());
            lbTitle.setFont(new Font(lbTitle.getFont().getName(), Font.PLAIN, 15));
            lbTitle.setAlignmentX(CENTER_ALIGNMENT);

            JLabel lbCost = new JLabel(m.getCost() + " $");
            lbCost.setAlignmentX(CENTER_ALIGNMENT);

            JPanel btnPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
            if (m instanceof Playable playable) {
                JButton play = new JButton("Play");
                play.addActionListener(e -> showPlayDialog(playable));
                btnPane.add(play);
            }

            add(Box.createVerticalGlue());
            add(lbTitle);
            add(lbCost);
            add(Box.createVerticalGlue());
            add(btnPane);
        }
    }


    private void showPlayDialog(Playable p) {
        JDialog dlg = new JDialog(this, "Playing", true);
        dlg.add(new JLabel("Now playing: " + ((Media) p).getTitle(),
                SwingConstants.CENTER), BorderLayout.CENTER);
        dlg.setSize(300, 120);
        dlg.setLocationRelativeTo(this);
        dlg.setVisible(true);
        p.play();
    }

    public static void main(String[] args) {
    	Store aStore = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Harry Potter and the Philosopher's Stone (2001)",
                "Animation", "Roger Allers", 87, 3.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Harry Potter and the Chamber of Secrets (2002)",
                "Science Fiction", "Geogre Lucas", 87, 3.5f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban (2004)",
                "Animation", 5.0f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter and the Goblet of Fire (2005)",
                "Animaton", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Fetch the Bolt Cutters",
                "Science Fiction", "Geogre Lucas", 87, 24.95f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Future Nostalgia",
                "Animation", 18.99f);
        Book book7 = new Book("The Hunger Games",
                "Animation", 19.95f);
        Book book8 = new Book("Catching Fire",
                "Science Fiction", 24.95f);
        Book book9 = new Book("Mockingjay",
                "Animation", 18.99f);
        aStore.addMedia(dvd1);
        aStore.addMedia(dvd2);
        aStore.addMedia(dvd3);
        aStore.addMedia(dvd4);
        aStore.addMedia(dvd5);
        aStore.addMedia(dvd6);
        aStore.addMedia(book7);
        aStore.addMedia(book8);
        aStore.addMedia(book9);
        new StoreManagerScreen(aStore);
    }
}