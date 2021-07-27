package com.example.sports_buddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateOrViewAvailable extends AppCompatActivity {
    private Button create;
    private Button available;
    private Button Back;
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
                Intent back = new Intent(CreateOrViewAvailable.this, MainActivity.class);
                startActivity(back);
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