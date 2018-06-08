package com.ldxiaofeng.android.myapplication01;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Intent intent=getIntent();
        String data=intent.getStringExtra("extra_data");//getStringExtra()获取传递的数据 整形:getIntExtra()类推
        Log.d("SecondActivity",data);

        Button button2=(Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));  //打开浏览器
                startActivity(intent);
            }
        });
        Button button4=(Button) findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086")); //拨号
                startActivity(intent);
            }
        });
        Button button5=(Button) findViewById(R.id.button_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("data_return","哈喽 活动1");
                setResult(RESULT_OK,intent);//用于向上一个活动返回数据
                finish();
            }
        });
    }

    //用户通过按返回键返回上个活动，传回数据
    @Override
    public void onBackPressed() {
        Intent intent=new Intent();
        intent.putExtra("data_return","哈喽 活动1");
        setResult(RESULT_OK,intent);//用于向上一个活动返回数据
        finish();
    }
}
