package prj1;

public class Cart {  
    public static final int MAX_NUMBERS_ORDERED = 20;  
    public DigitalVideoDisc itemsOrdered[] =  
        new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int qtyOrdered = 0;
    
    //method_addDigitalVideoDisc
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
    	if(qtyOrdered < MAX_NUMBERS_ORDERED) {
    		itemsOrdered[qtyOrdered] = disc;
    		qtyOrdered++;
    		System.out.println("The disc has been added");
    	}else System.out.println("The cart is almost full");
    }
        
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
    	for(DigitalVideoDisc dvd : dvdList) {
    		addDigitalVideoDisc(dvd);
    	}
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    	addDigitalVideoDisc(dvd1);
    	addDigitalVideoDisc(dvd2);
    }
    
    //method_removeDigitalVideoDisc
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    	for(int i = 0; i < qtyOrdered; i++) {
    		if(itemsOrdered[i] == disc) {
    			for(int j  = i; j < qtyOrdered - 1; j++) {
    				itemsOrdered[j] = itemsOrdered[j+1];
    			}
    			qtyOrdered = qtyOrdered - 1;
    			System.out.println("The cart is successfully deleted");
    			break;
    		}
    	}
    }
    
    //method_totalCost
    public float totalCost() {
    	float sum = 0;
    	for(int i = 0; i < qtyOrdered; i++) {
    		sum += itemsOrdered[i].getCost();
    	}
    	return sum;
    }
    
}