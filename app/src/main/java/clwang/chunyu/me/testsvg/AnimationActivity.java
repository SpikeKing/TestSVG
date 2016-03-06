package clwang.chunyu.me.testsvg;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * SVG动画
 */
public class AnimationActivity extends AppCompatActivity {

    @Bind(R.id.main_iv_image_view) ImageView mIvImageView;
    @Bind(R.id.main_b_draw) Button mBDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);

        animateImage(); // 动画播放图片

        // 重绘动画
        mBDraw.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                animateImage();
            }
        });
    }

    // 只支持5.0以上.
    private void animateImage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 获取动画效果
            AnimatedVectorDrawable mAnimatedVectorDrawable = (AnimatedVectorDrawable)
                    ContextCompat.getDrawable(getApplication(), R.drawable.v_heard_animation);
            mIvImageView.setImageDrawable(mAnimatedVectorDrawable);
            if (mAnimatedVectorDrawable != null) {
                mAnimatedVectorDrawable.start();
            }
        }
    }
}
