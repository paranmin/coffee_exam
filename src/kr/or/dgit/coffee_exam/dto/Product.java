package kr.or.dgit.coffee_exam.dto;

public class Product {
	private String code;
	private String prdName;
	
	public Product() {
	}

	public Product(String code) {
		this.code = code;
	}
	
	public Product(String code, String prdName) {
		this.code = code;
		this.prdName = prdName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	@Override
	public String toString() {
		return String.format("Product [code=%s, prdName=%s]", code, prdName);
	}
	
}
