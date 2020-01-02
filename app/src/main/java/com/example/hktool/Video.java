package com.example.hktool;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;


public class Video extends AppCompatActivity   {


    private EditText url ;
    private Button  play ,qk;
    private String  data = null ;
    private Spinner  sp;
    private String jk = "http://jx.drgxj.com/?url=";
    private List<String> list ;
    //private   ArrayAdapter<String> arr ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_video);
        url = (EditText)findViewById(R.id.url);
        qk = (Button)findViewById(R.id.qk);
        play = (Button) findViewById(R.id.play) ;
        sp = (Spinner)findViewById(R.id.sp);

        list = new ArrayList<String>();
        list.add("接口1");
        list.add("接口2");
        list.add("接口3");
        list.add("接口3");
        list.add("腾讯");

        //适配器
        ArrayAdapter<String>  arr = new ArrayAdapter<String>(Video.this,android.R.layout.simple_spinner_item,list);
        //设置样式
        arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        sp.setAdapter(arr);
        //设置监听
        sp.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){

                    case 0:
                        jk = "https://jiexi.bm6ig.cn/?url=";

                       break;
                   case 1:
                       jk ="http://www.506060.com/jx/?url=" ;
                        break;
                   case 2:
                      jk = "https://jx.618g.com/?url=";
                        break;
                    case 3:
                      jk = "https://jiexi.380k.com/?url=";
                      break;
                    case 4:
                       jk = "http://jx.918jx.com/jx.php?url=";
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                  jk ="https://jx.618g.com/?url=" ;
            }
        });

        qk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url.setText(null);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data = url.getText().toString();

                if(data==""){
                    data = "http://www.iqiyi.com/v_19rsho7kz8.html" ;
                }


                Intent intent = new Intent( Intent.ACTION_VIEW);
                intent.setData(Uri.parse(jk+data));
                startActivity(intent);

            }
        });
    }
}
