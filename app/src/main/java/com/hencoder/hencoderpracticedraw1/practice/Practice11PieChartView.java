package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.practice.util.DensityUtils;

import java.util.Locale;

public class Practice11PieChartView extends View {

    public static final String TAG = Practice11PieChartView.class.getSimpleName();

    private Paint paint;

    final private int attrPieSpaceAngel = 2;
    private int attrPieCurrentOffset;
    private int attrPieCurrentIndex;

    private static class Item {
        final float percent;
        final String title;
        final int color;

        float sweepAngle;

        public Item(float percent, String title, int color) {
            this.percent = percent;
            this.title = title;
            this.color = color;
        }
    }

    private Item[] items = {
            new Item(0.002f, "Froyo", Color.parseColor("#000000")),
            new Item(0.025f, "Gingerbread", Color.parseColor("#8803A0")),
            new Item(0.025f, "ICS", Color.parseColor("#8C8C8C")),
            new Item(0.20f, "JB", Color.parseColor("#0F7868")),
            new Item(0.30f, "KikKat", Color.parseColor("#1E81F0")),
            new Item(0.35f, "L", Color.parseColor("#EE2A2A")),
            new Item(0.098f, "M", Color.parseColor("#FEB50D")),
    };

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        attrPieCurrentOffset = DensityUtils.dp2px(getContext(), 6);
        attrPieCurrentIndex = items.length - 1;

        calcSweepAngle();
    }

    public Practice11PieChartView(Context context) {
        super(context);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void calcSweepAngle() {
        float totalAngel = 360 - items.length * attrPieSpaceAngel;

        for (Item item: items) {
            item.sweepAngle = item.percent * totalAngel;
        }
    }

    @TargetApi(21)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        int cx = getWidth() / 2;
        int cy = getHeight() / 2 ;
        int radius;

        if (getWidth() < getHeight()) {
            radius = (getWidth() - getPaddingLeft() - getPaddingRight() - attrPieCurrentOffset) / 2;
        } else {
            radius = (getHeight() - getPaddingTop() - getPaddingBottom() - attrPieCurrentOffset) / 2;
        }

        paint.setStyle(Paint.Style.FILL);
        float left = cx - radius;
        float top = cy - radius;
        float right = cx + radius;
        float bottom = cy + radius;

        float startAngle = 0;

        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            paint.setColor(item.color);

            Log.v(TAG, String.format(Locale.getDefault(), "angle start = %f, sweep = %f", startAngle, item.sweepAngle));
            canvas.drawArc(left, top, right, bottom,
                    startAngle, item.sweepAngle, true, paint);

            startAngle += item.sweepAngle + attrPieSpaceAngel;
        }
    }
}
