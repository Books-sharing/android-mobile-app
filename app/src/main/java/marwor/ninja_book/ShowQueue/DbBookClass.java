package marwor.ninja_book.ShowQueue;

/**
 * Created by HP on 2017-06-10.
 */

public class DbBookClass {



    private String orderDate;
    private String bookTitle;
    private String bookAuthor;
    private String bookISBN;
    public DbBookClass(String title,String author,String isbn,String orderDate){
        this.orderDate=orderDate;
        this.bookTitle=title;
        this.bookAuthor=author;
        this.bookISBN=isbn;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookISBN() {
        return bookISBN;
    }

}
