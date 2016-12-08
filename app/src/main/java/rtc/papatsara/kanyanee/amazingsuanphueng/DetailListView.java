package rtc.papatsara.kanyanee.amazingsuanphueng;


import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.view.View;

import android.widget.AdapterView;

import android.widget.Button;
import android.widget.ListView;


import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONObject;

import static rtc.papatsara.kanyanee.amazingsuanphueng.R.id.imageView;
import static rtc.papatsara.kanyanee.amazingsuanphueng.R.id.livRatchaburi;
import static rtc.papatsara.kanyanee.amazingsuanphueng.R.id.text;
import static rtc.papatsara.kanyanee.amazingsuanphueng.R.id.text2;
import static rtc.papatsara.kanyanee.amazingsuanphueng.R.id.textView2;


public class DetailListView extends AppCompatActivity {


    // Explicit
    private int anInt;
    private android.widget.ListView listView;
    private String tag1 = "21novV2";
    private Button button;
    //Explicit การประกาศตัวแปร



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_view);

        listView = (android.widget.ListView) findViewById(R.id.livRatchaburi);
        button = (Button) findViewById(R.id.button);





        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }   // onClick
        });




        // Main Method กลุ่มของคำสั่ง


        anInt = getIntent().getIntExtra("Category", 0);
        Log.d("21novV1", "Catetory ==>" + anInt);

        try {
            GetRatchaburiWhereCat getRatchaburiWhereCat1 = new GetRatchaburiWhereCat(DetailListView.this);
            getRatchaburiWhereCat1.execute(Integer.toString(anInt));
            String strJSON = getRatchaburiWhereCat1.get();
            Log.d("21novV2", "JSON (" + anInt + ")==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);

            final String[] nameStrings = new String[jsonArray.length()];
            final String[] datailStrings = new String[jsonArray.length()];
            final String[] image1Strings = new String[jsonArray.length()];
            final String[] image2Strings = new String[jsonArray.length()];
            final String[] image3Strings = new String[jsonArray.length()];
            final String[] image4Strings = new String[jsonArray.length()];
            final String[] latStrings = new String[jsonArray.length()];
            final String[] lngStrings = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                nameStrings[i] = jsonObject.getString("Name");
                datailStrings[i] = jsonObject.getString("Deteil");
                image1Strings[i] = jsonObject.getString("Image1");
                image2Strings[i] = jsonObject.getString("Image2");
                image3Strings[i] = jsonObject.getString("Image3");
                image4Strings[i] = jsonObject.getString("Image4");
                latStrings[i] = jsonObject.getString("Lat");
                lngStrings[i] = jsonObject.getString("Lng");

                Log.d(tag1, "Name(" + i + ") ==>" + nameStrings[i]);


            }   // for

            MyAdepter myAdepter = new MyAdepter(DetailListView.this, nameStrings, image1Strings,
                    datailStrings);
            listView.setAdapter(myAdepter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(DetailListView.this, Detail2Activity.class);
                    intent.putExtra("Title", nameStrings[position]);
                    intent.putExtra("Image", image1Strings[position]);
                    intent.putExtra("Detail", datailStrings[position]);
                    startActivity(intent);
                }
            });



        } catch (Exception e) {
            Log.d("21novV2", "e onCreate ==> " + e.toString());

        }


        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}   // Main Class