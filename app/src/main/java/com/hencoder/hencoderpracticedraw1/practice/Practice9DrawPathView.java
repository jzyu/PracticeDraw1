package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.practice.util.DensityUtils;

public class Practice9DrawPathView extends View {

    private Paint paint;
    private Path path;

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        path = new Path();
    }

    public Practice9DrawPathView(Context context) {
        super(context);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        final int circleWidth = DensityUtils.dp2px(getContext(), 45);
        int left = getWidth() / 2 - circleWidth;
        int top = getHeight() / 2 - circleWidth / 2;

        path.addArc(left, top, left + circleWidth, top + circleWidth, -225, 225);
        left = getWidth() / 2;
        path.arcTo(left, top, left + circleWidth, top + circleWidth, -180, 225, false);
        path.lineTo(left, top + 2 * circleWidth);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
    }
}
