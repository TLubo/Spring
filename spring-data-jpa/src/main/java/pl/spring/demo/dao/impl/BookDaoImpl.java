package pl.spring.demo.dao.impl;

import pl.spring.demo.annotation.NullableId;
import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.AuthorTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements BookDao {

	private final Set<BookEntity> ALL_BOOKS = new HashSet<>();

	@Autowired
	private Sequence sequence;

	public BookDaoImpl() {
		addTestBooks();
	}

	@Override
	public List<BookEntity> findAll() {
		 return new ArrayList<>(ALL_BOOKS);
	}

	@Override
	public List<BookEntity> findBookByTitle(String prefix) {
		List<BookEntity> books = new ArrayList<>();
		for (BookEntity bookEntity : ALL_BOOKS) {
			prefix = prefix.toLowerCase();
			String bookTitle = bookEntity.getTitle().toLowerCase();
			if (bookTitle.startsWith(prefix)) {
				books.add(bookEntity);
			}
		}
		return books;
	}

	@Override
	public List<BookEntity> findBooksByAuthor(String prefix) {
		List<BookEntity> books = new ArrayList<>();
		for(BookEntity bookEntity : ALL_BOOKS) {
			for(AuthorTo author : bookEntity.getAuthors()) {
				prefix = prefix.toLowerCase();
				String firstName = author.getFirstName().toLowerCase();
				String lastName = author.getLastName().toLowerCase();
				String concat = firstName+" "+lastName;
				if(firstName.startsWith(prefix) || lastName.startsWith(prefix) || concat.startsWith(prefix)) {
					books.add(bookEntity);
				}
			}
		}
		return books;
	}

	@Override
	@NullableId
	public BookEntity save(BookEntity book) {
	    ALL_BOOKS.add(book);
		return book;
	}

	public Sequence getSequence() {
		return sequence;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

	private void addTestBooks() {
		ALL_BOOKS.add(new BookEntity(1L, "Romeo i Julia", Arrays.asList(new AuthorTo(0L, "Wiliam", "Szekspir"))));

		ALL_BOOKS.add(new BookEntity(2L, "Opium w rosole", Arrays.asList(new AuthorTo(0L, "Hanna", "Ożogowska"))));

		ALL_BOOKS.add(new BookEntity(3L, "Przygody Odyseusza", Arrays.asList(new AuthorTo(0L, "Jan", "Parandowski"))));

		ALL_BOOKS.add(new BookEntity(4L, "Awantura w Niekłaju", Arrays.asList(new AuthorTo(0L, "Edmund", "Niziurski"))));

		ALL_BOOKS.add(new BookEntity(5L, "Pan Samochodzik i Fantomas", Arrays.asList(new AuthorTo(0L, "Zbigniew", "Nienacki"))));

		ALL_BOOKS.add(new BookEntity(6L, "Zemsta", Arrays.asList(new AuthorTo(0L, "Aleksander", "Fredro"))));
	}
}
