package marwor.ninja_book.MyBooks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Marcin_stacjonarny on 2017-06-21.
 */

public class DayToReturnCouter {
    static public int DayToReturn(String date){
        int days;
        long longDays;
        Date borrowDate=null;
        Calendar actualDate= Calendar.getInstance();
        SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            borrowDate= dataFormat.parse(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        longDays= borrowDate.getTime()-actualDate.getTimeInMillis();
        longDays=longDays/(long)(24 * 60 * 60 * 1000);
        days=(int) longDays;


    return days;
    }
}
