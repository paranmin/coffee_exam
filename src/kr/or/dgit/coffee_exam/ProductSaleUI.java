package kr.or.dgit.coffee_exam;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.coffee_exam.dto.Product;
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

	public ProductSaleUI() {
		service = new ProductService();
		initComponents();
	}

	private void initComponents() {
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
		pPrdCode.getTextField().addFocusListener(focusAdapter);
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
		p2.add(pPrdCost);

		JPanel pEmpty1 = new JPanel();
		p2.add(pEmpty1);

		JPanel p3 = new JPanel();
		p3.setBorder(new EmptyBorder(5, 5, 5, 5));
		pContent.add(p3);
		p3.setLayout(new GridLayout(0, 2, 0, 0));

		pQuantity = new InputContent("판매수량");
		pQuantity.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		p3.add(pQuantity);

		JPanel pEmpty2 = new JPanel();
		p3.add(pEmpty2);

		JPanel p4 = new JPanel();
		p4.setBorder(new EmptyBorder(5, 5, 5, 5));
		pContent.add(p4);
		p4.setLayout(new GridLayout(0, 2, 0, 0));

		pMargin = new InputContent("마진율");
		pMargin.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
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

	private FocusAdapter focusAdapter = new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
			if (!e.isTemporary()) {
				JTextField c = (JTextField) e.getSource();
				if (c == pPrdCode.getTextField()) {
					checkTfPrdCode(c);
				}
			}
		}

		
	};
	private void checkTfPrdCode(JTextField c) {
		if (!c.getText().isEmpty()) {
			Product searchPrd = service.selectProductByCode(c.getText().trim());
			pPrdName.getTextField().setText(searchPrd.getPrdName());
		} else {
			JOptionPane.showMessageDialog(null, "제품코드가 비었습니다.");
			c.requestFocus();
		}
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

	protected void actionPerformedBtnInput(ActionEvent e) {
	}

	protected void actionPerformedBtnOuput1(ActionEvent e) {
	}

	protected void actionPerformedBtnOutput2(ActionEvent e) {
	}
}
