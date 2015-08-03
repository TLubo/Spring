package pl.spring.demo.common;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookTo;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.springframework.stereotype.Component;
import pl.spring.demo.entity.BookEntity;

@Component
public class Mapper {
	
	public BookEntity mapToBookEntity(BookTo bookTo) {
		
		BookEntity bookEntity = new BookEntity();
		
		List<AuthorTo> authorsList = new ArrayList<>();
		String names = bookTo.getAuthors();
		String[] authors = names.split(",");
		
		for(String author : authors) {
			String[] name = author.split(" ");
			AuthorTo authorTo = new AuthorTo(0L, name[0], name[1]);
			authorsList.add(authorTo);
		}
		bookEntity.setAuthors(authorsList);
		bookEntity.setId(bookTo.getId());
		bookEntity.setTitle(bookTo.getTitle());
		
		return bookEntity;
	}
	
	public BookTo mapToBookTo(BookEntity bookEntity) {
		
		BookTo bookTo = new BookTo();
		
		ListIterator<AuthorTo> iterator = bookEntity.getAuthors().listIterator();
		String authors = "";
		
		while(iterator.hasNext()) {
			AuthorTo author = iterator.next();
			authors.concat(author.getFirstName() + " " + author.getLastName());
			if(iterator.hasNext()) {
				authors.concat(",");
			}
		}
		bookTo.setAuthors(authors);
		bookTo.setId(bookEntity.getId());
		bookTo.setTitle(bookEntity.getTitle());
		
		return bookTo;
	}
}
