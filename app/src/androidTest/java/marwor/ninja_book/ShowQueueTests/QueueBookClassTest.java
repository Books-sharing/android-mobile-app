package marwor.ninja_book.ShowQueueTests;

import org.junit.Test;

import marwor.ninja_book.ShowQueue.QueueBookClass;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Marcin_stacjonarny on 2017-09-14.
 */

public class QueueBookClassTest {
    private String exampleOrderDate="exampleDate";
    private String exampleBookTitle="exampleTitlte";
    private String exampleBookAuthor="exampleAuthor";
    private String exampleBookISBN="exampleISBN";
    private int examplePlaceInQueue=5;

    @Test
    public void queueBookClassTest(){
        QueueBookClass queueBookClass=new QueueBookClass(exampleBookTitle,exampleBookAuthor,exampleBookISBN,exampleOrderDate,examplePlaceInQueue);
        assertThat("Test Date",queueBookClass.getOrderDate(),is(exampleOrderDate));
        assertThat("Test Title",queueBookClass.getBookTitle(),is(exampleBookTitle));
        assertThat("Test Author",queueBookClass.getBookAuthor(),is(exampleBookAuthor));
        assertThat("Test ISBN",queueBookClass.getBookISBN(),is(exampleBookISBN));
        assertThat("Test Place in Queue",queueBookClass.getPlaceInQueue(),is(examplePlaceInQueue));

    }
}
