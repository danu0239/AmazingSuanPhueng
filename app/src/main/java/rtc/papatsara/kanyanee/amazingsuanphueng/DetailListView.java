package rtc.papatsara.kanyanee.amazingsuanphueng;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class DetailListView extends AppCompatActivity {



    // Explicit
    private int anInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_view);

        anInt = getIntent().getIntExtra("category", 0);
        Log.d("21novV1", "Catetory ==>" + anInt);

        try {
            GetRatchaburiWhereCat getRatchaburiWhereCat = new GetRatchaburiWhereCat(DetailListView.this);
            getRatchaburiWhereCat.execute(Integer.toString(anInt));
            String strJSON = getRatchaburiWhereCat.get();
            Log.d("21novV2","JSON (" + anInt + ")==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);

            String[] nameStrings = new String[jsonArray.length()];
            String[] datailStrings = new String[jsonArray.length()];
            String[] image1Strings = new String[jsonArray.length()];
            String[] image2Strings = new String[jsonArray.length()];
            String[] image3Strings = new String[jsonArray.length()];
            String[] image4Strings = new String[jsonArray.length()];
            String[] latStrings = new String[jsonArray.length()];
            String[] lngStrings = new String[jsonArray.length()];

            for (int i = 0; i <jsonArray.length(); i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                nameStrings[i] = jsonObject.getString("Name");
                datailStrings[i] = jsonObject.getString("Detail");
                image1Strings[i] = jsonObject.getString("Image1");
                image2Strings[i] = jsonObject.getString("Image2");
                image3Strings[i] = jsonObject.getString("Image3");
                image4Strings[i] = jsonObject.getString("Image4");
                latStrings[i] = jsonObject.getString("Lat");
                lngStrings[i] = jsonObject.getString("Lng");



            }   // for



        }catch (Exception e){
            Log.d("21novV2", "e onCreate ==> " + e.toString());

        }


    }   // Main Method
}   // Main Class
