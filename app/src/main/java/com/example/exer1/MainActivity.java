package com.example.exer1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button btlogin;
    EditText etmail,etpass;
    TextInputLayout mailror,passror;
    TextView tvdaftar;
    boolean mailvalid,passvalid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btlogin=findViewById(R.id.button);
        etmail=findViewById(R.id.edEmail);
        etpass=findViewById(R.id.edPass);
        tvdaftar=findViewById(R.id.tvreg);
        mailror=findViewById(R.id.tfmail);
        passror=findViewById(R.id.tfpass);

        btlogin.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View v) {
                if (etmail.getText().toString().isEmpty()){
                    mailror.setError("Email Tidak Boleh Kosong");
                    mailvalid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(etmail.getText().toString()).matches()){
                    mailror.setError("Masukkan Email dengan Benar");
                    mailvalid = false;
                } else {
                    mailvalid = true;
                    mailror.setErrorEnabled(false);
                }

                if (etpass.getText().toString().isEmpty()){
                    passror.setError("Password Tidak Boleh Kosong");
                    passvalid = false;
                } else if (etpass.getText().length() < 6){
                    passror.setError("Minimal 6 Karakter");
                    passvalid = false;
                } else {
                    passvalid = true;
                    passror.setErrorEnabled(false);
                }

                if (!mailvalid || !passvalid || !etmail.getText().toString().equals("fadhil@mail.com") || !etpass.getText().toString().equals("12345678")){
                    Toast.makeText(getApplicationContext(), "Email atau Password Salah !!!",Toast.LENGTH_LONG).show();
                    return;
                } else {
                    Toast.makeText(getApplicationContext(), "Login Sukses",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),ActivityKontak.class));
                }
            }
        });
        tvdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), register.class));
            }
        });
    }
}