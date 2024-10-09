package com.disha.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.disha.model.LibraryData;

@Repository
public class LibraryRepository {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public LibraryRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int save(LibraryData l) {
		String sql = "INSERT INTO library values(?,?,?,?)";
		return jdbcTemplate.update(sql, l.getBookName(),l.getGenre(),l.getAuthorName(),l.getIsbnNo() );
		
	}
	public int update(LibraryData l, String currentBook) {
		String sql = "UPDATE library SET bookName = ?, genre = ? , authorName = ?, isbnNo = ? WHERE bookName = ?;";
		return jdbcTemplate.update(sql,l.getBookName(),l.getGenre(),l.getAuthorName(),l.getIsbnNo(),currentBook);
		
	}
	
	public int delete(String bookName) {
		String sql = "DELETE from library where bookName=? ";
		return jdbcTemplate.update(sql,bookName);
		
	}
	
	public LibraryData findbyName(String boookName){
		LibraryData l = null;
		String sql  = "Select * from library where bookName = ?";
		try {
			l=jdbcTemplate.queryForObject(sql, new libraryRowMapper(), boookName);
		}
		catch (DataAccessException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		finally {
			return l;
		}
		
	}
	
	public List<LibraryData> findAll(){
		String sql = "Select * from library";
		return jdbcTemplate.query(sql, new libraryRowMapper());
	}
	
	

}
