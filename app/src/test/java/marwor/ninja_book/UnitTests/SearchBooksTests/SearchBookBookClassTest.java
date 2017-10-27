package marwor.ninja_book.UnitTests.SearchBooksTests;

import org.junit.Test;

import marwor.ninja_book.SearchBook.SearchBookBookClass;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Marcin_stacjonarny on 2017-10-03.
 */

public class SearchBookBookClassTest {
    @Test
            public void BookClassTest(){
        SearchBookBookClass testClass=new SearchBookBookClass(4,"Author","Title","Isbn","Status");
        assertThat("Test id",testClass.getId(),is(4));
        assertThat("Test author",testClass.getAuthor(),is("Author"));
        assertThat("Test title",testClass.getTitle(),is("Title"));
        assertThat("Test isbn",testClass.getIsbn(),is("Isbn"));
        assertThat("Test status",testClass.getStatus(),is("Status"));
    }

}