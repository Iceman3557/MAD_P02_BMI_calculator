package com.example.mad_p02bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        getSystem();
        double BMI = getBMI();
        setBMI(BMI);
    }

    private void getSystem(){


        TextView weightInfo = (TextView) findViewById(R.id.weightFinal_text);
        TextView heightInfo = (TextView) findViewById(R.id.heightFinal_text);

        Intent systemIntent = getIntent();
        int sys = systemIntent.getIntExtra("system",0);
        double weight = systemIntent.getDoubleExtra("weight",0);
        double height = systemIntent.getDoubleExtra("height",0);
        if (sys == 1){
            weightInfo.setText("Your weight is:"+weight+" LB" );
            heightInfo.setText("Your height is:"+height+" IN" );
        }
        else
        {
            weightInfo.setText("Your weight is:"+weight+" KG" );
            heightInfo.setText("Your height is:"+height+" CM" );
        }
        return sys;
    }

    private double getBMI(){
        double BMI = 0;

        Intent systemIntent = getIntent();
        int sys = systemIntent.getIntExtra("system",0);
        double weight = systemIntent.getDoubleExtra("weight",0);
        double height = systemIntent.getDoubleExtra("height",0);

        if (sys = 1);
        {
            BMI = weight/height*703;
        }
        else
        {
            BMI = weight/height;
        }

        return BMI;
    }

    private void setBMI(Double BMI){
        TextView value = (TextView) findViewById(R.id.valBMI_text);
        TextView info = (TextView)  findViewById(R.id.info);

        value.setText(Double.toString(BMI));
        if (BMI<18.6 && BMI > 0.0){
            info.setText("You are underweight");
        }
        else if(BMI<25.0){
            info.setText("You are normal weight");
        }
        else if(BMI<30.0){
            info.setText("You are overweight but not obese");
        }
        else if(BMI<35.0){
            info.setText("You are obese");
        }
        else if(BMI<40.0){
            info.setText("You are severely obese");
        }
        else if(BMI>40.0){
            info.setText("Can you see your toes?");
        }
        else //less than zero
        {
            info.setText("Invalid error");
        }
    }

}
