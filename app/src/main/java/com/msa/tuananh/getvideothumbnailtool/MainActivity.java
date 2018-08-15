package com.msa.tuananh.getvideothumbnailtool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/*
    17:10 - 15/08/2018
    Tuan Anh dep trai
    hihi
 */

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Video> mList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRv();
    }

    private void initRv() {
        recyclerView = findViewById(R.id.main_rv);
        mList = Utilities.listRaw();
        adapter = new Adapter(mList, this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }
}
