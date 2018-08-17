package com.example.shubkaus.hpisys;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubham Kumar on 2/7/2017.
 */
public class BackGro extends AsyncTask<String,Void,String>{
    Context ctx;
    String name;
    String age;
    String sex;
    String addr;
    String mob;
    String email;
    String bgr;
    String symp;
    String medhist;

    BackGro(Context ctx){
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://172.16.12.188/android/android_appointment.php";
        String method = params[0];
        name = params[1];
        age = params[2];
        sex = params[3];
        addr = params[4];
        mob = params[5];
        email = params[6];
        bgr = params[7];
        symp = params[8];
        medhist = params[9];

        if(method.equals("lelo_bhai_moka_hai")){
            try {
                URL url = new URL(reg_url);
               /* HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
*/
                //user--identifier and data are encoded
                String data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8")+"&"+
                        URLEncoder.encode("sex","UTF-8")+"="+URLEncoder.encode(sex,"UTF-8")+"&"+
                        URLEncoder.encode("addr","UTF-8")+"="+URLEncoder.encode(addr,"UTF-8")+"&"+
                        URLEncoder.encode("mob","UTF-8")+"="+URLEncoder.encode(mob,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("bgr","UTF-8")+"="+URLEncoder.encode(bgr,"UTF-8")+"&"+
                        URLEncoder.encode("symp","UTF-8")+"="+URLEncoder.encode(symp,"UTF-8")+"&"+
                        URLEncoder.encode("medhist","UTF-8")+"="+URLEncoder.encode(medhist,"UTF-8");

            //    URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new
                        InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                //return sb.toString();

              /*  bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();

                InputStream is = httpURLConnection.getInputStream();      //neede to get some data from server. Here we are not using it.
                is.close();

       */
                return sb.toString()+"Appointment fixed.\nContact our Online Portal Department for FEE.\n\t\tHappywala Digital INDIA!!";


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }
}
