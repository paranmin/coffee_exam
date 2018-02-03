package kr.or.dgit.coffee_exam;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.coffee_exam.dto.ProductSales;
import kr.or.dgit.coffee_exam.ui.AbtractTableContent;
import kr.or.dgit.coffee_exam.ui.TableContent;

@SuppressWarnings("serial")
public class ProductSaleRankUI extends JFrame {
	private JPanel contentPane;
	private String title;
	private AbtractTableContent<ProductSales> pTable;

	public ProductSaleRankUI(String title) {
		this.title = title;
		initComponents();
	}

	private void initComponents() {
		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pTitle = new JPanel();
		pTitle.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(pTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel(this.title);
		pTitle.add(lblTitle);

		pTable = new TableContent();
		contentPane.add(pTable, BorderLayout.CENTER);
	}
	
	public void setListData(List<ProductSales> list) {
		pTable.loadTableDatas(list);
	}

}
