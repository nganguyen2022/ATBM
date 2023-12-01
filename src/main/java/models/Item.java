package models;

import java.text.NumberFormat;

public class Item {
	private Product product;
	private int quantity;
	
	public Item() {
		
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getTotal() {
		double total = product.getPrice() * quantity;
		return total;
	}
	
	public String getTotalCurrencyFormat() {
		NumberFormat currency = NumberFormat.getCompactNumberInstance();
		return currency.format(this.getTotal());
	}

}
