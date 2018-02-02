package kr.or.dgit.coffee_exam.ui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InputContent extends JPanel {
	private JTextField textField;
	private JLabel lbl;

	public InputContent(String title) {
		lbl = new JLabel(title);
		initComponents();
	}
	private void initComponents() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
	}
	
	public void setEnable(boolean enable) {
		textField.setEnabled(enable);
	}
	
	public JTextField getTextField() {
		return textField;
	}
}
