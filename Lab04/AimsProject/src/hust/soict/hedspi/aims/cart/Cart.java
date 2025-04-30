package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;
public class Cart {  
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int current_items = 0;
    private List<Media>itemsOrdered = new ArrayList<Media>();
    
    //method_addMedia
    public void addMedia(Media media) {
    	if(current_items < 20) {
    		if(itemsOrdered.contains(media)) {
    			System.out.println("Already exist");
    		}else {
    			System.out.println(media +" is added successfully");
    			itemsOrdered.add(media);
    			current_items++;
    		}
    	}
    }
    
    //method_removeMedia
    public void removeMedia(Media media) {
    	if(current_items == 0) {
    		return;
    	}else {
    		if(!itemsOrdered.contains(media)) {
    			System.out.println("Not found");
    		}else {
    			System.out.println(media + " is removed successfully");
    			itemsOrdered.remove(media);
    			current_items--;
    		}
    	}
    }
    
    //method_totalCost
    public float totalCost() {
    	float sum = 0;
    	for(Media media: itemsOrdered) {
    		sum += media.getCost();
    	}
    	return sum;
    }
    public List<Media> getItemsOrdered() {
        return Collections.unmodifiableList(itemsOrdered);
    }
    public Media searchById(int id) {
        for (Media m : itemsOrdered)
            if (m.getId() == id) return m;
        return null;
    }

    public List<Media> searchByTitle(String title) {
        List<Media> result = new ArrayList<>();
        for (Media m : itemsOrdered)
            if (m.getTitle() != null &&
                    m.getTitle().equalsIgnoreCase(title.trim())) {
                result.add(m);
            }
        return result;
    }
    //method_print
    public void print() {
    	System.out.println("**********Cart**********");
    	System.out.println("Ordered Items: ");
    	int i = 0;
    	for (Media media: itemsOrdered) {
    		System.out.println(i + 1 + ". DVD - " + media.getTitle() + " - " + media.getCategory() + " - "+ media.getCost() + "$");
    		i++;
    	}
    	System.out.print("Total cost: " + totalCost() + "$");
    }
    
}