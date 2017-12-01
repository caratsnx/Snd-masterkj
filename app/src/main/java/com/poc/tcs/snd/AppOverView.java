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
import android.widget.EditText;
import android.widget.LinearLayout;

import com.mancj.slideup.SlideUp;
import com.mancj.slideup.SlideUpBuilder;
import com.ramotion.foldingcell.FoldingCell;


public class AppOverView extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_over_view);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final FoldingCell fcsaving = findViewById(R.id.folding_cell_saving);
        fcsaving.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                fcsaving.toggle(false);
                return true;
            }

        });

       // initVerticalStepper();
    }
    public void initVerticalStepper()
    {
        String[] mySteps = {"Name", "Email", "Phone Number"};
        int colorPrimary = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
        int colorPrimaryDark = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark);

        // Finding the view


    }
    public void clickedNewTarget(View v)
    {
       // Intent intent = new Intent(this,AddNewProduct.class);
     //   startActivity(intent);
        View slideView = findViewById(R.id.slideView);
        SlideUp slideUp = new SlideUpBuilder(slideView)
                .withStartState(SlideUp.State.HIDDEN)
                .withStartGravity(Gravity.BOTTOM)

                //.withGesturesEnabled()
                //.withHideSoftInputWhenDisplayed()
                //.withInterpolator()
                //.withAutoSlideDuration()
                //.withLoggingEnabled()
                //.withTouchableAreaPx()
                //.withTouchableAreaDp()
                //.withListeners()
                //.withSavedState()
                .build();
        slideUp.show();
    }

    private View createNameStep() {
        // Here we generate programmatically the view that will be added by the system to the step content layout
        EditText name = new EditText(this);
        name.setSingleLine(true);
        name.setHint("Your name");

        return name;
    }

   // private View createEmailStep() {
        // In this case we generate the view by inflating a XML file
     //   LayoutInflater inflater = LayoutInflater.from(getBaseContext());
      // LinearLayout emailLayoutContent = (LinearLayout) inflater.inflate(R.layout.email_step_layout, null, false);
       // EditText email = (EditText) emailLayoutContent.findViewById(R.id.email);
        //return emailLayoutContent;
   // }

    //private View createPhoneNumberStep() {
     //   LayoutInflater inflater = LayoutInflater.from(getBaseContext());
      //  LinearLayout phoneLayoutContent = (LinearLayout) inflater.inflate(R.layout.phone_step_layout, null, false);

       // return phoneLayoutContent;
   // }

}
