package marwor.ninja_book.SearchBook;

/**
 * Created by Marcin_stacjonarny on 2017-10-03.
 */

public class SearchBookBookClass {
    private String author;
    private String title;
    private String isbn;
    private String status;
    private String description;

    public SearchBookBookClass(String author,String title,String isbn,String status,String description){
        this.author=author;
        this.isbn=isbn;
        this.status=status;
        this.title=title;
        this.description=description;
    }

    public String getDescription() { return description; }
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getStatus() {
        return status;
    }
}
