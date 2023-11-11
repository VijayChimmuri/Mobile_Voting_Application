package com.example.votingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText editTextAddvoter;
    Button buttonvoter;
    Spinner spinnerGenres;

    DatabaseReference databaseNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseNota = FirebaseDatabase.getInstance().getReference("voterr");

        editTextAddvoter = (EditText) findViewById(R.id.editTextAddvoter);
        buttonvoter = (Button) findViewById(R.id.buttonvoter);
        spinnerGenres = (Spinner) findViewById(R.id.spinnerGenres);


        buttonvoter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                addVote();

            }


        });
    }

    private void addVote() {
        final String vote = editTextAddvoter.getText().toString().trim();
        final String genre = spinnerGenres.getSelectedItem().toString();

        if (!TextUtils.isEmpty(vote)) {
            String id = databaseNota.push().getKey();
            Voterr voterr = new Voterr(id, vote, genre);
            databaseNota.child(id).setValue(voterr);


            Toast.makeText(MainActivity.this, "Voted", Toast.LENGTH_LONG).show();

            Intent i = getPackageManager().getLaunchIntentForPackage("com.example.mobilevoting");
            startActivity(i);


        } else {
            Toast.makeText(MainActivity.this, "Pls Enter Voter Id No", Toast.LENGTH_LONG).show();
        }


    }


}









