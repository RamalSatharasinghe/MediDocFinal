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

public class medicalProfile extends AppCompatActivity {


     Button btnsubmit,btnview;

     EditText ageText,weightText,HeightText,sugarText,pressureText,cholesterolText;
     DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_profile);

        ageText    = findViewById(R.id.txtage);
        weightText = findViewById(R.id.txtweight);
        HeightText = findViewById(R.id.txtheight);
        sugarText  = findViewById(R.id.txtbsugar);
        pressureText = findViewById(R.id.txtpressure);
        cholesterolText = findViewById(R.id.txtcholesterol);

        btnsubmit = findViewById(R.id.btnSave);
        btnview = findViewById(R.id.btnView);


        db = new DBHelper(this);





        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean check = true;

                if(isEmpty(ageText)){

                    ageText.setError("Age is required ");
                    check = false;

                }

               if(isEmpty(weightText)){

                   weightText.setError("Weight is required");
                   check = false;
               }

               if(isEmpty(HeightText)){
                   HeightText.setError("Height is Required");
                   check = false;
               }

               if(isEmpty(sugarText)){

                   sugarText.setError("Sugar Level Required");
                   check = false;
               }

               if(isEmpty(pressureText)){
                   pressureText.setError("Pressure is Required");
                   check = false;
               }

               if(isEmpty(cholesterolText)){

                   cholesterolText.setError("Cholesterolol is Required");
                   check = false;
               }


               boolean result = false;

               if(check == true){

                   result = db.addHealthStatus(ageText.getText().toString(),weightText.getText().toString(),HeightText.getText().toString(),sugarText.getText().toString(),pressureText.getText().toString(),cholesterolText.getText().toString());
               }

               if(result == true){

                   Toast t = Toast.makeText(getApplicationContext(),"Submitted Successfully",Toast.LENGTH_LONG);
                    t.show();

               }

               else{

                   Toast t = Toast.makeText(getApplicationContext(),"Submition Failed",Toast.LENGTH_LONG);
                   t.show();
               }






            }
        });


        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(medicalProfile.this,medicineProfileDis.class);

                db.retriveHealthStatus();


                intent2.putExtra("Age",db.getAge());
                intent2.putExtra("Weight",db.getWeight());
                intent2.putExtra("Height",db.getHeight());
                intent2.putExtra("Bsugar",db.getBsugar());
                intent2.putExtra("pressureL",db.getPressureL());

                intent2.putExtra("cholestrol",db.getCholestrolL());

                startActivity(intent2);




            }
        });






    }



    private boolean isEmpty(EditText text){

        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);


    }

}
