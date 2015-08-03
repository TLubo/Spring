package pl.spring.demo.dao;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.exception.NotNullIdException;
import pl.spring.demo.to.AuthorTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/resources/pl/spring/demo/service/CommonServiceTest-context.xml")
public class BookDaoImplTest {

	@Autowired
	private BookDao bookDao;
	
	@Test
	public void whenSaveBookThenNotNullId() {
		// given
        BookEntity bookEntity = new BookEntity(null, "TitleOfBook", Arrays.asList(new AuthorTo(0L, "Jan", "Kowalski")));
        // when
        BookEntity book = bookDao.save(bookEntity);
        // then
        assertNotNull(book.getId());
	}
	
	@Test
	public void whenSaveTwoBooksThenDifferentIds() {
		// given
        BookEntity bookEntity = new BookEntity(null, "TitleOfBook", Arrays.asList(new AuthorTo(0L, "Jan", "Kowalski")));
        BookEntity bookEntitySnd = new BookEntity(null, "TitleOfSndBook", Arrays.asList(new AuthorTo(0L, "Jan", "Kowalski")));
        // when
        BookEntity book = bookDao.save(bookEntity);
        BookEntity bookSnd = bookDao.save(bookEntitySnd);
        // then
        assertNotNull(book.getId());
        assertNotNull(bookSnd.getId());
        assertNotEquals(book.getId(), bookSnd.getId());
	}

	@Test(expected = NotNullIdException.class)
	public void whenSaveBookWithIdThenThrowException() {
		BookEntity book = new BookEntity(1L, "TitleOfBook", Arrays.asList(new AuthorTo(0L, "Jan", "Kowalski")));
        bookDao.save(book);      
	}

}