package clwang.chunyu.me.testsvg;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.pixplicity.sharp.OnSvgElementListener;
import com.pixplicity.sharp.Sharp;
import com.pixplicity.sharp.SharpPicture;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 第三方库
 * <p/>
 * Created by wangchenlong on 16/3/7.
 */
public class OtherActivity extends AppCompatActivity {
    @Bind(R.id.other_iv_image) ImageView mIvImage;
    @Bind(R.id.other_b_change) Button mBChange;

    private Sharp mSharp; // SVG的管理类

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.bind(this);
        // 加载南方公园的卡通人物
        mSharp = Sharp.loadResource(getResources(), R.raw.cartman);
        mSharp.into(mIvImage);

        // 切换SVG的颜色
        mBChange.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                // 切换图片的颜色
                mSharp.setOnElementListener(new OnSvgElementListener() {
                    @Override
                    public void onSvgStart(@NonNull Canvas canvas, @Nullable RectF rectF) {

                    }

                    @Override public void onSvgEnd(@NonNull Canvas canvas, @Nullable RectF rectF) {

                    }

                    @Override
                    public <T> T onSvgElement(@Nullable String s, @NonNull T t, @Nullable RectF rectF, @NonNull Canvas canvas, @Nullable RectF rectF1, @Nullable Paint paint) {
                        // 变换颜色
                        if (("shirt".equals(s) || "hat".equals(s) || "pants".equals(s))) {
                            Random random = new Random();
                            if (paint != null) {
                                paint.setColor(Color.argb(255,
                                        random.nextInt(256), random.nextInt(256), random.nextInt(256)));
                            }
                        }
                        return t;
                    }

                    @Override
                    public <T> void onSvgElementDrawn(@Nullable String s, @NonNull T t, @NonNull Canvas canvas, @Nullable Paint paint) {

                    }
                });
                // 设置按钮的图标
                mSharp.getSharpPicture(new Sharp.PictureCallback() {
                    @Override public void onPictureReady(SharpPicture sharpPicture) {
                        // 设置图像
                        int size = getResources().getDimensionPixelSize(R.dimen.icon_size);
                        Drawable drawable = sharpPicture.createDrawable(mBChange, size);
                        mBChange.setCompoundDrawables(drawable, null, null, null);
                    }

                });
                mSharp.into(mIvImage);
            }
        });


    }
}