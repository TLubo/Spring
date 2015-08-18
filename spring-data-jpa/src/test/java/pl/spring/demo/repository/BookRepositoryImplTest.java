package pl.spring.demo.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.repository.MyCustomBookRepository;
import pl.spring.demo.searchCriteria.BookSearchCriteria;
import pl.spring.demo.searchCriteria.BookSearchCriteriaBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class BookRepositoryImplTest {
	
	@Autowired
	private MyCustomBookRepository bookRepositoryImpl;

	@Test
	public void testShouldFindAllBooksIfNoCriteriaAreGiven() {
		BookSearchCriteria bookSearchCriteria = BookSearchCriteriaBuilder.aBookSearchCriteria().build();
		List<BookEntity> books = bookRepositoryImpl.findBooksByBookSearchCriteria(bookSearchCriteria);
		
		assertNotNull(books);
		assertFalse(books.isEmpty());
		assertEquals(5, books.size());
	}

	@Test
	public void testShouldFindTwoBooksIfTitleisGiven() {
		BookSearchCriteria bookSearchCriteria = BookSearchCriteriaBuilder.aBookSearchCriteria().withTitle("p").build();
		List<BookEntity> books = bookRepositoryImpl.findBooksByBookSearchCriteria(bookSearchCriteria);
		
		assertNotNull(books);
		assertFalse(books.isEmpty());
		assertEquals(2, books.size());
	}

	@Test
	public void testShouldFindOneBookIfAuthorIsGiven() {
		BookSearchCriteria bookSearchCriteria = BookSearchCriteriaBuilder.aBookSearchCriteria().withAuthor("Anna").build();
		List<BookEntity> books = bookRepositoryImpl.findBooksByBookSearchCriteria(bookSearchCriteria);
		
		assertNotNull(books);
		assertFalse(books.isEmpty());
		assertEquals(1, books.size());
	}
	
	@Test
	public void testShouldFindTwoBooksIfAuthorIsGiven() {
		BookSearchCriteria bookSearchCriteria = BookSearchCriteriaBuilder.aBookSearchCriteria().withAuthor("jan").build();
		List<BookEntity> books = bookRepositoryImpl.findBooksByBookSearchCriteria(bookSearchCriteria);
		
		assertNotNull(books);
		assertFalse(books.isEmpty());
		assertEquals(2, books.size());
	}

	@Test
	public void testShouldFind2BooksIfLibraryIsGiven() {
		BookSearchCriteria bookSearchCriteria = BookSearchCriteriaBuilder.aBookSearchCriteria().withLibraryName("pierwsz").build();
		List<BookEntity> books = bookRepositoryImpl.findBooksByBookSearchCriteria(bookSearchCriteria);
		
		assertNotNull(books);
		assertFalse(books.isEmpty());
		assertEquals(2, books.size());
	}

	@Test
	public void testShouldFindOneBookIfTitleAndAuthorAreGiven() {
		BookSearchCriteria bookSearchCriteria = BookSearchCriteriaBuilder.aBookSearchCriteria().withTitle("dr").withAuthor("jan").build();
		List<BookEntity> books = bookRepositoryImpl.findBooksByBookSearchCriteria(bookSearchCriteria);
		
		assertNotNull(books);
		assertFalse(books.isEmpty());
		assertEquals(1, books.size());
	}

	@Test
	public void testShouldFindOneBookIfTitleAndLibraryAreGiven() {
		BookSearchCriteria bookSearchCriteria = BookSearchCriteriaBuilder.aBookSearchCriteria().withTitle("dru").withLibraryName("miej").build();
		List<BookEntity> books = bookRepositoryImpl.findBooksByBookSearchCriteria(bookSearchCriteria);
		
		assertNotNull(books);
		assertFalse(books.isEmpty());
		assertEquals(1, books.size());
	}

	@Test
	public void testShouldNotFindAnyBooksIfNotExistingTitleIsGiven() {
		BookSearchCriteria bookSearchCriteria = BookSearchCriteriaBuilder.aBookSearchCriteria().withTitle("Kolejna książka").build();
		List<BookEntity> books = bookRepositoryImpl.findBooksByBookSearchCriteria(bookSearchCriteria);
		
		assertTrue(books.isEmpty());
	}

	@Test
	public void testShouldFindOneBookForAllCriterias() {
		BookSearchCriteria bookSearchCriteria = BookSearchCriteriaBuilder.aBookSearchCriteria().withTitle("trze").withAuthor("adam").withLibraryName("miej").build();
		List<BookEntity> books = bookRepositoryImpl.findBooksByBookSearchCriteria(bookSearchCriteria);
		
		assertNotNull(books);
		assertFalse(books.isEmpty());
		assertEquals(1, books.size());
	}

}