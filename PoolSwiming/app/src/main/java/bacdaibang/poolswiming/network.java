package bacdaibang.poolswiming;

import android.content.Context;
import android.content.Intent;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

/**
 * Created by VietBac on 12/4/2016.
 */
public class network {
    Context mContext;
    network(Context context){
        mContext = context;
    }

    public static final String INTENT_INFO_JSON_DATA = "intent.info.json";

    public static final String EXTRA_INFO_JSON_DATA = "extra.info.json";

    public void getPoolInfor(){


        RequestQueue rq = Volley.newRequestQueue(mContext);
        String stringRq = "http://192.168.1.15/RequestPoolInfor.php?";

        JsonArrayRequest jSon = new JsonArrayRequest(Request.Method.GET, stringRq, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Intent intent = new Intent(INTENT_INFO_JSON_DATA);
                        intent.putExtra(EXTRA_INFO_JSON_DATA,response.toString());
                        mContext.sendBroadcast(intent);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        rq.add(jSon);
    }
}
