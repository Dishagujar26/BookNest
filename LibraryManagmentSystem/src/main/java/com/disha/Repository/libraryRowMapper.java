package com.disha.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.disha.model.LibraryData;


public class libraryRowMapper implements RowMapper<LibraryData> {

	@Override
	public LibraryData mapRow(ResultSet rs,int rouwNum) throws SQLException{
		LibraryData s =  new LibraryData();
		s.setBookName(rs.getString("bookName"));
		s.setAuthorName(rs.getString("authorName"));
		s.setGenre(rs.getString("genre"));
		s.setIsbnNo(rs.getInt("isbnNo"));
		return s;
	}

}
