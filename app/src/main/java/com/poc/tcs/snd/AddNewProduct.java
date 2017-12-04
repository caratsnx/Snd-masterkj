package com.poc.tcs.snd;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.ramotion.cardslider.CardSliderLayoutManager;
import com.ramotion.cardslider.CardSnapHelper;

import java.util.ArrayList;
import java.util.List;

import link.fls.swipestack.SwipeStack;


public class AddNewProduct extends AppCompatActivity  implements SwipeStack.SwipeStackListener, View.OnClickListener {
    private SwipeStack mSwipeStack;
    private SwipeStackAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);
        int colorPrimary = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
        int colorPrimaryDark = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark);

        List<String> mData = new ArrayList<>();
        mData.add("Hello");
        mData.add("Bye");
        mData.add("Test");
        mSwipeStack = (SwipeStack) findViewById(R.id.swipeStack);
        mAdapter = new SwipeStackAdapter(mData,this);
        mSwipeStack.setAdapter(mAdapter);
        mSwipeStack.setListener(this);


        //String[] stepsSubtitles = getResources().getStringArray(R.array.steps_subtitles);

        // Here we find and initialize the form


    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onViewSwipedToLeft(int position) {
        String swipedElement = mAdapter.getItem(position);

    }

    @Override
    public void onViewSwipedToRight(int position) {
        String swipedElement = mAdapter.getItem(position);

    }

    @Override
    public void onStackEmpty() {

    }
}
