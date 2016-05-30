package com.yanghuan.MyApplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.yanghuan.R;
import com.yanghuan.Utils.JiemuShow;
import com.yanghuan.adapters.JieMu_showAdapter;

import java.util.ArrayList;
import java.util.List;

public class JieMuItemActivity extends AppCompatActivity {
    JieMu_showAdapter adapter;
    ListView listView;
    List<JiemuShow> list;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_mu_item);
        initView();
        initData();
        String  activityName=getIntent().getStringExtra("1");
    }

    private void initData() {
        JiemuShow jiemuShow=new JiemuShow("继承者们（芒果台）","http://o6nj6n5ea.bkt.clouddn.com/yh_jm_pic2.png","演员：李敏镐");
        JiemuShow jiemuShow1=new JiemuShow("奔跑吧兄弟（芒果台）","http://o6nj6n5ea.bkt.clouddn.com/yh_jm_Pic.png","演员：李敏镐");
        JiemuShow jiemuShow2=new JiemuShow("太阳的后裔（芒果台）","http://o6nj6n5ea.bkt.clouddn.com/yh_jm_pic4.png","演员：李敏镐");
        JiemuShow jiemuShow3=new JiemuShow("我们相爱吧（芒果台）","http://o6nj6n5ea.bkt.clouddn.com/yh_jm_pic3.png","演员：李敏镐");
        list.add(jiemuShow);
        list.add(jiemuShow1);
        list.add(jiemuShow2);
        list.add(jiemuShow3);
        list.add(jiemuShow1);
        list.add(jiemuShow2);
        list.add(jiemuShow3);
        list.add(jiemuShow1);
       adapter=new JieMu_showAdapter(list,JieMuItemActivity.this);
        listView.setAdapter(adapter);
        addListener();
    }

    private void addListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(JieMuItemActivity.this,"欢迎进入"+(position)+"聊天室",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        listView= (ListView) findViewById(R.id.activity_jieitem_listview);
        list=new ArrayList<>();
        imageView= (ImageView) findViewById(R.id.activity_jiemu_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
