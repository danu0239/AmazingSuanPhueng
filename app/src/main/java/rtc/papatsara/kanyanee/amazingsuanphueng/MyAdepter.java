package rtc.papatsara.kanyanee.amazingsuanphueng;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by ACER on 21/11/2559.
 */

public class MyAdepter extends BaseAdapter{

    // Explicit
    private Context context;
    private String[] titleString, imageStrings, detailString;
    private TextView titleTextView, detailTaxtView;
    private ImageView imageView;

    public MyAdepter(Context context,
                     String[] titleString,
                     String[] imageStrings,
                     String[] detailString) {
        this.context = context;
        this.titleString = titleString;
        this.imageStrings = imageStrings;
        this.detailString = detailString;
    }

    @Override
    public int getCount() {
        return titleString.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_layout, parent, false);

        // Bind Widget
        titleTextView = (TextView) view1.findViewById(R.id.textView);
        detailTaxtView = (TextView) view1.findViewById(R.id.textView3);
        imageView = (ImageView) view1.findViewById(R.id.imageView5);

        //Show View
        titleTextView.setText(titleString[position]);
        detailTaxtView.setText(detailString[position]);
        Picasso.with(context).load(imageStrings[position]).into(imageView);


        return view1;
    }
}   // Main Class
