package marwor.ninja_book.ShowQueue;


import android.view.LayoutInflater;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.util.ArrayList;

import marwor.ninja_book.R;

public class QueueListAdapter extends ArrayAdapter<QueueBookClass> {
    private Context context;
    private String inscription;
    private static LayoutInflater inflater=null;
    private ArrayList<QueueBookClass> data;
    private static class Holder{
        TextView title;
        TextView place;
    }


    public QueueListAdapter(ArrayList<QueueBookClass> data, Context context) {
        super(context, R.layout.show_queue_list_element, data);
        this.data=data;
        inscription="@strings/place_in_queue";
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
        viewHolder.title.setText(data.get(position).getBookTitle());
        viewHolder.place.setText(inscription+data.get(position).getPlaceInQueue());

        return rowView;
    }


}