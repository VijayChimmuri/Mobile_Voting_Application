package com.example.mobilevoting;

import android.content.ComponentName;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;

public class UserActivity extends AppCompatActivity {
    Button btnHelp;
    Button btnVote;
    Button btnLogOut;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        btnLogOut = (Button)findViewById(R.id.btnLogOut);
        btnVote=(Button)findViewById(R.id.btnVote);
        btnHelp=(Button)findViewById(R.id.btnHelp);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I=new Intent(UserActivity.this, ActivityLogin.class);
                startActivity(I);

            }
        });

        btnVote.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {

                                           FirebaseAuth.getInstance().signOut();
                                           Intent i = getPackageManager().getLaunchIntentForPackage("com.example.votingapp");
                                           startActivity(i);

                                       }
                                   });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseAuth.getInstance().signOut();
                Intent I=new Intent(UserActivity.this, VotevideoActivity.class);
                startActivity(I);

            }
        });
    }



}


