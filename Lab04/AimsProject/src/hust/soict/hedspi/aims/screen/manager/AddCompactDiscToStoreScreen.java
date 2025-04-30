package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store, StoreManagerScreen caller) {
        super(store, caller, "Add CD");
        setVisible(true);
    }

    @Override
    protected JPanel createFormPanel() {
        JPanel p = new JPanel(new GridLayout(6, 2, 5, 5));

        JTextField tfTitle  = new JTextField();
        JTextField tfCat    = new JTextField();
        JTextField tfArtist = new JTextField();
        JTextField tfCost   = new JTextField();

        p.add(new JLabel("Title:"));     p.add(tfTitle);
        p.add(new JLabel("Category:"));  p.add(tfCat);
        p.add(new JLabel("Artist:"));    p.add(tfArtist);
        p.add(new JLabel("Cost ($):"));  p.add(tfCost);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            try {
                CompactDisc cd = new CompactDisc(
                        tfTitle.getText(),
                        tfCat.getText(),
                        Float.parseFloat(tfCost.getText()),
                        tfArtist.getText(),
                        "Unknown Director"  // Add director parameter
                );;
                store.addMedia(cd);
                caller.refreshCenter();
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid cost!");
            }
        });

        p.add(new JLabel());
        p.add(btnAdd);
        return p;
    }
}