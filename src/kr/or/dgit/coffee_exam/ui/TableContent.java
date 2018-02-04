package kr.or.dgit.coffee_exam.ui;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.coffee_exam.dto.ProductSales;

@SuppressWarnings("serial")
public class TableContent extends AbtractTableContent<ProductSales> {

	public void setTableAlignWidth() {
		setTableRowHeight(30);
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		setTableCellWidth(100, 200, 200, 200, 200, 200, 200, 200, 150, 200);
	}

	public Object[] getColumnNames() {
		return new String[] { "순위", "제품코드", "제품명", "제품단가", "판매수량", "공급가액", "부가세액", "판매금액", "마진율", "마진액" };
	}

	public Object[][] getRows(List<ProductSales> list) {
		int supTotal = 0;
		int taxTotal = 0;
		int sellTotal = 0;
		int marginTotal = 0;
		Object[][] rows = new Object[list.size()+1][];

		for (int i = 0; i < rows.length-1; i++) {
			ProductSales sales = list.get(i);
			rows[i] = sales.toArray();
			
			supTotal = supTotal + sales.getSuprice();
			taxTotal = taxTotal + sales.getTax();
			sellTotal = sellTotal + sales.getSellprice();
			marginTotal = marginTotal + sales.getMarginPrice();
		}
		rows[rows.length-1] = new Object[] {"합계", "", "", "", "",
				String.format("%,d", supTotal),
				String.format("%,d", taxTotal),
				String.format("%,d", sellTotal),
				"",
				String.format("%,d", marginTotal)};
		
		return rows;
	}
}
