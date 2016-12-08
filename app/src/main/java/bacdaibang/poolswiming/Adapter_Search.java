package bacdaibang.poolswiming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by VietBac on 12/5/2016.
 */
public class Adapter_Search extends BaseAdapter{
    List<String> mListSearch;
    Context mContext;
    Adapter_Search(Context mContext,List<String> mListSearch){
        this.mContext = mContext;
        this.mListSearch = mListSearch;
    }
    @Override
    public int getCount() {
        return mListSearch.size();
    }

    @Override
    public String getItem(int i) {
        return mListSearch.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater mInflate = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = mInflate.inflate(R.layout.item_pool,viewGroup,false);
        return v;
    }
}
