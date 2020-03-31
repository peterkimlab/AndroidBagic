package com.example.bagic;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;

public class CustomProgressBar extends Dialog {

    private Context mContext;
    private LottieAnimationView mAnimationView;
    private RelativeLayout mRelativeLayout;

    public CustomProgressBar(Context context) {
        super(context);
        mContext = context;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.progressbar_animation);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl_animation_background);

        final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (250 * scale + 0.5f);

        RelativeLayout relativeLayout = new RelativeLayout(mContext);
        relativeLayout.setBackground(mContext.getResources().getDrawable(R.drawable.progressbar_bg));

        RelativeLayout.LayoutParams backgroundParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        backgroundParams.width = pixels;
        backgroundParams.height = pixels + 230;
        backgroundParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        // TextView
        RelativeLayout.LayoutParams textViewParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        textViewParam.height = 120;

        TextView textView = new TextView(mContext);
        textView.setLayoutParams(textViewParam);
        textView.setText("Message");
        textView.setGravity(Gravity.BOTTOM);
        textView.setId(1);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        textView.setTextColor(Color.WHITE); // set white color for the text of Button
        //textView.setBackgroundColor(Color.parseColor("#60000000"));
        textViewParam.addRule(RelativeLayout.CENTER_HORIZONTAL);

        LottieAnimationView mAnimationView = new LottieAnimationView(mContext);

        RelativeLayout.LayoutParams lottieParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        LottieDrawable lottieDrawable = new LottieDrawable();
        LottieComposition.Factory.fromAssetFileName(mContext, "white-house.json",(composition -> {
            lottieDrawable.setComposition(composition);
            lottieDrawable.playAnimation();
            lottieDrawable.loop(true);
            lottieDrawable.setScale(0.3f);
            mAnimationView.setId(2);
            mAnimationView.setImageDrawable(lottieDrawable);
        }));

        lottieParams.addRule(RelativeLayout.BELOW, 1);
        lottieParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        // set the layout params for Button
        RelativeLayout.LayoutParams cancelButtonParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        cancelButtonParam.width = pixels - 100;

        Button cancelButton = new Button(mContext);
        cancelButton.setText("Cancel");
        cancelButton.setLayoutParams(cancelButtonParam);
        cancelButton.setTextColor(Color.WHITE);
        cancelButton.setBackgroundColor(Color.RED);
        cancelButtonParam.addRule(RelativeLayout.BELOW, 2);
        cancelButtonParam.addRule(RelativeLayout.CENTER_HORIZONTAL);

        mRelativeLayout.addView(relativeLayout, backgroundParams);
        mRelativeLayout.addView(mAnimationView, lottieParams);
        mRelativeLayout.addView(textView, textViewParam);
        mRelativeLayout.addView(cancelButton, cancelButtonParam);
    }

}
