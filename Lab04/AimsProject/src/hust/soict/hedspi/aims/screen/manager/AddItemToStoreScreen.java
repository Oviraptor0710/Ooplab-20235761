package hust.soict.hedspi.aims.screen.manager;



import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {

    protected final Store store;
    protected final StoreManagerScreen caller;

    protected AddItemToStoreScreen(Store store,
                                   StoreManagerScreen caller,
                                   String windowTitle) {

        this.store  = store;
        this.caller = caller;

        setTitle(windowTitle);
        setSize(400, 350);
        setLocationRelativeTo(caller);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        if (caller.getJMenuBar() != null) {
            setJMenuBar(caller.getJMenuBar());
        }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(createFormPanel(), BorderLayout.CENTER);
    }

    protected abstract JPanel createFormPanel();
}