package marwor.ninja_book.SearchBook;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import marwor.ninja_book.R;

/**
 * Created by Marcin_stacjonarny on 2017-11-03.
 */

public class SearchResultListAdapter extends ArrayAdapter<SearchBookBookClass> {

    private static LayoutInflater inflater=null;
    private ArrayList<SearchBookBookClass> list;
    private Context context;
    private static class Holder{
        TextView title;
        TextView author;
        TextView status;
    }


    public SearchResultListAdapter(Context context, ArrayList<SearchBookBookClass> list) {
        super(context, R.layout.search_book_list_element, list);
        this.list=list;
        this.context=context;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView;
        SearchResultListAdapter.Holder viewHolder = new SearchResultListAdapter.Holder();
        rowView=inflater.inflate(R.layout.search_book_list_element,null);
        viewHolder.title=(TextView) rowView.findViewById(R.id.searchBookTitle);
        viewHolder.author=(TextView) rowView.findViewById(R.id.searchBookAuthor);
        viewHolder.status=(TextView) rowView.findViewById(R.id.searchBookStatus);
        viewHolder.author.setText(context.getString(R.string.search_result_author)+list.get(position).getAuthor());
        viewHolder.title.setText(context.getString(R.string.search_result_title)+list.get(position).getTitle());
        viewHolder.status.setText(context.getString(R.string.search_result_status)+list.get(position).getStatus());

        rowView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SearchBookResultDetails.class);
                intent.putExtra("SelectedBook",list.get(position));
               context.startActivity(intent);


            }
        }));
    return rowView;
    }

}
