package rtc.papatsara.kanyanee.amazingsuanphueng;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail2Activity extends AppCompatActivity {

    // Explicit
    private TextView titleTextView, detailTextView;
    private ImageView imageView;
    private Button button;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        // Bind Widget
        titleTextView = (TextView) findViewById(R.id.textView4);
        detailTextView = (TextView) findViewById(R.id.textView5);
        imageView = (ImageView) findViewById(R.id.imageView2);
        button = (Button) findViewById(R.id.button2);

        // Show View
        titleTextView.setText(getIntent().getStringExtra("Title"));
        detailTextView.setText(getIntent().getStringExtra("Detail"));





        // Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }   // Main Method

} // Main Class
