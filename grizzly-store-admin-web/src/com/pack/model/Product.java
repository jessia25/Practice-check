package com.pack.model;

public class Product {
private int pid,price;
private String brand;
private String discount;
private float rating;
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getDiscount() {
	return discount;
}
public void setDiscount(String discount) {
	this.discount = discount;
}
public float getRating() {
	return rating;
}
public void setRating(float rating) {
	this.rating = rating;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
private String category;
private String pname;
private String description;
public Product() {}
public Product(int pid, String category, String pname, String description,int price) {
	super();
	this.pid = pid;
	this.category = category;
	this.pname = pname;
	this.description = description;
	this.price=price;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
}
