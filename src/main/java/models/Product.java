package models;

import java.text.NumberFormat;

public class Product {
	private String pID;
	private String pName;
	private float price;
	private String descripsion;
	private String catID;
	private String img;
	public Product(String pID, String pName, float price, String descripsion, String catID, String img) {
		super();
		this.pID = pID;
		this.pName = pName;
		this.price = price;
		this.descripsion = descripsion;
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
	public String getDescripsion() {
		return descripsion;
	}
	public void setDescripsion(String descripsion) {
		this.descripsion = descripsion;
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
		return "Product [pID=" + pID + ", pName=" + pName + ", price=" + price + ", descripsion=" + descripsion
				+ ", catID=" + catID + ", img=" + img + "]";
	}
	

}
