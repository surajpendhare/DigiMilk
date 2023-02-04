package com.app.digimilk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button configBtn, addMilkBtn, demandOrderBtn, collectionDataBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configBtn = findViewById(R.id.idBtnConfig);
        addMilkBtn = findViewById(R.id.idBtnAddMilk);
        demandOrderBtn = findViewById(R.id.idBtnDemandOrder);
        collectionDataBtn = findViewById(R.id.idBtnCollectionData);

        configBtn.setOnClickListener(onClickListener);
        addMilkBtn.setOnClickListener(onClickListener);
        demandOrderBtn.setOnClickListener(onClickListener);
        collectionDataBtn.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.idBtnConfig:
                    Toast.makeText(MainActivity.this, "Configuration", Toast.LENGTH_SHORT).show();
                    //DO something
                    break;
                case R.id.idBtnAddMilk:
                    Toast.makeText(MainActivity.this, "Add Milk Collection", Toast.LENGTH_SHORT).show();
                    //DO something
                    break;
                case R.id.idBtnDemandOrder:
                    Toast.makeText(MainActivity.this, "Place demand Order", Toast.LENGTH_SHORT).show();
                    //DO something
                    break;
                case R.id.idBtnCollectionData:
                    Toast.makeText(MainActivity.this, "Display Collection Data", Toast.LENGTH_SHORT).show();
                    //DO something
                    break;
            }

        }
    };

}
