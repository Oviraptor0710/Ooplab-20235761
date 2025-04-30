package hust.soict.hedspi.aims.store;


import java.util.ArrayList;
import java.util.List;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Store {
	private List<Media>itemsInStore = new ArrayList<Media>();
	private int cur_number = 0;
	//add_method
	public void addMedia(Media media) {
		if(itemsInStore.contains(media)) {
			System.out.println("Already exist");
		}else {
			System.out.println(media +" is added successfully");
			itemsInStore.add(media);
			cur_number++;
		}
	}
	//remove_method
	public void removeMedia(Media media) {
		if(cur_number == 0) {
			return;
		}else {
			if(!itemsInStore.contains(media)) {
				System.out.println("Not found");
			}else {
				System.out.println("Media " + media + " is removed successfully");
				itemsInStore.remove(media);
				cur_number--;
			}
		}
	}
	public Media findByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }
	public List<Media> getItemsInStore() {
        return itemsInStore;
    }
	public void removeById(int id) {
        for (Media m : itemsInStore) {
            if (m.getId() == id) {
                removeMedia(m);
                return;
            }
        }
        System.out.println("No item with ID " + id + " in store.");
    }

	 public void print() {
	    	System.out.println("**********Store**********");
	    	System.out.println("Items In Store: ");
	    	int i = 0;
	    	for (Media media: itemsInStore) {
	    		System.out.println(i + 1 + ". DVD - " + media.getTitle() + " - " + media.getCategory() + " - " + media.getCost() + "$");
	    		i++;
	    	}
	    }
}
