package marwor.ninja_book.ShowQueue;

/**
 * Created by HP on 2017-06-10.
 */

public class QueueBookClass {



    private String orderDate;
    private String bookTitle;
    private String bookAuthor;
    private String bookISBN;
    private int placeInQueue;



    public QueueBookClass(String title, String author, String isbn, String orderDate, int place){
        this.orderDate=orderDate;
        this.bookTitle=title;
        this.bookAuthor=author;
        this.bookISBN=isbn;
        this.placeInQueue=place;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public int getPlaceInQueue() { return placeInQueue;}
    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookISBN() {
        return bookISBN;
    }

}
