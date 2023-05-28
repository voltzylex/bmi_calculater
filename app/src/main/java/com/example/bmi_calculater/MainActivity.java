package com.example.bmi_calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText enterHI,enterW,enterHF;
        Button btnCalculate;
        TextView txtrst;
        LinearLayout firstPage;
        firstPage = findViewById(R.id.firstPage);
        enterW = findViewById(R.id.edtWeight);
        enterHF = findViewById(R.id.edtHeight);
        enterHI = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtrst = findViewById(R.id.result);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          int wt =  Integer.parseInt( enterW.getText().toString());
                int hf =  Integer.parseInt( enterHF.getText().toString());
                int hi =  Integer.parseInt( enterHI.getText().toString());
                Log.d("ADebugTag", "Value: " +wt+hi+hf);
                int totalInch = hf*12 + hi;
                double totalC = totalInch*2.53;
                double totalMe = totalC/100;
                double bmi = wt/(totalMe*totalMe);
                if(bmi>25){
//                      android:backgroundTint="@color/teal_200"
                        txtrst.setText("You are Overweight");
                        firstPage.setBackgroundColor(getResources().getColor(R.color.overWeight));
                }else if(bmi<18){
                txtrst.setText("You are Healthy Dont Worry");
                    firstPage.setBackgroundColor(getResources().getColor(R.color.normatlWeight));
                }else{
                    txtrst.setText("You are UnderWeight");
                    firstPage.setBackgroundColor(getResources().getColor(R.color.underWeight));
                }



            }
        });
    }
}