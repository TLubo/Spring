package pl.spring.demo.searchCriteria;

public class BuildBookSearchCriteria {
    
    private BookSearchCriteria build;
    
    public static BuildBookSearchCriteria aBookSearchCriteria() {
    	BuildBookSearchCriteria builder = new BuildBookSearchCriteria();
        builder.build = new BookSearchCriteria();
        return builder;
    }
    
    public BuildBookSearchCriteria withTitle(String title) {
    	build.title = title;
        return this;
    }
    
    public BuildBookSearchCriteria withAuthor(String author) {
    	build.author = author;
        return this;
    }
    
    public BuildBookSearchCriteria withLibraryName(String libraryName) {
    	build.libraryName = libraryName;
        return this;
    }
    
    public BookSearchCriteria build() {
        BookSearchCriteria builded = build;
        build = new BookSearchCriteria();
        return builded;
    }
    
}