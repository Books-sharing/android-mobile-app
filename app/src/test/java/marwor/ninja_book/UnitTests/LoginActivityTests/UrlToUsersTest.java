package marwor.ninja_book.UnitTests.LoginActivityTests;

import android.content.Context;
import android.content.res.Resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.net.MalformedURLException;
import java.net.URL;

import marwor.ninja_book.Login.UrlToAuthorization;
import marwor.ninja_book.Login.UrlToUsers;
import marwor.ninja_book.R;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by Marcin_stacjonarny on 2017-11-07.
 */
@RunWith(MockitoJUnitRunner.class)
public class UrlToUsersTest {
    @Mock
    Context testContext;
    @Mock
    Resources resources;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testUrlToUsers(){
        URL url=null;
        try{
            url=new URL("http://example.pl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        when(testContext.getResources()).thenReturn(resources);
        when(resources.getString(R.string.url_to_users)).thenReturn("http://example.pl");
        UrlToUsers urlToUsers=new UrlToUsers(testContext);
        assertThat("Test url to auth",urlToUsers.getUrl().toString(),is("http://example.pl"));

    }
}
