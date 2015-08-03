package pl.spring.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.exception.NotNullIdException;
import pl.spring.demo.to.BookTo;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;
    
    @Test
    public void whenFindAllBooksThen6Books() {
        // when
        List<BookTo> books = bookService.findAllBooks();
        // then
        assertEquals(6, books.size());
    }
    
    @Test
    public void whenFindBookByTitleThenReturnOneBook() {
        List<BookTo> books = bookService.findBooksByTitle("Zemsta");
        assertEquals(1, books.size());
    }

    @Test
    public void whenFindBookByPrefixThenReturnOneBook() {
    	// when
    	List<BookTo> books = bookService.findBooksByTitle("Awantur");
    	// then
    	assertEquals(1, books.size());
    }
    
    @Test
    public void whenFindBookByPrefixWithDiffernetLettersThenReturnOneBook() {
    	// when
    	List<BookTo> books = bookService.findBooksByTitle("pRzygo");
    	// then
    	assertEquals(1, books.size());
    }

    @Test
    public void whenFindBookByPrefixNameThenReturnOneBook() {
    	// when
    	List<BookTo> books = bookService.findBooksByAuthor("Aleksa");
    	// then
    	assertEquals(1, books.size());
    }
    
    @Test
    public void whenFindBookByAuthorThenReturnOneBook() {
    	// when
    	List<BookTo> books = bookService.findBooksByAuthor("Jan Parandowski");
    	// then
    	assertEquals(1, books.size());
    }
    
    @Test
    public void whenFindBookByPrefixAuthorThenReturnOneBook() {
    	// when
    	List<BookTo> books = bookService.findBooksByAuthor("edmund niziur");
    	// then
    	assertEquals(1, books.size());
    }
    
    @Test
    public void whenFindBookByPrefixAuthorLastNameThenReturnOneBook() {
    	// when
    	List<BookTo> books = bookService.findBooksByAuthor("ożo");
    	// then
    	assertEquals(1, books.size());
    }
    
    @Test(expected = NotNullIdException.class)
    public void testShouldThrowBookNotNullIdException() {
    	final BookTo books = new BookTo(1L, "TitleOfBook", "Jan Kowalski");
        bookService.saveBook(books);
    }

    @Test
    public void whenSaveBookThenIdNotNull() {
    	// given
    	BookTo book = new BookTo(null, "TitleOfBook", "Jan Kowalski");
    	// when
    	BookTo bookSave = bookService.saveBook(book);
    	// then
    	assertNotNull(bookSave.getId());
    }
    
}