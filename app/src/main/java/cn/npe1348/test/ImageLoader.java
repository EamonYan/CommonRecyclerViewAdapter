package cn.npe1348.test;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import cn.npe1348.library.commonrecyclerviewadapter.ViewHolder;

public class ImageLoader extends ViewHolder.HolderImageLoader {
    public ImageLoader(String url){
        super(url);
    }
    @Override
    public void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).placeholder(R.drawable.ic_discovery_default_channel).into(imageView);
    }
}
