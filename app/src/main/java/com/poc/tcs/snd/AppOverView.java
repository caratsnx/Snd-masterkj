package com.poc.tcs.snd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;


public class AppOverView extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_over_view);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);


        final FoldingCell fcsaving = findViewById(R.id.folding_cell_saving);
        fcsaving.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                fcsaving.toggle(false);
                return true;
            }

        });

        Bundle extras = getIntent().getExtras();
        if (getIntent().getExtras()!= null)
        {
            ((LinearLayout)findViewById(R.id.linear_newpart)).setVisibility(View.VISIBLE);

            ((TextView)findViewById(R.id.title_no_account2)).setText("3");
            ((TextView)findViewById(R.id.acccount)).setText("3");
            ((CheckBox)findViewById(R.id.changecheckbox)).setVisibility(View.VISIBLE);
            ((CheckBox)findViewById(R.id.changecheckbox)).setText( extras.get("TargetName").toString());
            ((TextView)findViewById(R.id.head_image_right_below)).setText("€" +  String.valueOf(75000 + Integer.parseInt((extras.get("TargetAmount").toString()))));
            ((TextView)findViewById(R.id.name_of_target )).setText(extras.get("TargetName").toString());
            ((TextView)findViewById(R.id.savinggoal)).setText("€" +  extras.get("TargetAmount").toString());


        }


    }

    public void clickedNewTarget(View v)
    {
        Intent intent = new Intent(this,AddTargetActivity.class);
       startActivity(intent);

    }


}
