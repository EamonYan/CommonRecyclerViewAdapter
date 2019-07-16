package cn.npe1348.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.npe1348.library.commonrecyclerviewadapter.ItemClickListener;
import cn.npe1348.library.commonrecyclerviewadapter.ItemLongClickListener;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;

    private TestAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new TestAdapter(this, mDatas);

        mRecyclerView.setAdapter(mAdapter);

        // 设置显示分割 ListView样式
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 添加分割线
        mRecyclerView.addItemDecoration(new CategoryItemDecoration(ContextCompat.getDrawable(this, R.drawable.category_list_divider)));

        mAdapter.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "点击--"+position, Toast.LENGTH_SHORT).show();
            }
        });

        mAdapter.setOnItemLongClickListener(new ItemLongClickListener() {
            @Override
            public boolean onLongClick(int position) {
                Toast.makeText(MainActivity.this, "长按--"+position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'Z'+1; i++) {
            mDatas.add("" + (char) i);
        }
    }
}
