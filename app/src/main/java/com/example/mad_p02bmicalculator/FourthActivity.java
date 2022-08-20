package com.example.mad_p02bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Button plus = (Button) findViewById(R.id.plus_button);
        Button minus = (Button) findViewById(R.id.minus_button);
        TextView weight = (TextView) findViewById(R.id.weightFinal_text);
        TextView height = (TextView) findViewById(R.id.heightFinal_text);
        TextView BMI_text = (TextView) findViewById(R.id.BMI_text);
        TextView info = (TextView) findViewById(R.id.info);
        TextView val = (TextView) findViewById(R.id.valBMI_text);




        getSystem();
        double BMI = getBMI();
        setBMI(BMI);


        if ( plus != null) {
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    increaseText(weight);
                    increaseText(height);
                    increaseText(BMI_text);
                    increaseText(info);
                    increaseText(val);

                }
            });
        }
        if (minus != null) {
            minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    decreaseText(weight);
                    decreaseText(height);
                    decreaseText(BMI_text);
                    decreaseText(info);
                    decreaseText(val);

                }
            });
        }
    }

    private void decreaseText(TextView a){
        float size = a.getTextSize();
        a.setTextSize(TypedValue.COMPLEX_UNIT_PX, size*0.9F);
    }

    private void increaseText(TextView a){
        float size = a.getTextSize();
        a.setTextSize(TypedValue.COMPLEX_UNIT_PX, size*1.1F);
    }

    private int getSystem(){


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

        if (sys == 1)
        {
            BMI = weight/height/height*703;
        }
        else
        {
            BMI = weight/height/height*10000;
        }

        return BMI;
    }

    private void setBMI(Double BMI){
        TextView value = (TextView) findViewById(R.id.valBMI_text);
        TextView info = (TextView)  findViewById(R.id.info);

        BMI = Math.round(BMI*100.0)/100.0;
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
            info.setText("more than severely obese");
        }
        else //less than zero
        {
            info.setText("Invalid error");
        }
    }

}
