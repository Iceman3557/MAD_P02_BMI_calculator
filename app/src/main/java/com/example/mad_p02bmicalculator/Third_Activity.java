package com.example.mad_p02bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Third_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        retrieveSystem();

        Button next = (Button) findViewById(R.id.next_button);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if() {
                    nextActivity(0);
                }
            }
        });


    }

    private void retrieveSystem(){

        TextView prompt = (TextView) findViewById(R.id.selected_text);
        TextView w_unit = (TextView) findViewById(R.id.weightUnit_text);
        TextView h_unit = (TextView) findViewById(R.id.heightUnit_text);


        SeekBar w_seek = (SeekBar) findViewById(R.id.weight_seek);
        SeekBar h_seek = (SeekBar) findViewById(R.id.height_seek);

        Intent systemIntent = getIntent();
        int sys = systemIntent.getIntExtra("system",0);
        if (sys == 1){
            prompt.setText("You have selected Imperial System");

            int temp = 300*2.2;
            int temp2 = (int) 300/2.54;
            w_unit.setText("Lb");
            w_seek.setMax(temp);
            h_unit.setText("Inch");
            h_seek.setMax(temp2);
        }
        else
        {
            prompt.setText("You have selected Metric System");
            w_unit.setText("Kg");
            w_seek.setMax(300);
            h_unit.setText("Cm");
            h_unit.setText(300);
        }

    }
    private void nextActivity(int sys){
        Intent nextActivityIntent = new Intent(this,Third_Activity.class);
        nextActivityIntent.putExtra("system",sys);
        // sys values: 0 => Metric, 1 => Imperial
        startActivity(nextActivityIntent);
    }


}