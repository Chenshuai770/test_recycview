package com.cs.test_recycview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView mRlvMain;
    private List<String> mData = new ArrayList<>();
    private Button mBtnMain;
    private HashMap map=new HashMap();
    private List<String> newData=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRlvMain = (RecyclerView) findViewById(R.id.rlv_main);
        mRlvMain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        for (int i = 0; i < 10; i++) {
            mData.add(i + "");
        }
        SampleAdapter sampleAdapter = new SampleAdapter(this, mData);
        mRlvMain.setAdapter(sampleAdapter);
        mBtnMain = (Button) findViewById(R.id.btn_main);
        mBtnMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main:
                for (int i = 0; i < mData.size(); i++) {
                    Log.d("MainActivity", mData.get(i).toString());
                }


                break;
        }
    }


}
