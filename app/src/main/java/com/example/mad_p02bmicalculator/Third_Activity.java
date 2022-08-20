package com.example.mad_p02bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;



public class Third_Activity extends AppCompatActivity {

    private static int WEIGHT_MAX = 300;
    private static int HEIGHT_MAX = 300;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        int sys = retrieveSystem();

        Button next = (Button) findViewById(R.id.next_button);
        SeekBar w_seek = (SeekBar) findViewById(R.id.weight_seek);
        SeekBar h_seek = (SeekBar) findViewById(R.id.height_seek);

        w_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateWeightAns(i);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        h_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateHeightAns(i);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validationFunction(sys)) {
                    nextActivity(sys);
                }
            }
        });


    }

    private int retrieveSystem(){

        TextView prompt = (TextView) findViewById(R.id.selected_text);
        TextView w_unit = (TextView) findViewById(R.id.weightUnit_text);
        TextView h_unit = (TextView) findViewById(R.id.heightUnit_text);


        SeekBar w_seek = (SeekBar) findViewById(R.id.weight_seek);
        SeekBar h_seek = (SeekBar) findViewById(R.id.height_seek);



        Intent systemIntent = getIntent();
        int sys = systemIntent.getIntExtra("system",0);
        Log.d("system check",Integer.toString(sys));

        if (sys == 1){
            prompt.setText("You have selected Imperial System");

            int temp = (int) WEIGHT_MAX* (int)2.2;
            int temp2 = (int) HEIGHT_MAX/ (int)2.54;
            w_unit.setText("Lb");
            w_seek.setMax(temp);
            h_unit.setText("Inch");
            h_seek.setMax(temp2);
        }
        else
        {
            prompt.setText("You have selected Metric System");
            w_unit.setText("Kg");
            w_seek.setMax(WEIGHT_MAX);
            h_unit.setText("Cm");
            h_seek.setMax(HEIGHT_MAX);
        }
        return sys;
    }

    private void updateWeightAns(int i){
        EditText weightAns = findViewById(R.id.weightAns_text);
        weightAns.setText(Integer.toString(i));
    }

    private void updateHeightAns(int i){
        EditText heightAns = findViewById(R.id.heightAns_text);
        heightAns.setText(Integer.toString(i));
    }

    private boolean validationFunction(int sys){
        boolean ans = false;

        EditText weightAns = findViewById(R.id.weightAns_text);
        EditText heightAns = findViewById(R.id.heightAns_text);
        CoordinatorLayout bot = findViewById(androidx.coordinatorlayout.R.id.bottom);
        double weight = Double.parseDouble(weightAns.getText().toString());
        double height = Double.parseDouble(heightAns.getText().toString());

        if (sys == 0) {
            if (weight > WEIGHT_MAX || weight < 0) {
                Snackbar.make(bot, "The weight is outside the specifications", Snackbar.LENGTH_SHORT)
                        .show();
            } else if (height > HEIGHT_MAX || height < 0) {
                Snackbar.make(bot, "The height is outside the specifications", Snackbar.LENGTH_SHORT)
                        .show();
            } else {
                ans = true;
            }
        }
        else {
            if (weight > WEIGHT_MAX*2.2 || weight < 0) {
                Snackbar.make(bot, "The weight is outside the specifications", Snackbar.LENGTH_SHORT)
                        .show();
            } else if (height > HEIGHT_MAX/2.54 || height < 0) {
                Snackbar.make(bot, "The height is outside the specifications", Snackbar.LENGTH_SHORT)
                        .show();
            } else {
                ans = true;
            }
        }

        return ans;
    }



    private void nextActivity(int sys){

        EditText weightAns = (EditText) findViewById(R.id.weightAns_text);
        EditText heightAns = (EditText) findViewById(R.id.heightAns_text);
        double weight = Double.parseDouble(weightAns.getText().toString());
        double height = Double.parseDouble(heightAns.getText().toString());


        Intent nextActivityIntent = new Intent(this,FourthActivity.class);
        nextActivityIntent.putExtra("system",sys);
        // sys values: 0 => Metric, 1 => Imperial
        nextActivityIntent.putExtra("weight",weight);
        nextActivityIntent.putExtra("height",height);
        startActivity(nextActivityIntent);
    }


}