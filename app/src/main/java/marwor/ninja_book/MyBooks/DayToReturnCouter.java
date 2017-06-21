package marwor.ninja_book.MyBooks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Marcin_stacjonarny on 2017-06-21.
 */

public class DayToReturnCouter {
    static public int DayToReturn(String date){
        int days;
        Date borrowDate=null;
        SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            borrowDate= dataFormat.parse(date);
        }catch (ParseException e) {
            e.printStackTrace();
        }

    return 0;
    }
}
