package com.example.bagic;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.progressbar_animation);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl_animation_background);

        final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (160 * scale + 0.5f);

        RelativeLayout relativeLayout = new RelativeLayout(mContext);
        relativeLayout.setBackground(mContext.getResources().getDrawable(R.drawable.progressbar_bg));

        RelativeLayout.LayoutParams backgroundParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        backgroundParams.height = pixels;
        backgroundParams.width = pixels;
        backgroundParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        LottieAnimationView mAnimationView = new LottieAnimationView(mContext);

        RelativeLayout.LayoutParams lottieParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        LottieDrawable lottieDrawable = new LottieDrawable();
        LottieComposition.Factory.fromAssetFileName(mContext, "white-house.json",(composition -> {
            lottieDrawable.setComposition(composition);
            lottieDrawable.playAnimation();
            lottieDrawable.loop(true);
            lottieDrawable.setScale(0.35f);
            mAnimationView.setImageDrawable(lottieDrawable);
        }));

        mRelativeLayout.addView(relativeLayout, backgroundParams);
        mRelativeLayout.addView(mAnimationView, lottieParams);
    }

}
