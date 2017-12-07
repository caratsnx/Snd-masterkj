package com.poc.tcs.snd;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;

import net.steamcrafted.lineartimepicker.dialog.LinearDatePickerDialog;
import net.steamcrafted.lineartimepicker.dialog.LinearTimePickerDialog;

import org.angmarch.views.NiceSpinner;
import org.joda.time.DateTime;
import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import co.ceryle.radiorealbutton.RadioRealButton;
import co.ceryle.radiorealbutton.RadioRealButtonGroup;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarListener;
import ernestoyaquello.com.verticalstepperform.VerticalStepperFormLayout;
import ernestoyaquello.com.verticalstepperform.interfaces.VerticalStepperForm;

public class AddTargetActivity extends AppCompatActivity implements VerticalStepperForm, DatePickerListener {
    private VerticalStepperFormLayout verticalStepperForm;
    EditText name;
    TextView txtDate;
    String radiobutton;
    com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker numberPicker;
    LinearLayout lvso;
    LinearLayout lvpinsparen;
    LinearLayout lvtikkie;
    NumberPicker np;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_target);
        String[] mySteps = {
                "Target Name",
                "Amount",
                "Date",
                "Contribution",
                "Details"
        };
        int colorPrimary = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
        int colorPrimaryDark = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark);
        radiobutton = new String();
        // Finding the view
        verticalStepperForm = (VerticalStepperFormLayout) findViewById(R.id.vertical_stepper_form);

        // Setting up and initializing the form
        VerticalStepperFormLayout.Builder.newInstance(verticalStepperForm, mySteps, this, this)
                .primaryColor(colorPrimary)
                .primaryDarkColor(colorPrimaryDark)
                .displayBottomNavigation(true) // It is true by default, so in this case this line is not necessary
                .init();

    }

    @Override
    public View createStepContentView(int stepNumber) {
        View view = null;
        switch (stepNumber) {
            case 0:
                view = createNameStep();
                break;
            case 1:
                view = createAmountStep();
                break;
            case 2:
                view = createPhoneNumberStep();
                break;
            case 3:
                view = createContributionStep();
                break;
            case 4:
                view = createContriDetails();
                break;
        }
        return view;
    }

    private View createContriDetails() {
        View v ;
        LayoutInflater inflater = LayoutInflater.from(getBaseContext());

        final LinearLayout lv = (LinearLayout) inflater.inflate(R.layout.standingorder_layout, null, false);
    lvso = (LinearLayout) lv.findViewById(R.id.layout_so);
        lvpinsparen = (LinearLayout) lv.findViewById(R.id.layout_pinsparen);
        lvtikkie = (LinearLayout) lv.findViewById(R.id.layout_tikkie);
        NiceSpinner niceSpinner = (NiceSpinner) lv.findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("Weekly", "Monthly", "Quarterly", "Yearly"));
        niceSpinner.attachDataSource(dataset);
        NiceSpinner niceSpinner_pins = (NiceSpinner) lv.findViewById(R.id.nice_spinner_pinsparen);
        List<String> dataset_pinsparen = new LinkedList<>(Arrays.asList("", "NL 95 ABNA 0446908045"));
        niceSpinner_pins.attachDataSource(dataset_pinsparen);

        NiceSpinner niceSpinner1 = (NiceSpinner) lv.findViewById(R.id.nice_spinner_tikkie);
        List<String> dataset1 = new LinkedList<>(Arrays.asList("10 €", "15 €", "20 €", "50 €"));
        niceSpinner1.attachDataSource(dataset1);


        final TextView tvstart = (TextView)lv.findViewById(R.id.startdate);
        final TextView tvend = (TextView)lv.findViewById(R.id.enddate);

        tvstart.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           LinearDatePickerDialog dialog = LinearDatePickerDialog.Builder.with(lv.getContext())
                                                   .setDialogBackgroundColor(Color.DKGRAY)
                                                   .setPickerBackgroundColor(Color.WHITE)
                                                   .setButtonColor(Color.parseColor("#ffd200"))
                                                   .setTextColor(Color.parseColor("#005e5d"))
                                                   .setShowTutorial(false)
                                                   .setMaxYear(2099)
                                                   .setMinYear(2017)
                                                   .setButtonCallback(new LinearDatePickerDialog.ButtonCallback() {
                                                       @Override
                                                       public void onPositive(DialogInterface dialog, int year, int month, int day) {
                                                           tvstart.setText(year + "/" + month + "/" + day);
                                                       }

                                                       @Override
                                                       public void onNegative(DialogInterface dialog) {

                                                       }
                                                   })
   /* methods to further customize the dialog go here */
                                                   .build();

                                           dialog.show();
                                           }});


        tvend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearDatePickerDialog dialog = LinearDatePickerDialog.Builder.with(lv.getContext())
                        .setDialogBackgroundColor(Color.DKGRAY)
                        .setPickerBackgroundColor(Color.WHITE)
                        .setButtonColor(Color.parseColor("#ffd200"))
                        .setTextColor(Color.parseColor("#005e5d"))
                        .setShowTutorial(false)
                        .setMaxYear(2099)
                        .setMinYear(2017)
                        .setButtonCallback(new LinearDatePickerDialog.ButtonCallback() {
                            @Override
                            public void onPositive(DialogInterface dialog, int year, int month, int day) {
                                tvend.setText(year + "/" + month + "/" + day);
                            }

                            @Override
                            public void onNegative(DialogInterface dialog) {

                            }
                        })
   /* methods to further customize the dialog go here */
                        .build();

                dialog.show();
            }});

        return lv;
    }

    private View createNameStep() {
        // Here we generate programmatically the view that will be added by the system to the step content layout
        name = new EditText(this);
        name.setSingleLine(true);
        name.setHint("Target Name");
        name.setHintTextColor(Color.GRAY);
        name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                verticalStepperForm.setActiveStepAsCompleted();
                verticalStepperForm.goToNextStep();
                return true;
            }
        });

        return name;
    }

    private View createAmountStep() {
        // In this case we generate the view by inflating a XML file
        LayoutInflater inflater = LayoutInflater.from(getBaseContext());

        FrameLayout emailLayoutContent = (FrameLayout) inflater.inflate(R.layout.email_step_layout, null, false);
    np = (NumberPicker) emailLayoutContent.findViewById(R.id.numberPicker);
        np.setMinValue(1);
        np.setMaxValue(10000);
        return emailLayoutContent;
    }

    private View createPhoneNumberStep() {
        LayoutInflater inflater = LayoutInflater.from(getBaseContext());
        LinearLayout phoneLayoutContent = (LinearLayout) inflater.inflate(R.layout.phone_step_layout, null, false);
        txtDate = (TextView) phoneLayoutContent.findViewById(R.id.datetext);

        return phoneLayoutContent;
    }

    private View createContributionStep() {
        LayoutInflater inflater = LayoutInflater.from(getBaseContext());
        LinearLayout contriLayoutContent = (LinearLayout) inflater.inflate(R.layout.select_contri_layout, null, false);

        // final RadioRealButton button1 = (RadioRealButton) contriLayoutContent.findViewById(R.id.button1);
        //  final RadioRealButton button2 = (RadioRealButton) contriLayoutContent.findViewById(R.id.button2);

        RadioRealButtonGroup group = (RadioRealButtonGroup) contriLayoutContent.findViewById(R.id.group);

        // onClickButton listener detects any click performed on buttons by touch
        group.setOnClickedButtonListener(new RadioRealButtonGroup.OnClickedButtonListener() {
            @Override
            public void onClickedButton(RadioRealButton button, int position) {
                radiobutton = Integer.toString(position);
            }
        });

        // onPositionChanged listener detects if there is any change in position
        group.setOnPositionChangedListener(new RadioRealButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(RadioRealButton button, int currentPosition, int lastPosition) {
                //   Toast.makeText(getApplicationContext(), "Position Changed! Position: " + currentPosition, Toast.LENGTH_SHORT).show();
            }
        });

        // onLongClickedButton detects long clicks which are made on any button in group.
        // return true if you only want to detect long click, nothing else
        // return false if you want to detect long click and change position when you release
        group.setOnLongClickedButtonListener(new RadioRealButtonGroup.OnLongClickedButtonListener() {
            @Override
            public boolean onLongClickedButton(RadioRealButton button, int position) {
                //   Toast.makeText(getApplicationContext(), "Long Clicked! Position: " + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        return contriLayoutContent;
    }


    @Override
    public void onStepOpening(int stepNumber) {
        switch (stepNumber) {
            case 0:
                verticalStepperForm.setStepAsCompleted(0);
                //     checkName();
                break;
            case 1:
                verticalStepperForm.setStepAsCompleted(1);
                checkEmail();
                break;
            case 2:
                // As soon as the phone number step is open, we mark it as completed in order to show the "Continue"
                // button (We do it because this field is optional, so the user can skip it without giving any info)
                verticalStepperForm.setStepAsCompleted(2);
                LinearDatePickerDialog dialog = LinearDatePickerDialog.Builder.with(this)
                        .setDialogBackgroundColor(Color.DKGRAY)
                        .setPickerBackgroundColor(Color.WHITE)
                        .setButtonColor(Color.parseColor("#ffd200"))
                        .setTextColor(Color.parseColor("#005e5d"))
                        .setShowTutorial(false)
                        .setMaxYear(2099)
                        .setMinYear(2017)
                        .setButtonCallback(new LinearDatePickerDialog.ButtonCallback() {
                            @Override
                            public void onPositive(DialogInterface dialog, int year, int month, int day) {
                                txtDate.setText(year + "/" + month + "/" + day);
                            }

                            @Override
                            public void onNegative(DialogInterface dialog) {

                            }
                        })
     /* methods to further customize the dialog go here */
                        .build();

                dialog.show();

                // In this case, the instruction above is equivalent to:
                // verticalStepperForm.setActiveStepAsCompleted();
                break;
            case 3:
                verticalStepperForm.setStepAsCompleted(3);
                break;
            case 4:
                verticalStepperForm.setStepAsCompleted(4);
                lvso.setVisibility(View.GONE);
                lvpinsparen.setVisibility(View.GONE);
                lvtikkie.setVisibility(View.GONE);
                if (radiobutton.equals("0"))
                {
                    lvso.setVisibility(View.VISIBLE);

                }
                if (radiobutton.equals("1"))
                {
                    lvpinsparen.setVisibility(View.VISIBLE);
                }
                if (radiobutton.equals("2"))
                {
                    lvtikkie.setVisibility(View.VISIBLE);
                }

                break;


        }

    }

    public void clickStartDate(View v) {
        final TextView tv = (TextView) findViewById(R.id.enddate);
        LinearDatePickerDialog dialog = LinearDatePickerDialog.Builder.with(this)
                .setDialogBackgroundColor(Color.DKGRAY)
                .setPickerBackgroundColor(Color.WHITE)
                .setButtonColor(Color.parseColor("#ffd200"))
                .setTextColor(Color.parseColor("#005e5d"))
                .setShowTutorial(false)
                .setMaxYear(2099)
                .setMinYear(2017)
                .setButtonCallback(new LinearDatePickerDialog.ButtonCallback() {
                    @Override
                    public void onPositive(DialogInterface dialog, int year, int month, int day) {
                        tv.setText(year + "/" + month + "/" + day);
                    }

                    @Override
                    public void onNegative(DialogInterface dialog) {

                    }
                })
   /* methods to further customize the dialog go here */
                .build();

        dialog.show();

    }

    public void clickEndDate(View v) {
        final TextView tv = (TextView) findViewById(R.id.startdate);
        LinearDatePickerDialog dialog = LinearDatePickerDialog.Builder.with(this)
                .setDialogBackgroundColor(Color.DKGRAY)
                .setPickerBackgroundColor(Color.WHITE)
                .setButtonColor(Color.parseColor("#ffd200"))
                .setTextColor(Color.parseColor("#005e5d"))
                .setShowTutorial(false)
                .setMaxYear(2099)
                .setMinYear(2017)
                .setButtonCallback(new LinearDatePickerDialog.ButtonCallback() {
                    @Override
                    public void onPositive(DialogInterface dialog, int year, int month, int day) {
                        tv.setText(year + "/" + month + "/" + day);
                    }

                    @Override
                    public void onNegative(DialogInterface dialog) {

                    }
                })
   /* methods to further customize the dialog go here */
                .build();

        dialog.show();

    }

    private void checkName() {
        if (name.length() >= 3 && name.length() <= 40) {
            verticalStepperForm.setActiveStepAsCompleted();
        } else {
            // This error message is optional (use null if you don't want to display an error message)
            String errorMessage = "The name must have between 3 and 40 characters";
            verticalStepperForm.setActiveStepAsUncompleted(errorMessage);
        }
    }

    private void checkEmail() {

    }

    @Override
    public void sendData() {

    Intent intent =  new Intent(getApplicationContext(),AppOverView.class);

    intent.putExtra("TargetName",name.getText());
    intent.putExtra("TargetAmount",np.getValue());
    startActivity(intent);

    }

    @Override
    public void onDateSelected(DateTime dateSelected) {

    }
}