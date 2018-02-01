package kr.or.dgit.coffee_exam.dto;

public class ProductSales {
	private Product product;
	private int unitCost;
	private int quantity;
	private int perMargin;
	
	public ProductSales() {
	}

	public ProductSales(Product product, int unitCost, int quantity, int perMargin) {
		this.product = product;
		this.unitCost = unitCost;
		this.quantity = quantity;
		this.perMargin = perMargin;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPerMargin() {
		return perMargin;
	}

	public void setPerMargin(int perMargin) {
		this.perMargin = perMargin;
	}

	@Override
	public String toString() {
		return String.format("ProductSales [product=%s, unitCost=%s, quantity=%s, perMargin=%s]", product, unitCost,
				quantity, perMargin);
	}

}
