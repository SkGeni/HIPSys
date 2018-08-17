package com.example.shubkaus.hpisys;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class UpdateHist extends AppCompatActivity {

    Button lastUpdate;
    EditText eBG;
    EditText eOP;
    EditText eAL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_hist);

        lastUpdate = (Button) findViewById(R.id.lastUpdate);
        lastUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eBG = (EditText) findViewById(R.id.eBG);
                eOP = (EditText) findViewById(R.id.eOP);
                eAL = (EditText) findViewById(R.id.eAL);
                FileOutputStream outputStream;
                try {
                    outputStream = openFileOutput("history.txt", Context.MODE_WORLD_READABLE);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
                    bw.write("Blood Group :  "+eBG.getText().toString()+"\n"+"Operated (YES/NO) :  "+eOP.getText().toString()+"\n"+"Allergy  :  "+eAL.getText().toString());
                    bw.close();
                    Intent i = new Intent(UpdateHist.this,Hist.class);
                    startActivity(i);


                }catch (Exception e) {
                e.printStackTrace();
            }
            }
        });
    }
}