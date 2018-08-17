package com.example.shubkaus.hpisys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    Button emergency;
    Button locate;
    Button fact;
    Button appointment;
    Button history;
    Button AboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        emergency = (Button)findViewById(R.id.emergency);
        emergency.setOnClickListener(this);
        locate = (Button)findViewById(R.id.locate);
        locate.setOnClickListener(this);
        fact = (Button)findViewById(R.id.fact);
        fact.setOnClickListener(this);
        appointment = (Button)findViewById(R.id.appointment);
        appointment.setOnClickListener(this);
        history = (Button)findViewById(R.id.history);
        history.setOnClickListener(this);
        AboutUs = (Button)findViewById(R.id.AboutUS);
        AboutUs.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.emergency:
                Intent i = new Intent(MenuActivity.this,Emerg.class);
                startActivity(i);
                break;

            case R.id.locate:
                i = new Intent(MenuActivity.this,Loca.class);
                startActivity(i);
                break;

            case R.id.fact:
                i = new Intent(MenuActivity.this,Fac.class);
                startActivity(i);
                break;

            case R.id.appointment:
                i = new Intent(MenuActivity.this,Appo.class);
                startActivity(i);
                break;

            case R.id.history:
                i = new Intent(MenuActivity.this,Hist.class);
                startActivity(i);
                break;
            case R.id.AboutUS:
                i = new Intent(MenuActivity.this,AboutUS.class);
                startActivity(i);
                break;


            default:
                break;
        }
    }
}
