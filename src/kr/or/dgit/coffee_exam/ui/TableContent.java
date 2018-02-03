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
		Object[][] rows = new Object[list.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = list.get(i).toArray();
		}
		return rows;
	}
}
