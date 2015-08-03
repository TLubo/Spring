package pl.spring.demo.service.impl;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.service.BookService;
import pl.spring.demo.common.Mapper;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.BookTo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookServiceImpl implements BookService {

	@Autowired
    private BookDao bookDao;

	@Autowired
	private Mapper mapper;

    @Override
    public List<BookTo> findAllBooks() {
    	List<BookEntity> bookEntities = bookDao.findAll();
    	List<BookTo> books = new ArrayList<>();
    	for(BookEntity bookEntity : bookEntities) {
    		books.add(mapper.mapToBookTo(bookEntity));
    	}
        return books;
    }

    @Override
    public List<BookTo> findBooksByTitle(String title) {
    	List<BookEntity> bookEntities = bookDao.findBookByTitle(title);
    	List<BookTo> books = new ArrayList<>();
    	for(BookEntity bookEntity : bookEntities) {
    		books.add(mapper.mapToBookTo(bookEntity));
    	}
    	return books;
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
    	List<BookEntity> bookEntities = bookDao.findBooksByAuthor(author);
    	List<BookTo> books = new ArrayList<>();
    	for(BookEntity bookEntity : bookEntities) {
    		books.add(mapper.mapToBookTo(bookEntity));
    	}
    	return books;
    }

    @Override
    public BookTo saveBook(BookTo book) {
        BookEntity bookEntity = bookDao.save(mapper.mapToBookEntity(book));
        return mapper.mapToBookTo(bookEntity);
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
