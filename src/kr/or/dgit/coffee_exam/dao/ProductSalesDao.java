package kr.or.dgit.coffee_exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.DB_Connection.jdbc.DBConn;
import kr.or.dgit.coffee_exam.dao.exception.DAOException;
import kr.or.dgit.coffee_exam.dto.Product;
import kr.or.dgit.coffee_exam.dto.ProductSales;

public class ProductSalesDao implements DAOInterface<ProductSales> {
	private static final ProductSalesDao instance = new ProductSalesDao();
	
	public static ProductSalesDao getInstance() {
		return instance;
	}
	
	private ProductSalesDao() {}

	@Override
	public void insertItem(ProductSales item) throws DAOException {
		String sql = "insert into sales values (?, ?, ?, ?)";
		Connection conn = DBConn.getInstance().getConnection();
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, item.getProduct().getCode());
			pstmt.setInt(2, item.getUnitCost());
			pstmt.setInt(3, item.getQuantity());
			pstmt.setInt(4, item.getPerMargin());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void updateItem(ProductSales item) throws DAOException {
		String sql = "update sales set unit_cost = ?, quantity = ?, per_margin = ? where code = ?";
		Connection conn = DBConn.getInstance().getConnection();
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, item.getUnitCost());
			pstmt.setInt(2, item.getQuantity());
			pstmt.setInt(3, item.getPerMargin());
			pstmt.setString(4, item.getProduct().getCode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deleteItem(ProductSales item) throws DAOException {
		String sql = "delete from sales where code = ?";
		Connection conn = DBConn.getInstance().getConnection();
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, item.getProduct().getCode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<ProductSales> selectAllItem() throws DAOException {
		String sql = "select code, unit_cost, quantity, per_margin from sales";
		Connection conn = DBConn.getInstance().getConnection();
		
		List<ProductSales> list = new ArrayList<>();
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(getProductSales(rs));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return list;
	}

	@Override
	public ProductSales selectItemByCode(String code) throws DAOException {
		String sql = "select code, unit_cost, quantity, per_margin from sales where code = ?";
		Connection conn = DBConn.getInstance().getConnection();
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, code);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					return getProductSales(rs);
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return null;
	}
	
	public List<ProductSales> selectAllItemByProc(String proc) throws DAOException {
		String sql = String.format("{call %s}", proc);
		Connection conn = DBConn.getInstance().getConnection();
		
		List<ProductSales> list = new ArrayList<>();
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(getFullProductSales(rs));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return list;
	}

	private ProductSales getFullProductSales(ResultSet rs) throws SQLException {
		Product product = new Product(rs.getString("code"), rs.getString("prdname"));
		int unitCost = rs.getInt("unit_cost");
		int quantity = rs.getInt("quantity");
		int perMargin = rs.getInt("per_margin");
		int rank = rs.getInt("rank");
		int sellprice = rs.getInt("sellprice");
		int marginPrice = rs.getInt("marprice");
		int suprice = rs.getInt("suprice");
		int tax = rs.getInt("tax");
		
		return new ProductSales(product, unitCost, quantity, perMargin, rank, suprice, tax, sellprice, marginPrice);
	}
	
	private ProductSales getProductSales(ResultSet rs) throws SQLException {
		Product product = new Product(rs.getString("code"));
		int unitCost = rs.getInt("unit_cost");
		int quantity = rs.getInt("quantity");
		int perMargin = rs.getInt("per_margin");
		
		return new ProductSales(product, unitCost, quantity, perMargin);
	}

}
