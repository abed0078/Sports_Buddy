package com.example.sports_buddy;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class InsideRecyclerItemClick extends AppCompatActivity {
    TextView fillTitle, fillDate, fillDistance, fillDesc, fillTime, fillPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_recycler_item_click);

        TextView fillTitle = (TextView) findViewById(R.id.fillbytitle);
        TextView fillDate = (TextView) findViewById(R.id.fillbydate);
        TextView fillDistance = (TextView) findViewById(R.id.fillbydistance);
        TextView fillDesc = (TextView) findViewById(R.id.fillbydesc);
        TextView fillTime = (TextView) findViewById(R.id.fillbytime);
        TextView fillPart = (TextView) findViewById(R.id.fillbypart);
        TextView fillDuration = (TextView) findViewById(R.id.fillbyduration);
       TextView fillMax = (TextView) findViewById(R.id.fillbymax);
        TextView fillMin = (TextView) findViewById(R.id.fillbymin);
        TextView fillTheme = (TextView) findViewById(R.id.fillbytheme);
        TextView a = (TextView) findViewById(R.id.fillbya);
        TextView b = (TextView) findViewById(R.id.fillbyb);
        TextView c = (TextView) findViewById(R.id.fillbyc);
        TextView d = (TextView) findViewById(R.id.fillbyd);
        TextView e = (TextView) findViewById(R.id.fillbye);

        Intent i = getIntent();
        String title = i.getStringExtra("TITLE");
        String date = i.getStringExtra("DATE");
        String distance = i.getStringExtra("Distance");
        String description = i.getStringExtra("DESCRIPTION");
        String time = i.getStringExtra("TIME");
        String part = i.getStringExtra("NumberOfParticipants");
        String duration = i.getStringExtra("DURATION");
        String max = i.getStringExtra("MaximumSpeed");
        String min = i.getStringExtra("MinimumSpeed");
        String theme = i.getStringExtra("Theme");
        String ac = i.getStringExtra("a");
        String bc = i.getStringExtra("b");
        String cc = i.getStringExtra("c");
        String dc = i.getStringExtra("d");
        String ec = i.getStringExtra("e");

        fillTitle.setText(title);
        fillDate.setText(date);
        fillDistance.setText(distance);
        fillDesc.setText(description);
        fillTime.setText(time);
        fillPart.setText(part);
        fillDuration.setText(duration);
        fillMax.setText(max);
        fillMin.setText(min);
        fillTheme.setText(theme);
        a.setText(ac);
        b.setText(bc);
        c.setText(cc);
        d.setText(dc);
        e.setText(ec);


    }
}
