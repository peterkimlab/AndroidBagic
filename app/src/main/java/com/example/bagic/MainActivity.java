package com.example.bagic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    CustomProgressBar mCustomProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showProgress();

    }

    public void showProgress() {
        mCustomProgressDialog = new CustomProgressBar(this);
        mCustomProgressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        mCustomProgressDialog.show();
    }

}
