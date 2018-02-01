package kr.or.dgit.coffee_exam;

import java.awt.EventQueue;

public class CoffeeMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeSaleUI frame = new CoffeeSaleUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
