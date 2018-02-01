package kr.or.dgit.coffee_exam;

import java.awt.EventQueue;

public class ProductMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductSaleUI frame = new ProductSaleUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
