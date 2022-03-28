package com.example.activity_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    TextView Nama, NoHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        Nama = findViewById(R.id.tvnama);
        NoHP = findViewById(R.id.tvNomorTelepon);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");


        switch (nama){
            case "Muhammad":
                Nama.setText("Muhammad");
                NoHP.setText("082342132345");
                break;
            case "Athallariq":
                Nama.setText("Athallariq");
                NoHP.setText("082342132346");
                break;
            case "Wira":
                Nama.setText("Wira");
                NoHP.setText("082342132347");
                break;
            case "Tama":
                Nama.setText("Tama");
                NoHP.setText("082342132348");
                break;
            case "Arya":
                Nama.setText("Arya");
                NoHP.setText("082342132349");
                break;
            case "Ditya":
                Nama.setText("Aditya");
                NoHP.setText("082342132344");
                break;

        }
    }
}