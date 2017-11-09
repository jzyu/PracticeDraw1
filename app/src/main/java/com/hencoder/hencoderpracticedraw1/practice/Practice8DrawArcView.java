package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private Paint paint;

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public Practice8DrawArcView(Context context) {
        super(context);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        final float rectWidth = getWidth() / 3.0f;
        final float rectHeight = getHeight() / 3.0f;
        float left = (getWidth() - rectWidth) / 2 ;
        float top = (getHeight() - rectHeight) / 2;
        float right = left + rectWidth;
        float bottom = top + rectHeight;

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(left, top, right, bottom, -120, 100, true, paint); // 绘制扇形
        canvas.drawArc(left, top, right, bottom, 20, 140, false, paint);  // 绘制弧形（不连接到圆心）

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(left, top, right, bottom, -180, 45, false, paint); // 绘制弧线
    }
}
