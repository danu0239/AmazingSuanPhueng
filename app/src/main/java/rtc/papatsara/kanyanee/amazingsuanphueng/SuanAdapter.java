package rtc.papatsara.kanyanee.amazingsuanphueng;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by ACER on 16/10/2559.
 */

public class SuanAdapter extends BaseAdapter{

    // Explicit ทำการประกาศตัวแปร
    private Context context;    // ท่อที่ใช้ส่งข้อมูล
    private String[] titleStrings, detailStrings, imageStrings;
    private int[] ints;
    private TextView titleTextView, detailTextView;
    private ImageView imageView;

    public SuanAdapter (Context context, String[] titleStrings,String[] imageStrings, String[] detailStrings, int[] ints) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
        this.imageStrings = imageStrings;
        this.ints = ints;
    }


    @Override
    public int getCount() {
        return titleStrings.length;
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
        View view = layoutInflater.inflate(R.layout.activity_detail_list_view, parent, false);

        //Bind Widged
        titleTextView = (TextView) view.findViewById(R.id.textView);
        detailTextView = (TextView) view.findViewById(R.id.textView3);
        imageView = (ImageView) view.findViewById(R.id.imageView2);

        //Show View
        titleTextView.setText(titleStrings[position]);
        detailTextView.setText(detailStrings[position]);
        Picasso.with(context)
                .load(imageStrings[position])
                .resize(1400,700)
                .into(imageView);

        // Show View
        titleTextView.setText(titleStrings[position]);

        // การตัดคำ โดยจะแสดงแค่ 30 ตัวอักษรเท่านั้น แต่ถ้าน้อยกว่า 30 ตัวอักษรให้แสดงทั้งหมด
        if (detailStrings[position].length() <= 20) {
            // รายละเอียด น้อยกว่า 30 ตัวอักษร
            detailTextView.setText(detailStrings[position]);
        } else {
            // มากกว่า 30 ตัวอักษร
            detailTextView.setText(detailStrings[position].substring(0, 20) + "...");
        }

        //Change image การเปลี่ยนรูปตามต้องการ
        imageView.setImageResource(ints[position]);


        return view;
    }
}   // Main Class