package com.blacio.touchgame;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class LevelsActivity extends Activity {

    private RecyclerView mRecyclerView;
    private GridListAdapter mAdapter;
    List<GridItem> mItemList = new ArrayList<>();
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("Pos");

        configViews();
    }

    private void configViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewList);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setHasFixedSize(true);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 4);

            mRecyclerView.setLayoutManager(gridLayoutManager);
            mAdapter = new GridListAdapter(mItemList, gridLayoutManager, 4, this,pos);
        }

        else{

            GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 3);

            mRecyclerView.setLayoutManager(gridLayoutManager);
            mAdapter = new GridListAdapter(mItemList, gridLayoutManager, 3, this,pos);
        }


        mRecyclerView.setAdapter(mAdapter);

        addMockList();

    }

    private void addMockList() {


        for(int i=1;i<=20;i++){
            mAdapter.addItem(new GridItem("Level\n"+i));
        }
    }


    @Override
    protected void onPause() {

        AudioPlay.pauseAudio();

        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        AudioPlay.resumeAudio();
    }


}
