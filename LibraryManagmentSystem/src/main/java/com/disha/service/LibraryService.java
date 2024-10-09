package com.disha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disha.Repository.LibraryRepository;
import com.disha.model.LibraryData;

@Service
public class LibraryService {
    private LibraryRepository libraryRepository;

    @Autowired
	public LibraryService(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}
    
    public int save( LibraryData l) {
    	return libraryRepository.save(l);
    }
    public int update( LibraryData l,String currentBook) {
    	return libraryRepository.update(l,currentBook);
    }
    
    public int delete( String bookName) {
    	return libraryRepository.delete(bookName);
    }
    public LibraryData findbyName(String bookName) {
    	return libraryRepository.findbyName(bookName);
    }
    public List<LibraryData> findbyALl() {
    	return libraryRepository.findAll();
    }
    
    
}
