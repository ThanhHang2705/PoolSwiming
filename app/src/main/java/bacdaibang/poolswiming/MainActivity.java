package bacdaibang.poolswiming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String BOADCAST_PREPARED_DATA="broadcast.prepared.data";
    public static final int INTENT_FORRESULT_CODE = 113;

    BroadcastReceiver mBroadcastReceiver;
    poolsAdapter adapter;
    List<Pool> mPools = new ArrayList<>();

    List<String> mSearch = new ArrayList<>();

    ListView mListView;
    Button mButtonSearch;
    AutoCompleteTextView mAutoSearch;
    Adapter_Search mAdapterSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Phong truong hop ko down duoc anh http://stackoverflow.com/questions/16439587/android-os-networkonmainthreadexception-with-android-4-2
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        mListView=(ListView)findViewById(R.id.list_pool);
        mAutoSearch=(AutoCompleteTextView)findViewById(R.id.search_pool);
        mButtonSearch = (Button)findViewById(R.id.btn_search);

        mButtonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textSearch = mAutoSearch.getText().toString();
                Toast.makeText(MainActivity.this,textSearch,Toast.LENGTH_LONG).show();
            }
        });
        mAutoSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });


        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals(network.INTENT_INFO_JSON_DATA)){
                    try {
                        ParseJson_PoolInfor(new JSONArray(intent.getStringExtra(network.EXTRA_INFO_JSON_DATA)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if(intent.getAction().equals(poolsAdapter.BROADCAST_DATVE)){
                    Intent sendSignIn = new Intent(MainActivity.this,Activity_SignIn.class);
                    startActivityForResult(sendSignIn,INTENT_FORRESULT_CODE);
                }
                if(intent.getAction().equals(BOADCAST_PREPARED_DATA)){
                    adapter = new poolsAdapter((ArrayList<Pool>) mPools,MainActivity.this);
                    mListView.setAdapter(adapter);
                }
            }
        };
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(network.INTENT_INFO_JSON_DATA);
        mFilter.addAction(adapter.BROADCAST_DATVE);
        mFilter.addAction(BOADCAST_PREPARED_DATA);
        registerReceiver(mBroadcastReceiver,mFilter);


        network mNetwork = new network(this);
        mNetwork.getPoolInfor();

    }

    public void ParseJson_PoolInfor(JSONArray jsonArr){
        for(int i=0;i<jsonArr.length();i++){
            try {
                JSONObject jsonObject= jsonArr.getJSONObject(i);
                int id = jsonObject.getInt("0");
                String name = jsonObject.getString("1");
                String location = jsonObject.getString("2");
                String urlImage = jsonObject.getString("3");
                int cost = jsonObject.getInt("4");
                float rating = (float) jsonObject.getDouble("5");
                Pool temp = new Pool(id,name,location,urlImage,cost,rating);
                mPools.add(temp);
                mSearch.add(name);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        mAdapterSearch = new Adapter_Search(this,mSearch);
        String[] arr = new String[mSearch.size()];
        mSearch.toArray(arr);
        ArrayAdapter<String> adt = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,arr);
        mAutoSearch.setAdapter(adt);
        sendBroadcast(new Intent(BOADCAST_PREPARED_DATA));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == INTENT_FORRESULT_CODE){

        }
    }
}
