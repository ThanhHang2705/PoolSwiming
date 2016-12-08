package bacdaibang.poolswiming;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ThanhHang on 12/7/2016.
 */

public class poolsAdapter extends BaseAdapter {
    public static final String BROADCAST_DATVE = "braodcast.datve";
    public static final String EXTRA_DATVE_POOLID = "extra.datve.poolid";
    ArrayList<Pool> mpools;
    LayoutInflater inflater;
    Context mcontext;

    public poolsAdapter(ArrayList<Pool> mpools, Context context) {
        this.mpools = mpools;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mcontext = context;
    }

    @Override
    public int getCount() {
        return mpools.size();
    }

    @Override
    public Pool getItem(int position) {
        return mpools.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View row, ViewGroup parent) {
        if(row==null){
            row = inflater.inflate(R.layout.item_pool,null);
        }
        TextView name = (TextView)row.findViewById(R.id.name);
        TextView diachi = (TextView)row.findViewById(R.id.diachi);
        TextView giave = (TextView)row.findViewById(R.id.giave);
        TextView rating = (TextView)row.findViewById(R.id.rating);
        Button datve = (Button)row.findViewById(R.id.datve);
        ImageView image = (ImageView)row.findViewById(R.id.imagePool);

        final Pool pool = mpools.get(position);
        name.setText("Tên: "+ pool.getName());
        diachi.setText("Địa chỉ: "+ pool.getLocation());
        giave.setText("Giá vé: "+ pool.getCost()+" VNĐ");
        rating.setText("Đánh giá: "+ pool.getRating()+" Điểm");

        InputStream in =null;
        Bitmap bmp=null;

        int responseCode = -1;
        try{

            URL url = new URL(pool.getImage());//"http://192.xx.xx.xx/mypath/img1.jpg
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setDoInput(true);
            con.connect();
            responseCode = con.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK)
            {
                //download
                in = con.getInputStream();
                bmp = BitmapFactory.decodeStream(in);
                in.close();
                image.setImageBitmap(bmp);
            }
        }
        catch(Exception ex){
            Log.e("Exception",ex.toString());
        }

        datve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(BROADCAST_DATVE);
                mIntent.putExtra(EXTRA_DATVE_POOLID,pool.getId());
                mcontext.sendBroadcast(mIntent);
            }
        });

        return row;
    }
}
