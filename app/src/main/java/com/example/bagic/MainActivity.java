package com.example.bagic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CustomProgressBar mCustomProgressDialog;
    public interface CancelProgressBar {
        void onEvent();
    }

    private CancelProgressBar cancelProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showProgress();

        cancelProgressBar = new CancelProgressBar() {
            @Override
            public void onEvent() {
                mCustomProgressDialog.dismiss();
            }
        };
    }

    public void showProgress() {
        mCustomProgressDialog = new CustomProgressBar(this, cancelProgressBar);
        mCustomProgressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        mCustomProgressDialog.show();

        mCustomProgressDialog.getCancelButton().setOnClickListener(click -> cancelProgressBar.onEvent());
    }

}
