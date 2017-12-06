package marwor.ninja_book.MyBooks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import marwor.ninja_book.R;




/**
 * Created by Marcin_stacjonarny on 2017-06-20.
 */

public class MyBooksListAdapter extends ArrayAdapter<MyBooksBookClass> {
    private Context context;

    private static LayoutInflater inflater=null;
    private ArrayList<MyBooksBookClass> data;
    private static class Holder{
        TextView title;
        TextView place;
    }


    public MyBooksListAdapter(ArrayList<MyBooksBookClass> data, Context context) {
        super(context, R.layout.my_book_list_element, data);
        this.data=data;
        this.context=context;

        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View rowView;

        MyBooksListAdapter.Holder viewHolder= new MyBooksListAdapter.Holder();
        rowView = inflater.inflate(R.layout.my_book_list_element, null);
        viewHolder.title=(TextView) rowView.findViewById(R.id.bookTitleTextView);
        viewHolder.place=(TextView) rowView.findViewById(R.id.inscription);
        viewHolder.title.setText(data.get(position).getBookTitle());
        viewHolder.place.setText(context.getResources().getString(R.string.days_to_return_book)+DayToReturnCouter.DayToReturn(data.get(position).getReturnDate()));


        return rowView;
    }


}
