package marwor.ninja_book.MyBooks;

import static marwor.ninja_book.MyBooks.DayToReturnCouter.DayToReturn;

/**
 * Created by Marcin_stacjonarny on 2017-06-20.
 */

public class MyBooksBookClass {
    private String borrowDate;
    private String returnDate;
    private String bookTitle;
    private String bookAuthor;
    private String bookISBN;





    public MyBooksBookClass(String title, String author, String isbn, String orderDate, String returnDate){
        this.borrowDate=orderDate;
        this.returnDate=returnDate;
        this.bookTitle=title;
        this.bookAuthor=author;
        this.bookISBN=isbn;



    }
    public String getBorrowDate() {
        return borrowDate;
    }
    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }
    public String getReturnDate() {return returnDate;}
    public String getBookISBN() {
        return bookISBN;
    }

}
