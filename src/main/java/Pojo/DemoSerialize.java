package Pojo;

import org.apache.juneau.annotation.Beanc;

public class DemoSerialize {
	
	private String name;
	private int price;
	private String color;
	private String[] products;
	
	@Beanc(properties = "name, price, color, products")
	public DemoSerialize(String name, int price, String color, String[] products ) {
		this.name = name;
		this.price = price;
		this.color = color;
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String[] getProducts() {
		return products;
	}

	public void setProducts(String[] products) {
		this.products = products;
	}
	
	
	

}
