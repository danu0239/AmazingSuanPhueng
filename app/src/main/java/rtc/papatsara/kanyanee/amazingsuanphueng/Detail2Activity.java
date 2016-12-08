package rtc.papatsara.kanyanee.amazingsuanphueng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detail2Activity extends AppCompatActivity {

    // Explicit
    private TextView titleTextView, detailTextView;
    private ImageView imageView;
    private Button button;
    private String image1String, image2String, image3String, image4String;
    private int indexAnInt = 0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        // Bind Widget
        titleTextView = (TextView) findViewById(R.id.textView4);
        detailTextView = (TextView) findViewById(R.id.textView5);
        imageView = (ImageView) findViewById(R.id.imageView2);
        button = (Button) findViewById(R.id.button2);



        image1String = getIntent().getStringExtra("Image1");
        image2String = getIntent().getStringExtra("Image2");
        image3String = getIntent().getStringExtra("Image3");
        image4String = getIntent().getStringExtra("Image4");


        // Show View
        titleTextView.setText(getIntent().getStringExtra("Title"));
        detailTextView.setText(getIntent().getStringExtra("Detail"));

        showImage(indexAnInt);


        // Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }   // Main Method

    public void clickNextImage(View view) {

        if (indexAnInt >= 3) {
            indexAnInt = 0;
        } else {
            indexAnInt += 1;
        }

        Log.d("8decV1", "index ==> " + indexAnInt);

        showImage(indexAnInt);

    }

    public void clickBackImage(View view) {

        if (indexAnInt <= 0) {
            indexAnInt = 3;
        } else {
            indexAnInt -= 1;
        }

        Log.d("8decV1", "index ==> " + indexAnInt);

        showImage(indexAnInt);

    }

    private void showImage(int index) {

        String[] strings = new String[]{image1String, image2String, image3String, image4String};
        Picasso.with(Detail2Activity.this).load(strings[index]).into(imageView);

    }


} // Main Class