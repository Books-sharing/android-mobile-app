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
import marwor.ninja_book.R;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class UrlToAuthorizationTest {

    @Mock
    Context testContext;
    @Mock
    Resources resources;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void urlToAuthTest(){
        URL url=null;
        try{
            url=new URL("http://example.pl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        when(testContext.getResources()).thenReturn(resources);
        when(resources.getString(R.string.url_to_auth)).thenReturn("http://example.pl");
        UrlToAuthorization urlToAuthorization=new UrlToAuthorization(testContext);
        assertThat("Test url to auth",urlToAuthorization.getUrl().toString(),is("http://example.pl"));


    }

}
