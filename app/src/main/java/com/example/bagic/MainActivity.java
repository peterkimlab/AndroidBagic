package com.example.bagic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ProgressBarManager manager;

    public interface CancelProgressBar {
        void onEvent();
    }

    private CancelProgressBar cancelListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cancelListener = new CancelProgressBar() {
            @Override
            public void onEvent() {
                manager.dismissProgress();
            }
        };

        manager = new ProgressBarManager(this);
        manager.showProgress(cancelListener);
    }
}
