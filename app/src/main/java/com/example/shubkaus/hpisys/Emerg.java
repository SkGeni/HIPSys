package com.example.shubkaus.hpisys;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Emerg extends AppCompatActivity implements View.OnClickListener{

    Button butHos;
    Button butFire;
    Button butPolice;
    Button butWHelp;
    Button butEDMang;
    Button butAnti;
    Button butSpc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emerg);
        butHos = (Button)findViewById(R.id.butHos);
        butHos.setOnClickListener(this);
        butFire =(Button) findViewById(R.id.butFire);
        butFire.setOnClickListener(this);
        butPolice = (Button)findViewById(R.id.butPolice);
        butPolice.setOnClickListener(this);
        butWHelp = (Button)findViewById(R.id.butWHelp);
        butWHelp.setOnClickListener(this);
        butEDMang = (Button)findViewById(R.id.butEDMang);
        butEDMang.setOnClickListener(this);
        butAnti = (Button)findViewById(R.id.butAnti);
        butAnti.setOnClickListener(this);
        butSpc = (Button) findViewById(R.id.butSpc);
        butSpc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.butHos:
                dialContactPhone("102");
                break;
            case R.id.butFire:
                dialContactPhone("101");
                break;
            case R.id.butPolice:
                dialContactPhone("100");
                break;
            case R.id.butWHelp:
                dialContactPhone("1091");break;
            case R.id.butEDMang:
                dialContactPhone("108");
                break;
            case R.id.butAnti:
                dialContactPhone("18001805522");
                break;
            case R.id.butSpc:
                dialContactPhone("911");
                break;
            default:
                break;

        }
        }
    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}
