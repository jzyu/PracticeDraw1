package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.practice.util.DensityUtils;

public class Practice2DrawCircleView extends View {

    private Paint paint;

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice2DrawCircleView(Context context) {
        super(context);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        final int spacing = DensityUtils.dp2px(getContext(), 16);
        int strokeWidth = DensityUtils.dp2px(getContext(), 1);
        int radius = (getHeight() - spacing * 3) / 4;

        int cx = getWidth() / 2 - radius - spacing / 2;
        int cy = radius + strokeWidth;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(cx, cy, radius, paint);

        cx = getWidth() / 2 + radius + spacing / 2;
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(cx, cy, radius, paint);

        cx = getWidth() / 2 - radius - spacing / 2;
        cy = getHeight() / 2 + spacing / 2 + radius;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#3b78d7"));
        canvas.drawCircle(cx, cy, radius, paint);

        cx = getWidth() / 2 + radius + spacing / 2;
        radius += spacing / 3;
        paint.setStrokeWidth(DensityUtils.dp2px(getContext(), 20));
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(cx, cy, radius, paint);
    }
}
