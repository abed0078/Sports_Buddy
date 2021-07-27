package com.example.sports_buddy;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


import android.app.Activity;
import android.app.NotificationManager;

import android.content.Context;
import android.content.Intent;
import android.net.sip.SipAudioCall;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;


public class InsideRecyclerItemClick extends AppCompatActivity {
    private DatabaseReference mFirebaseDatabaseReference;
    private String mUsername;
    final private String FCM_API = "https://fcm.googleapis.com/fcm/send";
    final private String serverKey = "key=" + "AAAA146j_y4:APA91bF7SYVsRxSqB20FAGk1Xtwky-Cy1yk3KX1xBmkbX26dyKycHPHzHqHO0olXY7X8oTPHUBKRehlPm12qYGJvDrQTT1BLfvCSFcwI71HaRBXsPbQwrfj3gW5xvX58U_uer8cbiUVI";
    final private String contentType = "application/json";
    final String TAG = "NOTIFICATION TAG";

    String NOTIFICATION_TITLE;
    String NOTIFICATION_MESSAGE;
    String TOPIC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_recycler_item_click);

        ImageButton join = (ImageButton) findViewById(R.id.imageButton2);


        FirebaseMessaging.getInstance().subscribeToTopic("news");
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TOPIC = "/topics/news"; //topic must match with what the receiver subscribed to
                NOTIFICATION_TITLE =" Congrats!!";
                NOTIFICATION_MESSAGE = "you have a new participant";

                JSONObject notification = new JSONObject();
                JSONObject notifcationBody = new JSONObject();
                try {
                    notifcationBody.put("title", NOTIFICATION_TITLE);
                    notifcationBody.put("message", NOTIFICATION_MESSAGE);

                    notification.put("to", TOPIC);
                    notification.put("data", notifcationBody);
                } catch (JSONException e) {
                    Log.e(TAG, "onCreate: " + e.getMessage() );
                }
                sendNotification(notification);


            }


        });

        TextView fillTitle = findViewById(R.id.textView3);
        TextView fillDate = findViewById(R.id.textView18);
        TextView fillDistance = findViewById(R.id.textView19);
        TextView fillTime = findViewById(R.id.textView20);
        TextView fillPart = findViewById(R.id.textView22);
        TextView fillDuration = findViewById(R.id.textView21);
        TextView fillMax = findViewById(R.id.textView23);
        TextView fillMin = findViewById(R.id.textView24);
        TextView fillTheme = findViewById(R.id.textView25);
        TextView a = findViewById(R.id.textView26);
        TextView b = findViewById(R.id.textView27);
        TextView c = findViewById(R.id.textView28);
        TextView d = findViewById(R.id.textView29);
        TextView e = findViewById(R.id.textView30);
        TextView fillDesc = findViewById(R.id.textView31);

        Intent i = getIntent();
        String title = i.getStringExtra("TITLE");
        String date = i.getStringExtra("DATE");
        String distance = i.getStringExtra("Distance");
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
        String description = i.getStringExtra("DESCRIPTION");

        fillTitle.setText(title);
        fillDate.setText(date);
        fillDistance.setText(distance);
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
        fillDesc.setText(description);
    }

   /* private void addNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_stat_ic_notification)
                .setContentTitle("Congrats")
                .setContentText("you have a new participants")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }*/

    private void sendNotification(JSONObject notification) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(FCM_API, notification,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "onResponse: " + response.toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(InsideRecyclerItemClick.this, "Request error", Toast.LENGTH_LONG).show();
                        Log.i(TAG, "onErrorResponse: Didn't work");
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Authorization", serverKey);
                params.put("Content-Type", contentType);
                return params;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);

    }
}




