package pl.spring.demo.to;

public class BookTo {
    private Long id;
    private String title;
    private String authors;
    private String library;
    private Long libraryId;

    public BookTo() {
    }

    public BookTo(Long id, String title, String authors, String library) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.library = library;
    }
    
    public BookTo(BookTo book) {
        this.id = book.id;
        this.title = book.title;
        this.authors = book.authors;
        this.library = book.library;
        this.libraryId = book.libraryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}

	public Long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}
    
}
