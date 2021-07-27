package com.example.sports_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CreateOrViewAvailable extends AppCompatActivity {
    private ImageButton create;
    private ImageButton available;
    private ImageButton Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_view_available);
        create=findViewById(R.id.create);
        available=findViewById(R.id.available);
        Back=findViewById(R.id.button4);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent create = new Intent(CreateOrViewAvailable.this, FormActivity2.class);
                startActivity(create);
            }
        });

        available.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent available = new Intent(CreateOrViewAvailable.this, JoinActivity.class);
                startActivity(available);
            }
        });

    }

}