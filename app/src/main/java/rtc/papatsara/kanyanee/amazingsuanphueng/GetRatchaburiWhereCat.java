package rtc.papatsara.kanyanee.amazingsuanphueng;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by ACER on 21/11/2559.
 */

public class GetRatchaburiWhereCat extends AsyncTask<String, Void, String> {

    // Explicit
    private Context context;
    private static final String urlJSON = "http://swiftcodingthai.com/all/get_ratchaburi_where_category.php";

    public GetRatchaburiWhereCat(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Category", params[0])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            Log.d("21novV2", "e doIn ==>" + e.toString());
            return null;
        }
    }
}






