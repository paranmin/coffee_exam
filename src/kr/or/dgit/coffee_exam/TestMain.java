package kr.or.dgit.coffee_exam;

import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;

import kr.or.dgit.coffee_exam.dto.Product;
import kr.or.dgit.coffee_exam.service.ProductService;
import kr.or.dgit.erp_application.jdbc.LoadProperties;

public class TestMain {
	public static void main(String[] args) {
		
		Product product = new Product("A001", "아이스크림");
		ProductService service = new ProductService();
		List<Product> list = service.selectProductAllItem();
		for (Product p : list) {
			System.out.println(p);
		}
	}
}
