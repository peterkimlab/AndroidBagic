package com.example.bagic;

import android.content.Context;

public class ProgressBarManager {

    private CustomProgressBar mCustomProgressDialog;
    private Context context;

    public ProgressBarManager(Context ctx) {
        context = ctx;
    }

    public void showProgress(MainActivity.CancelProgressBar listener) {

        mCustomProgressDialog = new CustomProgressBar(context);
        mCustomProgressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        mCustomProgressDialog.show();

        mCustomProgressDialog.getCancelButton().setOnClickListener(view -> listener.onEvent());
    }

    public void dismissProgress() {
        mCustomProgressDialog.dismiss();
    }

}
