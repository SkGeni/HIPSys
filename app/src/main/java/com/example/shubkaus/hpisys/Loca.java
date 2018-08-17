package com.example.shubkaus.hpisys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Loca extends AppCompatActivity implements View.OnClickListener {
    public final static String message_key = "com.example.shubkaus.hpisys.message_h_O_b";
    Button hosp;
    Button bbank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loca);
        hosp = (Button)findViewById(R.id.hosp);
        hosp.setOnClickListener(this);
        bbank = (Button)findViewById(R.id.atm);
        bbank.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hosp:
                Intent i = new Intent(Loca.this, MapsActivity.class);
                i.putExtra(message_key,"hoss");
                startActivity(i);
                break;
            case R.id.atm:
                i = new Intent(Loca.this, MapsActivity.class);
                i.putExtra(message_key,"atm");
                startActivity(i);
                break;
            default:
                break;
        }
        }
}
