package bacdaibang.poolswiming;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PoolBasic_activity extends AppCompatActivity {
    ArrayList<Pool> listPoolBasic = new ArrayList<>();
    ListView lv_poolBasic;
    BasicPoolAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_basic_activity);
        lv_poolBasic = (ListView) findViewById(R.id.lv_poolBasic);
        getList(listPoolBasic);
        adapter = new BasicPoolAdapter(listPoolBasic, this);
        lv_poolBasic.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lv_poolBasic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(PoolBasic_activity.this,MainActivity.class));
            }
        });
    }

    void getList(ArrayList<Pool> a){
        a.add(new Pool("Thanh Xuân Hà Nội",10000));
        a.add(new Pool("Xuân Thủy Cầu Giấy",20000));
        a.add(new Pool("Hồ Tây",50000));
        a.add(new Pool("Thanh Xuân Hà Nội",30000));
        a.add(new Pool("Thanh Xuân Hà Nội",25000));
        a.add(new Pool("Thanh Xuân Hà Nội",15000));
    }
}
