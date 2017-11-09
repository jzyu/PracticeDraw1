package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.practice.util.DensityUtils;

public class Practice5DrawOvalView extends View {

    private Paint paint;

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice5DrawOvalView(Context context) {
        super(context);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        final int rectWidth = getWidth() / 3;
        final int rectHeight = getHeight() / 4;

        int left = (getWidth() - rectWidth) / 2 ;
        int top = (getHeight() - rectHeight) / 2;

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(DensityUtils.dp2px(getContext(), 10));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawOval(left, top, left + rectWidth, top + rectHeight, paint);
    }
}
