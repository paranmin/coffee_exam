package kr.or.dgit.coffee_exam;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.coffee_exam.dto.Product;
import kr.or.dgit.coffee_exam.dto.ProductSales;
import kr.or.dgit.coffee_exam.service.ProductService;
import kr.or.dgit.coffee_exam.ui.InputContent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ProductSaleUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	private InputContent pPrdCode;
	private InputContent pPrdName;
	private InputContent pPrdCost;
	private InputContent pQuantity;
	private InputContent pMargin;
	private JButton btnInput;
	private JButton btnOuput1;
	private JButton btnOutput2;
	private ProductService service;
	private ProductSaleRankUI rankSell;
	private ProductSaleRankUI rankMargin;

	public ProductSaleUI() {
		service = new ProductService();
		initComponents();
	}

	private void initComponents() {
		setTitle("커피전문점");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pContent = new JPanel();
		contentPane.add(pContent, BorderLayout.CENTER);
		pContent.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel p1 = new JPanel();
		p1.setBorder(new EmptyBorder(5, 5, 5, 5));
		pContent.add(p1);
		p1.setLayout(new GridLayout(0, 2, 0, 0));

		pPrdCode = new InputContent("제품코드");
		pPrdCode.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		pPrdCode.getTextField().addKeyListener(keyAdapter);
		p1.add(pPrdCode);

		pPrdName = new InputContent("제품명");
		pPrdName.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		pPrdName.setEnable(false);
		p1.add(pPrdName);

		JPanel p2 = new JPanel();
		p2.setBorder(new EmptyBorder(5, 5, 5, 5));
		pContent.add(p2);
		p2.setLayout(new GridLayout(0, 2, 0, 0));

		pPrdCost = new InputContent("제품단가");
		pPrdCost.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		pPrdCost.getTextField().addKeyListener(keyAdapter);
		p2.add(pPrdCost);

		JPanel pEmpty1 = new JPanel();
		p2.add(pEmpty1);

		JPanel p3 = new JPanel();
		p3.setBorder(new EmptyBorder(5, 5, 5, 5));
		pContent.add(p3);
		p3.setLayout(new GridLayout(0, 2, 0, 0));

		pQuantity = new InputContent("판매수량");
		pQuantity.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		pQuantity.getTextField().addKeyListener(keyAdapter);
		p3.add(pQuantity);

		JPanel pEmpty2 = new JPanel();
		p3.add(pEmpty2);

		JPanel p4 = new JPanel();
		p4.setBorder(new EmptyBorder(5, 5, 5, 5));
		pContent.add(p4);
		p4.setLayout(new GridLayout(0, 2, 0, 0));

		pMargin = new InputContent("마진율");
		pMargin.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		pMargin.getTextField().addKeyListener(keyAdapter);
		p4.add(pMargin);

		JPanel pEmpty3 = new JPanel();
		p4.add(pEmpty3);

		JPanel pBtn = new JPanel();
		pBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(pBtn, BorderLayout.SOUTH);
		pBtn.setLayout(new GridLayout(0, 3, 10, 10));

		btnInput = new JButton("입력");
		btnInput.addActionListener(this);
		pBtn.add(btnInput);

		btnOuput1 = new JButton("출력[판매순위]");
		btnOuput1.addActionListener(this);
		pBtn.add(btnOuput1);

		btnOutput2 = new JButton("출력[마진순위]");
		btnOutput2.addActionListener(this);
		pBtn.add(btnOutput2);
	}

	private KeyAdapter keyAdapter = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				JTextField c = (JTextField) e.getSource();
				if (c == pPrdCode.getTextField()) {
					checkTfPrdCode(c);
				} else if (c == pMargin.getTextField()) {
					checkTfNumber(c, 2);
				} else {
					checkTfNumber(c, 8);
				}
			}
		}
	};

	private void checkTfPrdCode(JTextField c) {
		try {
			String upCode = c.getText().trim().toUpperCase();
			Product searchPrd = service.selectProductByCode(upCode);

			pPrdName.getTextField().setText(searchPrd.getPrdName());
			pPrdCode.getTextField().setText(upCode);
			c.transferFocus();
		} catch (NullPointerException e) {
			alertErrorMsg(c, "제품코드가 올바르지 않습니다.");
		}
	}

	private void checkTfNumber(JTextField c, int length) {
		try {
			if (c.getText().trim().length() > length) {
				throw new NumberFormatException();
			}
			Integer.parseInt(c.getText().trim());
			c.transferFocus();
		} catch (Exception e) {
			alertErrorMsg(c, length + "자리 정수만 받습니다.");
		}
	}

	private void alertErrorMsg(JTextField c, String msg) {
		JOptionPane.showMessageDialog(null, msg);
		c.setText("");
		c.requestFocus();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOutput2) {
			actionPerformedBtnOutput2(e);
		}
		if (e.getSource() == btnOuput1) {
			actionPerformedBtnOuput1(e);
		}
		if (e.getSource() == btnInput) {
			actionPerformedBtnInput(e);
		}
	}

	private void clearTextField() {
		pPrdCode.getTextField().setText("");
		pPrdName.getTextField().setText("");
		pPrdCost.getTextField().setText("");
		pQuantity.getTextField().setText("");
		pMargin.getTextField().setText("");
	}

	private ProductSales getSalesData() {
		String code = pPrdCode.getTextField().getText().trim();
		String prdName = pPrdName.getTextField().getText().trim();
		Product product = new Product(code, prdName);

		int unitCost = Integer.parseInt(pPrdCost.getTextField().getText().trim());
		int quantity = Integer.parseInt(pQuantity.getTextField().getText().trim());
		int perMargin = Integer.parseInt(pMargin.getTextField().getText().trim());

		return new ProductSales(product, unitCost, quantity, perMargin);
	}

	protected void actionPerformedBtnInput(ActionEvent e) {
		service.insertProductSale(getSalesData());
		clearTextField();
		pPrdCode.getTextField().requestFocus();
		if (rankSell != null && rankSell.isVisible()) {
			rankSell.setListData(service.selectAllItemBySell());
		}
		if (rankMargin != null && rankMargin.isVisible()) {
			rankMargin.setListData(service.selectAllItemByMargin());
		}
	}

	protected void actionPerformedBtnOuput1(ActionEvent e) {
		if (rankSell == null) {
			rankSell = new ProductSaleRankUI("판 매 금 액 순 위");
		}
		rankSell.setListData(service.selectAllItemBySell());
		rankSell.setVisible(true);
	}

	protected void actionPerformedBtnOutput2(ActionEvent e) {
		if (rankMargin == null) {
			rankMargin = new ProductSaleRankUI("마 진 액 순 위");
		}
		rankMargin.setListData(service.selectAllItemByMargin());
		rankMargin.setVisible(true);
	}
}
