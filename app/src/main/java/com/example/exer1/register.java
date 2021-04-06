package com.example.exer1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class register extends AppCompatActivity {
    Button btbat,btdaft;
    EditText etDaftNama,etDaftAlamat,etDaftMail,etDaftPass,etDaftRepass;
    TextInputLayout tlDaftNama,tlDaftAlamat,tlDaftMail,tlDaftPass,tlDaftRepass;
    RadioButton rIslam,rKatolik,rKristen,rBudha,rHindu,rKonghucu,rKepercayaan,rLaki,rPerempuan;
    RadioGroup rAgama1,rAgama2,rAgama3,rJK;
    boolean check, namavalid, alamatvalid, mailvalid, passvalid, repassvalid;
    int cekAg,cekKel;
    String jk="",agama="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btbat = findViewById(R.id.btBatal);
        btdaft = findViewById(R.id.btDaftar);
        etDaftNama = findViewById(R.id.edDaftNama);
        etDaftAlamat = findViewById(R.id.edDaftAlamat);
        etDaftMail = findViewById(R.id.edDaftMail);
        etDaftPass = findViewById(R.id.edDaftPass);
        etDaftRepass = findViewById(R.id.edDaftRepass);
        tlDaftNama = findViewById(R.id.tfDaftNama);
        tlDaftAlamat = findViewById(R.id.tfDaftAlamat);
        tlDaftMail = findViewById(R.id.tfDaftMail);
        tlDaftPass = findViewById(R.id.tfDaftPass);
        tlDaftRepass = findViewById(R.id.tfDaftRepass);
        rIslam = findViewById(R.id.rbIslam);
        rKatolik = findViewById(R.id.rbKatolik);
        rKristen = findViewById(R.id.rbKristen);
        rBudha = findViewById(R.id.rbBudha);
        rHindu = findViewById(R.id.rbHindu);
        rKonghucu = findViewById(R.id.rbKonghucu);
        rKepercayaan = findViewById(R.id.rbKepercayaan);
        rLaki = findViewById(R.id.rbLaki);
        rPerempuan = findViewById(R.id.rbPerempuan);
        rAgama1 = findViewById(R.id.rgAgama1);
        rAgama2 = findViewById(R.id.rgAgama2);
        rAgama3 = findViewById(R.id.rgAgama3);
        rJK = findViewById(R.id.rgJK);

        rAgama1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i != -1 && check){
                    check = false;
                    rAgama2.clearCheck();
                    rAgama3.clearCheck();
                    cekAg = i;
                }
                check = true;
            }
        });

        rAgama2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i != -1 && check){
                    check = false;
                    rAgama1.clearCheck();
                    rAgama3.clearCheck();
                    cekAg = i;
                }
                check = true;
            }
        });

        rAgama3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i != -1 && check){
                    check = false;
                    rAgama1.clearCheck();
                    rAgama2.clearCheck();
                    cekAg = i;
                }
                check = true;
            }
        });

        rJK.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i != -1 && check){
                    check = false;
                    cekKel= i;
                }
                check = true;
            }
        });

        btdaft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int j = cekKel;
                if (j == R.id.rbLaki){
                    jk = "Laki-Laki";
                } else if (j == R.id.rbPerempuan){
                    jk = "Perempuan";
                }

                int i = cekAg;
                if (i == R.id.rbIslam){
                    agama = "Islam";
                } else if (i == R.id.rbKatolik){
                    agama = "Katolik";
                } else if (i == R.id.rbKristen){
                    agama = "Kristen";
                } else if (i == R.id.rbBudha){
                    agama = "Budha";
                } else if (i == R.id.rbHindu){
                    agama = "Hindu";
                } else if (i == R.id.rbKonghucu){
                    agama = "Konghucu";
                } else if (i == R.id.rbKepercayaan){
                    agama = "Kepercayaan";
                }

                if (namavalid && alamatvalid && mailvalid && passvalid && repassvalid && !agama.isEmpty() && !jk.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Pendaftaran Sukses",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }

                if (etDaftNama.getText().toString().isEmpty()){
                    tlDaftNama.setError("Nama Tidak Boleh Kosong");
                    namavalid = false;
                } else {
                    tlDaftNama.setErrorEnabled(false);
                    namavalid = true;
                }

                if (etDaftAlamat.getText().toString().isEmpty()){
                    tlDaftAlamat.setError("Alamat Tidak Boleh Kosong");
                    alamatvalid = false;
                } else {
                    tlDaftAlamat.setErrorEnabled(false);
                    alamatvalid = true;
                }

                if (etDaftMail.getText().toString().isEmpty()){
                    tlDaftMail.setError("Email Tidak Boleh Kosong");
                    mailvalid = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(etDaftMail.getText().toString()).matches()){
                    tlDaftMail.setError("Masukkan Email dengan Benar");
                    mailvalid = false;
                } else {
                    mailvalid = true;
                    tlDaftMail.setErrorEnabled(false);
                }

                if (etDaftPass.getText().toString().isEmpty()){
                    tlDaftPass.setError("Password Tidak Boleh Kosong");
                    passvalid = false;
                } else if (etDaftPass.getText().length() < 6){
                    tlDaftPass.setError("Minimal 6 Karakter");
                    passvalid = false;
                } else {
                    passvalid = true;
                    tlDaftPass.setErrorEnabled(false);
                }

                if (etDaftRepass.getText().toString().isEmpty()){
                    tlDaftRepass.setError("Repassword Tidak Boleh Kosong");
                    repassvalid = false;
                } else if (etDaftRepass.getText().length() < 6){
                    tlDaftRepass.setError("Repassword Minimal 6 Karakter");
                    repassvalid = false;
                } else {
                    repassvalid = true;
                    tlDaftRepass.setErrorEnabled(false);
                }

                if (etDaftNama.getText().toString().isEmpty() || etDaftAlamat.getText().toString().isEmpty()
                        || etDaftMail.getText().toString().isEmpty() || etDaftPass.getText().toString().isEmpty()
                        || etDaftRepass.getText().toString().isEmpty() || agama.isEmpty() || jk.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Data Harus Diisi Semua", Toast.LENGTH_LONG).show();
                    namavalid = false;
                }
            }
        });

        btbat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}