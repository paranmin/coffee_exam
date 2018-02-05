package kr.or.dgit.coffee_exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.coffee_exam.dao.exception.DAOException;
import kr.or.dgit.coffee_exam.dto.Product;
import kr.or.dgit.db_connection.jdbc.DBConn;

public class ProductDao implements DAOInterface<Product> {
	private static final ProductDao instance = new ProductDao();
	
	public static ProductDao getInstance() {
		return instance;
	}
	
	private ProductDao() {}

	@Override
	public void insertItem(Product item) throws DAOException {
		String sql = "insert into product values (?, ?)";
		Connection conn = DBConn.getInstance().getConnection();
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, item.getCode());
			pstmt.setString(2, item.getPrdName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void updateItem(Product item) throws DAOException {
		String sql = "update product set prdname = ? where code = ?";
		Connection conn = DBConn.getInstance().getConnection();
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, item.getPrdName());
			pstmt.setString(2, item.getCode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void deleteItem(Product item) throws DAOException {
		String sql = "delete from product where code = ?";
		Connection conn = DBConn.getInstance().getConnection();
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, item.getCode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<Product> selectAllItem() throws DAOException {
		String sql = "select code, prdname from product";
		Connection conn = DBConn.getInstance().getConnection();
		
		List<Product> list = new ArrayList<>();
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(getProduct(rs));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return list;
	}

	@Override
	public Product selectItemByCode(String code) throws DAOException {
		String sql = "select code, prdname from product where code = ?";
		Connection conn = DBConn.getInstance().getConnection();
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, code);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					return getProduct(rs);
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return null;
	}

	private Product getProduct(ResultSet rs) throws SQLException {
		String code = rs.getString("code");
		String prdName = rs.getString("prdname");

		return new Product(code, prdName);
	}
}
