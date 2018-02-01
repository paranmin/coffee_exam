package kr.or.dgit.coffee_exam.dao;

import java.util.List;

import kr.or.dgit.coffee_exam.dao.exception.DAOException;

public interface DAOInterface<T> {
	void insertItem(T item) throws DAOException;
	void updateItem(T item) throws DAOException;
	void deleteItem(T item) throws DAOException;
	List<T> selectAllItem() throws DAOException;
	T selectItemByNo(int no) throws DAOException;
}
