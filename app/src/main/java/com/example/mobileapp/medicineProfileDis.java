package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHelper;

public class medicineProfileDis extends AppCompatActivity {

    DBHelper db;

    Button btnupdate,btndelete;


    TextView Agetxt,Weighttxt,Heighttxt,Bsugartxt,Pressureltxt,CholestrolLtxt;


    private String age,weight,height,bsugar,pressureL,cholestrolL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_profile_dis);


        db = new DBHelper(this);

        Agetxt = findViewById(R.id.txtage);
        Weighttxt = findViewById(R.id.txtweight);

        Heighttxt = findViewById(R.id.txtheight);
        Bsugartxt = findViewById(R.id.txtbsugar);
        Pressureltxt = findViewById(R.id.txtpressure);

        CholestrolLtxt = findViewById(R.id.txtcholestrol);


        Intent intent = getIntent();


        age = intent.getStringExtra("Age");
        weight = intent.getStringExtra("Weight");
        height = intent.getStringExtra("Height");
        bsugar = intent.getStringExtra("Bsugar");

        pressureL = intent.getStringExtra("pressureL");

        cholestrolL = intent.getStringExtra("cholestrol");


        Agetxt.setText(age);
        Weighttxt.setText(weight);
        Heighttxt.setText(height);

        Bsugartxt.setText(bsugar);

        Pressureltxt.setText(pressureL);

        CholestrolLtxt.setText(cholestrolL);




        btnupdate = findViewById(R.id.btnupdate);
        btndelete = findViewById(R.id.btndelete);


        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(medicineProfileDis.this,medicalProfileUp.class);

                intent.putExtra("Age",age);
                intent.putExtra("Weight",weight);

                intent.putExtra("Height",height);

                intent.putExtra("Bsugar",bsugar);
                intent.putExtra("Pressure",pressureL);

                intent.putExtra("Cholestrol",cholestrolL);



                startActivity(intent);
            }
        });


        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.deleteHealthstatus();

                Intent intent = new Intent(medicineProfileDis.this,medicalProfile.class);

                Toast t = Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_LONG);
                t.show();

                startActivity(intent);

            }
        });


    }
}
