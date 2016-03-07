package clwang.chunyu.me.testsvg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 跳转三个模块: SVG图片, SVG动画, Sharp库
 * <p/>
 * Created by wangchenlong on 16/3/6.
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_b_image) Button mBImage;
    @Bind(R.id.main_b_animation) Button mBAnimation;
    @Bind(R.id.main_b_sharp) Button mBSharp;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // 图像
        mBImage.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImageActivity.class));
            }
        });

        // 动画
        mBAnimation.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AnimationActivity.class));
            }
        });

        // 第三方库
        mBSharp.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OtherActivity.class));
            }
        });
    }
}
