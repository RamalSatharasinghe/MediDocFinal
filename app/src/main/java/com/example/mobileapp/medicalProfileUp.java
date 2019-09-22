package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBHelper;

public class medicalProfileUp extends AppCompatActivity {

    EditText agetxt,weighttxt,heighttxt,bsugartxt,pressuretxt,cholestroltxt;
    DBHelper db;

    Button btnsave;
    String age,weight,height,bsugar,pressure,cholestrol;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_profile_up);


        db = new DBHelper(this);

        agetxt = findViewById(R.id.txtage);
        weighttxt = findViewById(R.id.txtweight);
        heighttxt = findViewById(R.id.txtheight);
        bsugartxt = findViewById(R.id.txtbsugar);
        pressuretxt = findViewById(R.id.txtpressure);
        cholestroltxt = findViewById(R.id.txtcholesterol);

        btnsave = findViewById(R.id.btnSave);



        Intent intent = getIntent();

        age = intent.getStringExtra("Age");
        weight = intent.getStringExtra("Weight");
        height = intent.getStringExtra("Height");
        bsugar = intent.getStringExtra("Bsugar");

        pressure = intent.getStringExtra("Pressure");
        cholestrol = intent.getStringExtra("Cholestrol");


        agetxt.setText(age);
        weighttxt.setText(weight);
        heighttxt.setText(height);

        bsugartxt.setText(bsugar);
        pressuretxt.setText(pressure);

        cholestroltxt.setText(cholestrol);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                boolean check = true;

                if(isEmpty(agetxt)){
                    agetxt.setError("Age is Required");
                    check = false;

                }

                if(isEmpty(weighttxt)){
                    weighttxt.setError("Weight is Required");
                    check = false;
                }

                if(isEmpty(heighttxt)){

                    heighttxt.setError("Height is Required");

                    check = false;
                }

                if(isEmpty(bsugartxt)){

                    bsugartxt.setError("Sugar level is Required");

                    check = false;
                }

                if(isEmpty(pressuretxt)){


                    pressuretxt.setError("Pressure is Required");
                    check = false;
                }

                if(isEmpty(cholestroltxt)){

                    cholestroltxt.setError("Cholestrol is Required");
                    check = false;
                }

                if(check = true){

                    int i = db.updateHealthStatus(agetxt.getText().toString(),weighttxt.getText().toString(),heighttxt.getText().toString(),bsugartxt.getText().toString(),pressuretxt.getText().toString(),cholestroltxt.getText().toString());

                    if(i > 0){
                        Toast.makeText(getApplicationContext(),"Updated Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(medicalProfileUp.this,medicineProfileDis.class);


                        db.retriveHealthStatus();
                        intent.putExtra("Age",db.getAge());
                        intent.putExtra("Weight",db.getWeight());
                        intent.putExtra("Height",db.getHeight());

                        intent.putExtra("Bsugar",db.getBsugar());

                        intent.putExtra("pressureL",db.getPressureL());
                        intent.putExtra("cholestrol",db.getCholestrolL());


                        startActivity(intent);


                    }

                    else{
                        Toast.makeText(getApplicationContext(),"Update failed",Toast.LENGTH_LONG).show();
                    }





                }

                else{

                    Toast.makeText(getApplicationContext(),"Update failed",Toast.LENGTH_LONG).show();
                }

            }
        });




















    }



    private  boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}
