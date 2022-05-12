package Pojo;

import org.apache.juneau.annotation.Beanc;

public class ShippingOptions {
	
	
	private int Type;
	private double Price;
	private String Method;
	private int ShippingId;
	
	
	
	public ShippingOptions(int type, double price, String method, int shippingId) {
		this.Type = type;
		this.Price = price;
		this.Method = method;
		this.ShippingId = shippingId;
	}


	public int getType() {
		return Type;
	}


	public void setType(int type) {
		this.Type = type;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(double price) {
		this.Price = price;
	}


	public String getMethod() {
		return Method;
	}


	public void setMethod(String method) {
		this.Method = method;
	}


	public int getShippingId() {
		return ShippingId;
	}


	public void setShippingId(int shippingId) {
		this.ShippingId = shippingId;
	}
	
	
	
	/*
	
	"Type": 1,
    "Price": 123.0,
    "Method": "ABC",
    "ShippingId": 123
*/
}
