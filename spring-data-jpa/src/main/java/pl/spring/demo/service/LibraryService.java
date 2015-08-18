package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.to.LibraryTo;

public interface LibraryService {

	
	List<LibraryTo> findByName(String name);
	LibraryTo findById(Long bookId);
	LibraryTo save(LibraryTo book);
	LibraryTo get(Long bookId);
	LibraryTo add(LibraryTo book);
	void deleteLibraryById(long id);
}