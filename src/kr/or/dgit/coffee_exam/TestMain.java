package kr.or.dgit.coffee_exam;

import java.util.List;

import kr.or.dgit.coffee_exam.dto.Product;
import kr.or.dgit.coffee_exam.service.ProductService;

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
