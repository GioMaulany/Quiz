package com.example.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    EditText etUN,etPW;
    Button bt_log,bt_sig;
    SharedPreferences SP;
    SharedPreferences.Editor SPE;
    String user,pswrd;
    Boolean svlg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUN = findViewById(R.id.uname);
        etPW = findViewById(R.id.pass);
        bt_log = findViewById(R.id.log_btn);
        bt_sig = findViewById(R.id.sig_btn);
        SharedPreferences SP = getApplicationContext().getSharedPreferences("un",MODE_PRIVATE);
        final SharedPreferences.Editor editor = SP.edit();

        bt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 user= etUN.getText().toString();
                 pswrd= etPW.getText().toString();
                 if (user.equals("admin")&& pswrd.equals("admin")){
                     Toast.makeText(MainActivity.this,"Login Sucess",Toast.LENGTH_LONG).show();
                     editor.putString("logged",user);
                     editor.commit();
                     Intent a = new Intent(getApplication(),Menu_Activity.class);
                     startActivity(a);
                     finish();
                 }
                 else {
                     Toast.makeText(MainActivity.this,"Invalid Username / Password",Toast.LENGTH_LONG).show();
                 }

                 }
        });
        bt_sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
