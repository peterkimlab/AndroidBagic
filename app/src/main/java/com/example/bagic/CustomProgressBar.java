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

    private Context context;
    private RelativeLayout mRelativeLayout;
    public Button cancelButton;

    public CustomProgressBar(Context ctx) {
        super(ctx);
        context = ctx;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.progressbar_animation);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl_animation_background);

        final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (250 * scale + 0.5f);

        /* Dialog의 background를 relativelayout으로 구성 */
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackground(context.getResources().getDrawable(R.drawable.progressbar_bg));

        RelativeLayout.LayoutParams backgroundParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        backgroundParams.width = pixels;
        backgroundParams.height = pixels + 230;
        backgroundParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);

        /* Dialog 상단의 text 메세지 구성 */
        RelativeLayout.LayoutParams textViewParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        textViewParam.height = 120;

        TextView textView = new TextView(context);
        textView.setLayoutParams(textViewParam);
        textView.setText("Message");
        textView.setGravity(Gravity.BOTTOM);
        textView.setId(1);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        textView.setTextColor(Color.WHITE);
        textViewParam.addRule(RelativeLayout.CENTER_HORIZONTAL);

        /* Dialog 중앙의 LottieAnimation 구성 */
        LottieAnimationView mAnimationView = new LottieAnimationView(context);

        RelativeLayout.LayoutParams lottieParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        LottieDrawable lottieDrawable = new LottieDrawable();
        LottieComposition.Factory.fromAssetFileName(context, "white-house.json",(composition -> {
            lottieDrawable.setComposition(composition);
            lottieDrawable.playAnimation();
            lottieDrawable.loop(true);
            lottieDrawable.setScale(0.3f);
            mAnimationView.setId(2);
            mAnimationView.setImageDrawable(lottieDrawable);
        }));

        lottieParams.addRule(RelativeLayout.BELOW, 1);
        lottieParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        /* Dialog 하단의 Button 구성 */
        RelativeLayout.LayoutParams cancelButtonParam = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        cancelButtonParam.width = pixels - 100;

        cancelButton = new Button(context);
        cancelButton.setText("Cancel");
        cancelButton.setLayoutParams(cancelButtonParam);
        cancelButton.setTextColor(Color.WHITE);
        cancelButton.setBackground(context.getResources().getDrawable(R.drawable.orange_button_bg));
        cancelButtonParam.addRule(RelativeLayout.BELOW, 2);
        cancelButtonParam.addRule(RelativeLayout.CENTER_HORIZONTAL);

        /* xml에 있는 relativelayout에 programmatically 구성한 component를 addView */
        mRelativeLayout.addView(relativeLayout, backgroundParams);
        mRelativeLayout.addView(mAnimationView, lottieParams);
        mRelativeLayout.addView(textView, textViewParam);
        mRelativeLayout.addView(cancelButton, cancelButtonParam);
    }

    public Button getCancelButton() {
        return cancelButton;
    }

}
