package com.example.mad_p02bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button no = (Button) findViewById(R.id.no_button);
        Button yes = (Button) findViewById(R.id.yes_button);
        Snackbar.make(no,"Please come back when you are older",Snackbar.LENGTH_SHORT)
        .show();


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });
    }
    private void nextActivity(){
        Intent nextActivityIntent = new Intent(this,SecondActivity.class);
        startActivity(nextActivityIntent);
    }
}