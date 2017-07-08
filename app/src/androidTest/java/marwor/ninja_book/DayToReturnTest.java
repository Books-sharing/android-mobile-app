package marwor.ninja_book;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import marwor.ninja_book.MyBooks.DayToReturnCouter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Marcin_stacjonarny on 2017-07-08.
 */
@RunWith(AndroidJUnit4.class)
public class DayToReturnTest {
    @Test
    public void TestDayToReturn(){
        assertThat(DayToReturnCouter.DayToReturn("2017-07-16"),is(7));
    }
}
