package com.ldxiaofeng.android.myapplication01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1=(Button) findViewById(R.id.button_1);    //findViewById()返回的是一个view对象，需要转化成Button对象
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String data="哈喽 活动2";
                Toast.makeText(FirstActivity.this,"You clickes button",
                        Toast.LENGTH_SHORT).show(); //LENGTH_LONG显示时间长
                Intent intent=new Intent("com.ldxiaofeng.android.myapplication01.ACTION_START");//Intent用于启动活动
                intent.addCategory("com.ldxiaofeng.android.myapplication01.MY_CATEGORY");
                intent.putExtra("extra_data",data);//putExtra()传递数据 第一个参数是键，第二个是真正要传的数据
                //startActivity(intent);//启动Intent的方法
                startActivityForResult(intent,1);//也可以启动活动，这个方法期望下个活动（活动2）销毁时能够返回一个结果给活动1
            }
        });
    }
    //菜单部分
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"添加",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"移除",Toast.LENGTH_SHORT).show();
                break;
            case R.id.return_item:
                finish();
                break;
            default:
        }
        return true;
    }
    //用来接收活动二销毁后传输回来的数据
    //用startActivityForResult（）创建的活动被销毁后都会返回到onActivityResult()，根据返回的值resultCode 确定数据来源
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
        }
    }
}
