package models;

import java.text.NumberFormat;

public class Product {
	private String pID;
	private String pName;
	private float price;
	private String description;
	private String catID;
	private String img;
	public Product(String pID, String pName, float price, String description, String catID, String img) {
		super();
		this.pID = pID;
		this.pName = pName;
		this.price = price;
		this.description = description;
		this.catID = catID;
		this.img = img;
	}
	public String getpID() {
		return pID;
	}
	public void setpID(String pID) {
		this.pID = pID;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCatID() {
		return catID;
	}
	public void setCatID(String catID) {
		this.catID = catID;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getPriceCurrencyFormat() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(price);
	}
	@Override
	public String toString() {
		return "Product [pID=" + pID + ", pName=" + pName + ", price=" + price + ", description=" + description
				+ ", catID=" + catID + ", img=" + img + "]";
	}
	

}
