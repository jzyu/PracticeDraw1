package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.practice.util.DensityUtils;

public class Practice6DrawLineView extends View {

    private Paint paint;

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice6DrawLineView(Context context) {
        super(context);
        init();
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线
        final int rectWidth = getWidth() / 3;
        final int rectHeight = getHeight() / 3;

        int startX = (getWidth() - rectWidth) / 2;
        int startY = (getHeight() - rectHeight) / 2;

        paint.setStrokeWidth(DensityUtils.dp2px(getContext(), 4));
        paint.setColor(Color.BLACK);
        canvas.drawLine(startX, startY, startX + rectWidth, startY + rectHeight, paint);
    }
}
