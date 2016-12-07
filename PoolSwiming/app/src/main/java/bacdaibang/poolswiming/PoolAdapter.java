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
import java.util.List;

/**
 * Created by VietBac on 12/4/2016.
 */
public class PoolAdapter extends BaseAdapter {
    public static final String BROADCAST_DATVE = "braodcast.datve";
    public static final String EXTRA_DATVE_POOLID = "extra.datve.poolid";
    List<Pool> mPools;
    Context mContext;

    PoolAdapter(Context mContext, List<Pool> mPools){
        this.mContext = mContext;
        this.mPools = mPools;
    }


    @Override
    public int getCount() {
        return mPools.size();
    }

    @Override
    public Object getItem(int i) {
        return mPools.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View row;
        LayoutInflater mLayoutInflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = mLayoutInflate.inflate(R.layout.item_pool,null,false);
        TextView name = (TextView)row.findViewById(R.id.name);
        TextView diachi = (TextView)row.findViewById(R.id.diachi);
        TextView giave = (TextView)row.findViewById(R.id.giave);
        TextView rating = (TextView)row.findViewById(R.id.rating);
        Button datve = (Button)row.findViewById(R.id.datve);
        ImageView image = (ImageView)row.findViewById(R.id.imagePool);


        name.setText("Tên: "+mPools.get(i).name);
        diachi.setText("Địa chỉ: "+mPools.get(i).location);
        giave.setText("Giá vé: "+mPools.get(i).cost+" VNĐ");
        rating.setText("Đánh giá: "+mPools.get(i).rating+" Điểm");

        InputStream in =null;
        Bitmap bmp=null;

        int responseCode = -1;
        try{

            URL url = new URL(mPools.get(i).image);//"http://192.xx.xx.xx/mypath/img1.jpg
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
                mIntent.putExtra(EXTRA_DATVE_POOLID,mPools.get(i).id);
                mContext.sendBroadcast(mIntent);
            }
        });
        return row;
    }
}
