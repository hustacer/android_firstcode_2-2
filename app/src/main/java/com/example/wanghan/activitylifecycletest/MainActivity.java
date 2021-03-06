package com.example.wanghan.activitylifecycletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG,tempData);
        }
        Button startNormalActivity =(Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity =(Button) findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void  onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        String tempData="Something you just typed";
        outState.putString("data_key", tempData);
    }
}
