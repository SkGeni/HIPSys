package com.example.shubkaus.hpisys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Fac extends AppCompatActivity implements View.OnClickListener {

    Button butInfl;
    Button butCan;
    Button butmumps;
    Button butHIV;
    Button butChic;
    Button butTB;
    Button btnRAab;
    Button butswine;
    Button POLIO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fac);
        butInfl = (Button)findViewById(R.id.butInfl);
        butInfl.setOnClickListener(this);
        butCan = (Button)findViewById(R.id.butCan);
        butCan.setOnClickListener(this);
        butmumps = (Button)findViewById(R.id.butmumps);
        butmumps.setOnClickListener(this);
        butHIV = (Button)findViewById(R.id.butHIV);
        butHIV.setOnClickListener(this);
        butChic = (Button)findViewById(R.id.butChic);
        butChic.setOnClickListener(this);
        butTB = (Button)findViewById(R.id.butTB);
        butTB.setOnClickListener(this);
        btnRAab = (Button)findViewById(R.id.btnRAab);
        btnRAab.setOnClickListener(this);
        butswine = (Button)findViewById(R.id.butswine);
        butswine.setOnClickListener(this);
        POLIO =(Button) findViewById(R.id.POLIO);
        POLIO.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.butInfl:
                i = new Intent(Fac.this, ButInfl.class);
                startActivity(i);
                break;
            case R.id.butCan:
                i = new Intent(Fac.this, ButCan.class);
                startActivity(i);
                break;
            case R.id.butmumps:
                i = new Intent(Fac.this, Butmumps.class);
                startActivity(i);
                break;
            case R.id.butHIV:
                i = new Intent(Fac.this, ButHIV.class);
                startActivity(i);
                break;
            case R.id.butChic:
                i = new Intent(Fac.this, ButChic.class);
                startActivity(i);
                break;
            case R.id.butTB:
                i = new Intent(Fac.this, ButTB.class);
                startActivity(i);
                break;
            case R.id.btnRAab:
                i = new Intent(Fac.this, BtnRAab.class);
                startActivity(i);
                break;
            case R.id.butswine:
                i = new Intent(Fac.this, Butswine.class);
                startActivity(i);
                break;
            case R.id.POLIO:
                i = new Intent(Fac.this, Poolio.class);
                startActivity(i);
                break;
            default:
                break;
        }
        }
}
