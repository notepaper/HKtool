package com.example.hktool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ListView list_item ;
    private SimpleAdapter adapter ;
    private List<Map<String,Object>> List ;
    private  int [] img = {R.mipmap.family,R.mipmap.vip,R.mipmap.about };
    private String [] setname = {"亲戚关系查询","VIP电影解析","更多内容"};
    private String [] setjieshao = {"解决过年难题之一,不知道如何称呼。","让大家不花钱就能观看各大VIP视频。","正在开发中,敬请期待。"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_item = (ListView)findViewById(R.id.list_item);
        //加载数据
        List = new ArrayList<Map<String,Object>>();
        for (int i= 0; i<setname.length;i++){
            Map<String,Object> map = new HashMap<String, Object>();

            map.put("img",img[i]);
            map.put("name",setname[i]);
            map.put("jieshao",setjieshao[i]);
            List.add(map);
        }


        //应用自定义布局 R.layout.layout_qq
        adapter= new SimpleAdapter(MainActivity.this,List,R.layout.layout_list,new String[]{"img","name","jieshao"},new int[] {R.id.img,R.id.name,R.id.jieshao});

        list_item.setAdapter(adapter);

        list_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    //第一项 亲戚查询
                    case 0 :
                        Intent intent = new Intent(MainActivity.this,Qinqichaxun.class);
                        startActivity(intent);
                        break;

                     //VIP视频解析
                    case 1:
                        intent = new Intent(MainActivity.this,Video.class);
                        startActivity(intent);

                        break;
                }
            }
        });

    }
}
