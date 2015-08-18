package pl.spring.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARY")
public class LibraryEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", unique = true, nullable = false, length = 50)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "library", cascade = CascadeType.ALL)
	private Set<BookEntity> books = new HashSet<BookEntity>(0);
	
	// for hibernate
	protected LibraryEntity() {
	}
	
	public LibraryEntity(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public LibraryEntity(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(Set<BookEntity> books) {
		this.books = books;
	}
	
}