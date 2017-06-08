package marwor.ninja_book.ShowQueue;


import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.util.ArrayList;

import marwor.ninja_book.R;

public class ListAdapter extends ArrayAdapter<ShowQueueData> {
    private Context context;
    private static LayoutInflater inflater=null;
    private ArrayList<ShowQueueData> data;
    private static class Holder{
        TextView title;
        TextView place;
    }


    public  ListAdapter(ArrayList<ShowQueueData> data, Context context) {
        super(context, R.layout.show_queue_list_element, data);
        this.data=data;
        context= context;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View rowView;
        Holder viewHolder= new Holder();
        rowView = inflater.inflate(R.layout.show_queue_list_element, null);
        viewHolder.title=(TextView) rowView.findViewById(R.id.bookTitleTextView);
        viewHolder.place=(TextView) rowView.findViewById(R.id.inscription);
        viewHolder.title.setText(data.get(position).setTitle());
        viewHolder.place.setText(data.get(position).setPlace());

        return rowView;
    }


}