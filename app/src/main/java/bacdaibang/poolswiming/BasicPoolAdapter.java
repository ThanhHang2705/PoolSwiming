package bacdaibang.poolswiming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static bacdaibang.poolswiming.R.id.diachi;

/**
 * Created by ThanhHang on 12/8/2016.
 */

public class BasicPoolAdapter extends BaseAdapter {
    ArrayList<Pool> listCoBan = new ArrayList<>();
    LayoutInflater inflater;

    public BasicPoolAdapter(ArrayList<Pool> listCoBan, Context context) {
        this.listCoBan = listCoBan;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listCoBan.size() ;
    }

    @Override
    public Pool getItem(int position) {
        return listCoBan.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView ==null) convertView = inflater.inflate(R.layout.item_pool_basic, null);
        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        TextView txt_diachi = (TextView) convertView.findViewById(diachi);
        TextView  txt_giaca = (TextView) convertView.findViewById(R.id.txt_giaca);

        Pool mpool = listCoBan.get(position);
        txt_diachi.setText(mpool.getLocation());
        img.setImageResource(R.drawable.thanh_xuan);
        txt_giaca.setText("giá vé : "+ mpool.getCost()+ " đ");
        return convertView;
    }
}
