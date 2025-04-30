package hust.soict.hedspi.aims.screen.manager;



import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store, StoreManagerScreen caller) {
        super(store, caller, "Add DVD");
        setVisible(true);
    }

    @Override
    protected JPanel createFormPanel() {
        JPanel p = new JPanel(new GridLayout(6, 2, 5, 5));

        JTextField tfTitle = new JTextField();
        JTextField tfCat   = new JTextField();
        JTextField tfDir   = new JTextField();
        JTextField tfLen   = new JTextField();
        JTextField tfCost  = new JTextField();

        p.add(new JLabel("Title:"));           p.add(tfTitle);
        p.add(new JLabel("Category:"));        p.add(tfCat);
        p.add(new JLabel("Director:"));        p.add(tfDir);
        p.add(new JLabel("Length (min):"));    p.add(tfLen);
        p.add(new JLabel("Cost ($):"));        p.add(tfCost);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            try {
                DigitalVideoDisc disc = new DigitalVideoDisc(
                        tfTitle.getText(),
                        tfCat.getText(),
                        tfDir.getText(),
                        Integer.parseInt(tfLen.getText()),
                        Float.parseFloat(tfCost.getText())
                );
                store.addMedia(disc);
                caller.refreshCenter();
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid length or cost!");
            }
        });

        p.add(new JLabel());
        p.add(btnAdd);
        return p;
    }
}