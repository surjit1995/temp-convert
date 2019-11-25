package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText etFah,etCel;
Button btnConvert,btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFah= findViewById(R.id.temF);
        etCel= findViewById(R.id.temCelsius);
        btnConvert=findViewById(R.id.convert);
        btnClear= findViewById(R.id.clear);

        //button as ClickListener
        btnClear.setOnClickListener(this);
        btnConvert.setOnClickListener(this);
    }
    public void onClick(View v)
    {
       switch (v.getId()){
           case R.id.clear:
               etFah.setText("");
               etCel.setText("");
               break;
           case R.id.convert:
               if(!etCel.getText().toString().equals("")){
                   //convert from celsius to Fahrenheit
                   double cel= Double.parseDouble(etCel.getText().toString());
                   double fah= cel*(9.0/5.0)+32;

                   Double result = new Double(fah);
                   String strDouble = String.format("%.2f", result);
                   etFah.setText(strDouble);

               }else if(!etFah.getText().toString().equals("")){

                   //convert from Fahrenheit to celsius
                   double fah= Double.parseDouble(etFah.getText().toString());
                   double cel= (fah-32)*(5.0/9.0);
                   Double result = new Double(cel);
                   String strDouble = String.format("%.2f", result);
                   etCel.setText(strDouble);
               }
               else // if bot fields are empty

                   Toast.makeText(getApplicationContext(),"Please enter the Temperature to convert...!",Toast.LENGTH_LONG).show();




       }
    }
}
