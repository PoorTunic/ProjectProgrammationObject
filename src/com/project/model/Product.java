package com.project.model;

public class Product {

	private char noRef;
	private String mark;
	private String model;
	private double price;
	private int stock;

	public Product() {
		
	}

	public char getNoRef() {
		return noRef;
	}

	public void setNoRef(char noRef) {
		this.noRef = noRef;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}