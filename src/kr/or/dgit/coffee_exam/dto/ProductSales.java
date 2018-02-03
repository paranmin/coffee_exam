package kr.or.dgit.coffee_exam.dto;

public class ProductSales {
	private Product product;
	private int unitCost;
	private int quantity;
	private int perMargin;
	private int rank;
	private int suprice;
	private int tax;
	private int sellprice;
	private int marginPrice;
	
	public ProductSales() {
	}

	public ProductSales(Product product, int unitCost, int quantity, int perMargin) {
		this.product = product;
		this.unitCost = unitCost;
		this.quantity = quantity;
		this.perMargin = perMargin;
	}

	public ProductSales(Product product, int unitCost, int quantity, int perMargin, int rank, int suprice, int tax,
			int sellprice, int marginPrice) {
		super();
		this.product = product;
		this.unitCost = unitCost;
		this.quantity = quantity;
		this.perMargin = perMargin;
		this.rank = rank;
		this.suprice = suprice;
		this.tax = tax;
		this.sellprice = sellprice;
		this.marginPrice = marginPrice;
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSuprice() {
		return suprice;
	}

	public void setSuprice(int suprice) {
		this.suprice = suprice;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getSellprice() {
		return sellprice;
	}

	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}

	public int getMarginPrice() {
		return marginPrice;
	}

	public void setMarginPrice(int marginPrice) {
		this.marginPrice = marginPrice;
	}

	@Override
	public String toString() {
		return String.format(
				"ProductSales [product=%s, unitCost=%s, quantity=%s, perMargin=%s, rank=%s, suprice=%s, tax=%s, sellprice=%s, marginPrice=%s]",
				product, unitCost, quantity, perMargin, rank, suprice, tax, sellprice, marginPrice);
	}

	public Object[] toArray() {
		return new Object[] { rank, product.getCode(), product.getPrdName(),
				String.format("%,d", unitCost), 
				String.format("%,d", quantity),
				String.format("%,d", suprice),
				String.format("%,d", tax),
				String.format("%,d", sellprice),
				perMargin,
				String.format("%,d", marginPrice)
		};
	}

}
