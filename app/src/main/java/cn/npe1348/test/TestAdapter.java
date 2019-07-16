package cn.npe1348.test;

import android.content.Context;

import java.util.List;

import cn.npe1348.library.commonrecyclerviewadapter.RecyclerCommonAdapter;
import cn.npe1348.library.commonrecyclerviewadapter.ViewHolder;

public class TestAdapter extends RecyclerCommonAdapter<String> {

    public TestAdapter(Context context, List<String> data){
        super(context,data,R.layout.item_common_adapter);
    }
    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        holder.setText(R.id.text1,s).setText(R.id.text2,s+s);
        holder.setImageByUrl(R.id.icon,new ImageLoader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563269254640&di=3ba62579d87d361cd93ab10cdecea49f&imgtype=0&src=http%3A%2F%2Fp2.bahamut.com.tw%2FM%2F2KU%2F37%2F0001126337.JPG%3F_%3D1421643125179"));
    }
}
