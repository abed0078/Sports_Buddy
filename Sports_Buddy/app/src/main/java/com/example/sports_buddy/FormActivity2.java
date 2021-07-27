package com.example.sports_buddy;

import com.google.android.gms.maps.model.LatLng;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.firebase.database.FirebaseDatabase;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static android.widget.TextView.OnClickListener;

public class FormActivity2 extends AppCompatActivity {
    private static final String TAG = "FormActivity2";
    private static final int LAUNCH_MAPS_ACTIVITY = 1;
    private EditText location, dateedit, titleedit, descriptionedit, timePicker1, editcheck;
    private Button send;
    private int hour, minute;
    private SeekBar seekbar;
    private TextView progresstext, locationtxt;
    CheckBox c1, c2, c3, c4, c5;

    @RequiresApi(api = Build.VERSION_CODES.M)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);

//this code is for the complete text view
        EditText location = (EditText) findViewById(R.id.locationedit);
        Places.initialize(getApplicationContext(), "AIzaSyB2VnHy1F8QjD7xlpZYyj1WbsBMgWA9UxM");
        location.setFocusable(false);
        location.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //initialize place field list
                List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG, Place.Field.NAME);
                //Create intent
                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fieldList).build(FormActivity2.this);
                //startActivityForResult
                startActivityForResult(intent, 100);
            }

        });



        location = findViewById(R.id.locationedit);
        final Calendar myCalendar = Calendar.getInstance();
        dateedit = findViewById(R.id.dateedit);
        descriptionedit = findViewById(R.id.descriptionedit);
        titleedit = findViewById(R.id.titleedit);
        editcheck = findViewById(R.id.editcheck6);
        timePicker1 = findViewById(R.id.timePicker1);
        c1 = findViewById(R.id.check1);
        c2 = findViewById(R.id.check2);
        c3 = findViewById(R.id.check3);
        c4 = findViewById(R.id.check4);
        c5 = findViewById(R.id.check5);
        final Spinner maxspeed = (Spinner) findViewById(R.id.spinnermax);
        final Spinner minspeed = (Spinner) findViewById(R.id.spinnermin);
        final Spinner theme = (Spinner) findViewById(R.id.spinnertheme);
        final Spinner spinnerduration = (Spinner) findViewById(R.id.spinnerduration);
        final TextView progresstext = (TextView) findViewById(R.id.progresstext);
        final SeekBar seekbar = (SeekBar) findViewById(R.id.seekBar);
        send = findViewById(R.id.send);

        send.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("TITLE", titleedit.getText().toString());
                map.put("DATE", dateedit.getText().toString());
                map.put("NumberOfParticipants", editcheck.getText().toString());
                map.put("DESCRIPTION", descriptionedit.getText().toString());
                map.put("TIME", timePicker1.getText().toString());
                map.put("MaximumSpeed", maxspeed.getSelectedItem().toString());
                map.put("MinimumSpeed", minspeed.getSelectedItem().toString());
                map.put("Theme", theme.getSelectedItem().toString());
                map.put("DURATION", spinnerduration.getSelectedItem().toString());
                map.put("DISTANCE", progresstext.getText().toString());


                if (c1.isChecked()) {
                    map.put("a", c1.getText().toString());
                }
                if (c2.isChecked()) {
                    map.put("b", c2.getText().toString());
                }
                if (c3.isChecked()) {
                    map.put("c", c3.getText().toString());
                }
                if (c4.isChecked()) {
                    map.put("d", c4.getText().toString());
                }
                if (c5.isChecked()) {
                    map.put("e", c5.getText().toString());
                }
                if (titleedit.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Title is mandatory", Toast.LENGTH_LONG).show();
                } else if (dateedit.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Date is mandatory", Toast.LENGTH_LONG).show();
                } else if (editcheck.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "you should specify the number of participants", Toast.LENGTH_LONG).show();
                } else if (descriptionedit.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), " Description is mandatory", Toast.LENGTH_LONG).show();
                } else if (timePicker1.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), " Time is mandatory", Toast.LENGTH_LONG).show();
                } else if (maxspeed.getSelectedItem().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "there is no maximum speed", Toast.LENGTH_LONG).show();
                } else if (minspeed.getSelectedItem().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "there is no minimum speed", Toast.LENGTH_LONG).show();
                } else if (theme.getSelectedItem().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "there is no theme specified for the run", Toast.LENGTH_LONG).show();
                } else if (spinnerduration.getSelectedItem().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "there is no duration specified for the run", Toast.LENGTH_LONG).show();
                } else if (progresstext.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "there is no distance specified for the run", Toast.LENGTH_LONG).show();
                } else {
                    FirebaseDatabase.getInstance().getReference().child("Post").push()
                            .setValue(map)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(getBaseContext(), "done", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getBaseContext(), "failed", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getBaseContext(), "sent", Toast.LENGTH_SHORT).show();
                            Intent i =new Intent(FormActivity2.this,CreateOrViewAvailable.class);
                            startActivity(i);
                        }
                    });
                }
            }
        });


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i = i + 1;
                progresstext.setText(i + "km");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


//////////////////////////////////////Maxspeed spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Maxspeed, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        maxspeed.setAdapter(adapter);
////////////////////////////////////////////////////////////////////

////////////////////////////////////Minspeed spinner
        ArrayAdapter<CharSequence> ladapter = ArrayAdapter.createFromResource(this,
                R.array.Minspeed, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        minspeed.setAdapter(ladapter);
        //////////////////////////////////////////////////////////////theme spinner//
        ArrayAdapter<CharSequence> themeadapter = ArrayAdapter.createFromResource(this,
                R.array.theme, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        theme.setAdapter(themeadapter);
///////////////////////////////////////////////////////////aproxx spinner
        ArrayAdapter<CharSequence> aproxadapter = ArrayAdapter.createFromResource(this,
                R.array.approximate_duration, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerduration.setAdapter(aproxadapter);
////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////////////////////////////this code is for timepicker
        timePicker1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;

                mTimePicker = new TimePickerDialog(FormActivity2.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timePicker1.setText("" + checkDigit(selectedHour) + ":" + checkDigit(selectedMinute));
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });


////////////////////////////////////////////////////////////////////////////////this code is for datepicker
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

            private void updateLabel() {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                dateedit.setText(sdf.format(myCalendar.getTime()));
            }

        };
        dateedit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(FormActivity2.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }


    //////////////////////////////////////////this method is used to ensure the the preceding zero in the timepicker is presented
    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    ///////////////////////////////this methode is used for the complete text view
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            //when success
            //initialize place
            Place place = Autocomplete.getPlaceFromIntent(data);
            //set address on Edit text
            location.setText(place.getAddress());

        } else {
            if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                Status status = Autocomplete.getStatusFromIntent(data);
                //display Toast
                Toast.makeText(getApplicationContext(), status.getStatusMessage(),
                        Toast.LENGTH_SHORT).show();
////////////////////////////////////////////////////////////////////////////////////
            }
        }

    }
}














