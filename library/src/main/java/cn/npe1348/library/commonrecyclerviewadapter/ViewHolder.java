package cn.npe1348.library.commonrecyclerviewadapter;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    // 用来存放子View减少findViewById的次数
    private SparseArray<View> mViews;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }
    /**
     * 通过id获取view
     */
    public <T extends View> T getView(int viewId){
        // 先从缓存中找
        View view = mViews.get(viewId);
        if (null == view){
            // 直接从ItemView中找
            view = itemView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T)view;
    }
    /**
     * 设置TextView文本
     */
    public ViewHolder setText(int viewId, String text){
        View view = getView(viewId);
        if (view instanceof TextView){
            ((TextView) view).setText(text);
        }
        return this;
    }
    /**
     * 设置ImageView的资源
     */
    public ViewHolder setImageResource(int viewId,int resourceId){
        View view = getView(viewId);
        if (view instanceof ImageView){
            ((ImageView) view).setImageResource(resourceId);
        }
        return this;
    }
    /**
     * 设置图片通过路径,这里稍微处理得复杂一些，因为考虑加载图片的第三方可能不太一样
     * 也可以直接写死
     */
    public ViewHolder setImageByUrl(int viewId,HolderImageLoader imageLoader){
        View view = getView(viewId);
        if (view instanceof ImageView){
            imageLoader.loadImage((ImageView) view,imageLoader.getUrl());
        }
        return this;
    }

    /**
     * 设置条目点击事件
     */
    public void setOnItemClickListener(View.OnClickListener listener) {
        itemView.setOnClickListener(listener);
    }

    /**
     * 设置条目长按事件
     */
    public void setOnItemLongClickListener(View.OnLongClickListener listener) {
        itemView.setOnLongClickListener(listener);
    }

    /**
     * 设置View的Visibility
     */
    public ViewHolder setViewVisibility(int viewId, int visibility) {
        getView(viewId).setVisibility(visibility);
        return this;
    }

    /**
     * 图片加载，这里稍微处理得复杂一些，因为考虑加载图片的第三方可能不太一样
     * 也可以不写这个类
     */
    public abstract static class HolderImageLoader{
        private String url;
        public HolderImageLoader(String url){
            this.url = url;
        }

        /**
         * 要去复写这个方法加载图片
         * @param imageView
         * @param path
         */
        public abstract void loadImage(ImageView imageView, String path);

        public String getUrl(){
            return url;
        }
    }
}
