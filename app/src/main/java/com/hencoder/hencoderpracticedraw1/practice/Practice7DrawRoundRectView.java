package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.practice.util.DensityUtils;

public class Practice7DrawRoundRectView extends View {

    private Paint paint;

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice7DrawRoundRectView(Context context) {
        super(context);
        init();
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        final float rectWidth = getWidth() / 2.6f;
        final float rectHeight = getHeight() / 3.6f;

        float left = (getWidth() - rectWidth) / 2 ;
        float top = (getHeight() - rectHeight) / 2;

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(left, top, left + rectWidth, top + rectHeight,
                DensityUtils.dp2px(getContext(), 16),
                DensityUtils.dp2px(getContext(), 16),
                paint);
    }
}
