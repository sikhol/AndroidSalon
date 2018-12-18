package com.kreasikode.muslimahsalon.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kreasikode.muslimahsalon.R;

public class UpdateDataPembayaranActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    Dialog myDialog;
    private EditText etDiskon;
    private Button btnBayar;
    private Button btnPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data_pembayaran);
        myDialog = new Dialog(this);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Data Pembayaran");

        btnBayar = findViewById(R.id.button_bayar);
        btnBayar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_bayar:
                Intent printLayout = new Intent(this,PrintActivity.class);
                startActivity(printLayout);
//                btnPrint = myDialog.findViewById(R.id.btnSimpan);
//                myDialog.setContentView(R.layout.activity_pop_up);
//                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                myDialog.show();
                break;
        }
    }
}
