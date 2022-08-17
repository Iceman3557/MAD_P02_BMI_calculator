package com.example.mad_p02bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button metric = (Button) findViewById(R.id.metric_button);
        Button imperial = (Button) findViewById(R.id.imperial_button);

        metric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity(0);
            }
        });

        imperial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity(1);
            }
        });

    }

    private void nextActivity(int sys){
        Intent nextActivityIntent = new Intent(this,Third_Activity.class);
        nextActivityIntent.putExtra("system",sys);
        // sys values: 0 => Metric, 1 => Imperial
        startActivity(nextActivityIntent);
    }
}