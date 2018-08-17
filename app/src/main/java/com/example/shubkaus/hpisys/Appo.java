package com.example.shubkaus.hpisys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Appo extends AppCompatActivity implements View.OnClickListener {

    Button checkcon;
    String name;
    String age;
    String sex;
    String addr;
    String mob;
    String email;
    String bgr;
    String symp;
    String medhist;

    String method = "lelo_bhai_moka_hai";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appo);

        checkcon = (Button) findViewById(R.id.BtnNext);
        checkcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        EditText edName = (EditText) findViewById(R.id.edName);
        EditText edAge = (EditText) findViewById(R.id.edAge);
        EditText edSex = (EditText) findViewById(R.id.edSex);
        EditText edAddress = (EditText) findViewById(R.id.edAddress);
        EditText edMob = (EditText) findViewById(R.id.edMob);
        EditText edEmail = (EditText) findViewById(R.id.edEmail);
        EditText edBG = (EditText) findViewById(R.id.edBG);
        EditText edSymp = (EditText) findViewById(R.id.edSymp);
        EditText edMedHist = (EditText) findViewById(R.id.edMedHis);

        name = edName.getText().toString();
        age = edAge.getText().toString();
        sex = edSex.getText().toString();
        addr = edAddress.getText().toString();
        mob = edMob.getText().toString();
        email = edEmail.getText().toString();
        bgr = edBG.getText().toString();
        symp = edSymp.getText().toString();
        medhist = edMedHist.getText().toString();


        BackGro bgtask = new BackGro(this);
        bgtask.execute(method, name, age, sex, addr, mob, email, bgr, symp, medhist);
        finish();
    }
}
