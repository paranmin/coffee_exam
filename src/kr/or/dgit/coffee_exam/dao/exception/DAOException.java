package kr.or.dgit.coffee_exam.dao.exception;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class DAOException extends Exception {
	private SQLException e;

	public DAOException(SQLException e) {
		this.e = e;
	}
	
	public String getErrorCode() {
		return String.format("%s [ %s ]", e.getMessage(), e.getErrorCode());
	}
}
