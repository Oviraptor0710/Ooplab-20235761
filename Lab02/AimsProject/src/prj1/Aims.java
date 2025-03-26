package prj1;

public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();		
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        //check_add_method
        anOrder.addDigitalVideoDisc(new DigitalVideoDisc[] {dvd1, dvd2, dvd3});	
        for (int i = 0; i < anOrder.qtyOrdered; i++) {
        	System.out.print(i+1 + " ");
        	System.out.print(anOrder.itemsOrdered[i].getTitle() + " ");
        	System.out.print(anOrder.itemsOrdered[i].getCost() + " ");
        	System.out.print(anOrder.itemsOrdered[i].getId() + " ");
        	System.out.print("\n");
        }
        System.out.println("Total Cost is: " + anOrder.totalCost());
        //check_remove_method
        anOrder.removeDigitalVideoDisc(dvd1);
        for (int i = 0; i < anOrder.qtyOrdered; i++) {
        	System.out.print(i+1 + " ");
        	System.out.print(anOrder.itemsOrdered[i].getTitle() + " ");
        	System.out.print(anOrder.itemsOrdered[i].getCost() + " ");
        	System.out.print("\n");
        }        
	}
}
