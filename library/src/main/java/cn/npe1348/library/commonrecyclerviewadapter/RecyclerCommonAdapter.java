package cn.npe1348.library.commonrecyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract  class RecyclerCommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;

    private LayoutInflater mLayoutInflater;

    private ItemClickListener mItemClickListener;

    private ItemLongClickListener mItemLongClickListener;

    public RecyclerCommonAdapter(Context context, List<T> mDatas, int mLayoutId) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mLayoutId = mLayoutId;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(mLayoutId,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        convert(holder,mDatas.get(position),position);

        // 设置点击和长按事件
        if (null != mItemClickListener){
            holder.setOnItemClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(position);
                }
            });
        }

        if (null != mItemLongClickListener){
            holder.setOnItemLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return mItemLongClickListener.onLongClick(position);
                }
            });
        }
    }
    /***************
     * 给条目设置点击和长按事件
     *********************/
    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.mItemClickListener = itemClickListener;
    }

    public void setOnItemLongClickListener(ItemLongClickListener itemLongClickListener){
        this.mItemLongClickListener = itemLongClickListener;
    }

    protected abstract void convert(ViewHolder holder, T t, int position);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
