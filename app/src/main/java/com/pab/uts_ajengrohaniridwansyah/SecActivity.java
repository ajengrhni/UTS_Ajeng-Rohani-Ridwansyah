package com.pab.uts_ajengrohaniridwansyah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecActivity extends AppCompatActivity {
private TextView tvNama,tvNomor,tvInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        tvNama = findViewById(R.id.tv_nama);
        tvNomor = findViewById(R.id.tv_no);
        tvInfo = findViewById(R.id.tv_info);

        Intent putIntent = getIntent();
        tvNama.setText(putIntent.getStringExtra("vNama"));
        tvNomor.setText(putIntent.getStringExtra("vNomor"));
        tvInfo.setText(putIntent.getStringExtra("vInfo"));
    }
}