package models;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Item> items;

	public Cart() {
		super();
		items = new ArrayList<Item>();
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public int getCount() {
		return items.size();
	}
	
	public void addItem(Item item) {
		String pId = item.getProduct().getpID();
		int quantity = item.getQuantity();
		for(int i=0; i<items.size(); i++) {
			Item it = items.get(i);
			if(it.getProduct().getpID().equals(pId)) {
				it.setQuantity(quantity);
				return;
			}
		}
		items.add(item);
	}
	
	public void removeItem(Item item) {
		String pId = item.getProduct().getpID();
		for(int i = 0; i<items.size(); i++) {
			Item it = items.get(i);
			if(it.getProduct().getpID().equals(pId)) {
				items.remove(i);
				return;
			}
		}
	}
	

}
