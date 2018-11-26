package com.tournals.tournals;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SubRencanaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_rencana);
        Toolbar toolbar = (Toolbar) findViewById(R.id.subRencanaToolbar);
        TextView tvToolbar = (TextView) findViewById(R.id.subRencanaTitle);
        ImageView ivBack = (ImageView) findViewById(R.id.subRencanaBack);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tvToolbar.setText(getIntent().getStringExtra("NamaRencana"));
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
