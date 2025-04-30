package hust.soict.hedspi.aims.screen.manager;



import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, StoreManagerScreen caller) {
        super(store, caller, "Add Book");
        setVisible(true);
    }

    @Override
    protected JPanel createFormPanel() {
        JPanel p = new JPanel(new GridLayout(5, 2, 5, 5));

        JTextField tfTitle = new JTextField();
        JTextField tfCat   = new JTextField();
        JTextField tfCost  = new JTextField();
        JTextField tfAuths = new JTextField();   // comma-separated

        p.add(new JLabel("Title:"));           p.add(tfTitle);
        p.add(new JLabel("Category:"));        p.add(tfCat);
        p.add(new JLabel("Cost ($):"));        p.add(tfCost);
        p.add(new JLabel("Authors (,):"));     p.add(tfAuths);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(e -> {
            try {
                Book book = new Book(
                        tfTitle.getText(),
                        tfCat.getText(),
                        Float.parseFloat(tfCost.getText())
                );
                Arrays.stream(tfAuths.getText().split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .forEach(book::addAuthor);

                store.addMedia(book);
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