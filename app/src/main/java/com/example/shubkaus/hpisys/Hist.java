package com.example.shubkaus.hpisys;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Hist extends AppCompatActivity {

    Button HisIn;
    Button HisOut;
    Button btnUpdate;
    final int min = 100000;
    final int max = 999999;
    Random r = new Random();
    final String random = String.valueOf(r.nextInt((max - min) + 1) + min);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hist);

        HisIn = (Button)findViewById(R.id.btnHisIN);
        HisIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = "pasHIS.txt";
                FileOutputStream outputStream;

                try {
                    outputStream = openFileOutput(filename, Context.MODE_WORLD_READABLE);
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
                    bw.write(random);
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                EditText num = (EditText)findViewById(R.id.mobNO);
                sendSMS(num.getText().toString(),random);

                btnUpdate = (Button)findViewById(R.id.btnUpdate);
                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            FileInputStream inputStream = openFileInput("pasHIS.txt");
                            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                            String st = br.readLine();
                            EditText otp = (EditText)findViewById(R.id.textotp);
                            if(otp.getText().toString().equals(st)){
                                Intent i = new Intent(Hist.this,UpdateHist.class);
                                startActivity(i);
                            }

                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            public void sendSMS(String phoneNo, String msg) {
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, msg, null, null);
                    Toast.makeText(getApplicationContext(), "Message Sent",
                            Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                            Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }
            }
        });

        HisOut = (Button)findViewById(R.id.btnHisOUT);
        HisOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str;
                TextView histo = (TextView)findViewById(R.id.textHist);
                try {
                    FileInputStream inputStream = openFileInput("history.txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                    if (inputStream!= null) {
                        while ((str = br.readLine()) != null) {
                            histo.append(str + "\n" );
                        }
                    }
                    br.close();

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

}
