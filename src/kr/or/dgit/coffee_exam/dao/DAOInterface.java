package kr.or.dgit.coffee_exam.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T> {
	void insertItem(T item) throws SQLException;
	void updateItem(T item) throws SQLException;
	void deleteItem(T item) throws SQLException;
	List<T> selectAllItem() throws SQLException;
	T selectItemByNo(int no) throws SQLException;
}
