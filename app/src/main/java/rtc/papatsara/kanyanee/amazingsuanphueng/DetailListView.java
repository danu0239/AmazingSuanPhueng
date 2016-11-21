package rtc.papatsara.kanyanee.amazingsuanphueng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DetailListView extends AppCompatActivity {

    // Explicit
    private int anInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_view);

        anInt = getIntent().getIntExtra("category", 0);
        Log.d("21novV1", "catetory ==>" + anInt);


    }   // Main Method
}   // Main Class
