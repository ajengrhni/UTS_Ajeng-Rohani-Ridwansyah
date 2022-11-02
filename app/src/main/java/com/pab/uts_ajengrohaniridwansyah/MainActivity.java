package com.pab.uts_ajengrohaniridwansyah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private EditText etNamle,etNopen;
    private CheckBox cbFb,cbIg,cbWeb;
    private Button btndaf;
    String informasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNamle = findViewById(R.id.et_naleng);
        etNopen = findViewById(R.id.et_nopend);
        cbFb = findViewById(R.id.cb_fb);
        cbIg = findViewById(R.id.cb_ig);
        cbWeb = findViewById(R.id.cb_web);
        btndaf =findViewById(R.id.btn_daftar);

        btndaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama,nomor,fb,ig,web;

                nama=etNamle.getText().toString();
                nomor=etNopen.getText().toString();
                fb=cbFb.getText().toString();
                ig=cbIg.getText().toString();
                web=cbWeb.getText().toString();

                HashSet<String> tampungInfo = new HashSet<String>();

                if (nama.trim().equals("")){
                    etNamle.setError("Mohon Isi Nama Terlebih Dahulu");
                }
                if (nomor.trim().equals("")){
                    etNopen.setError("Nomor Pendaftaran Mohon Disi Terlebih Dahulu");
                }
                if (cbFb.isChecked()){
                    tampungInfo.add(fb);
                }
                if (cbIg.isChecked()){
                    tampungInfo.add(ig);
                }
                if (cbWeb.isChecked()){
                    tampungInfo.add(web);
                }
                if (!(cbFb.isChecked()||cbIg.isChecked()||cbWeb.isChecked())){
                    Toast.makeText(MainActivity.this, "Silakan Pilih Salah Satu Infomasi Pendaftaran Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                }
                if (!(nama.trim().equals("")) && !(nomor.trim().equals("")) && (cbFb.isChecked() || cbIg.isChecked() || cbWeb.isChecked())){
                    informasi = String.join(", ",tampungInfo);

                    Intent sendIntent = new Intent(MainActivity.this, SecActivity.class);
                    sendIntent.putExtra("vNama",nama);
                    sendIntent.putExtra("vNomor",nomor);
                    sendIntent.putExtra("vInfo","Informasi Pendaftaran Dari :\n"+informasi);
                    startActivity(sendIntent);
                }
            }
        });

    }
}