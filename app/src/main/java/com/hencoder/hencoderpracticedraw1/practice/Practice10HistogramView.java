package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.practice.util.DensityUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Practice10HistogramView extends View {

    public static final int COLOR_LINE = Color.WHITE;
    public static final int COLOR_FILL = Color.parseColor("#61AF12");

    private Paint paint;
    private TextPaint textPaint;
    private float factorStretch;

    private int attrLineWidth;
    private int attrColumnSpace;
    private int attrFontSize;
    private int attrColumnPaddingTop;

    private static class Column {
        float percent;
        String title;

        public Column(float percent, String title) {
            this.percent = percent;
            this.title = title;
        }
    }

    private Column[] columns = {
            new Column(0.002f, "Froyo"),
            new Column(0.025f, "GB"),
            new Column(0.025f, "ICS"),
            new Column(0.20f, "JB"),
            new Column(0.30f, "KikKat"),
            new Column(0.35f, "L"),
            new Column(0.098f, "M"),
    };

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        factorStretch =  1 / getMaxPercent();

        attrLineWidth = DensityUtils.dp2px(getContext(), 0.5f);
        attrColumnSpace = DensityUtils.dp2px(getContext(), 6);
        attrFontSize = DensityUtils.sp2px(getContext(), 9);
        attrColumnPaddingTop = DensityUtils.dp2px(getContext(), 8);

        textPaint.setTextSize(attrFontSize);
    }

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private float getMaxPercent() {
        List<Column> list = new ArrayList<>();
        list.addAll(Arrays.asList(columns));

        Collections.sort(list, new Comparator<Column>() {
            @Override
            public int compare(Column o1, Column o2) {
                float value = o2.percent - o1.percent;

                if (value > 0)
                    return -1;
                else if (value == 0)
                    return 0;
                else
                    return 1;
            }
        });

        return list.get(list.size() - 1).percent;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        // draw coordinate
        float startX = getPaddingLeft();
        float startY = getPaddingTop();
        float endX = startX;
        float endY = getHeight() - getPaddingBottom() - attrFontSize;

        final float COLUMN_MAX_HEIGHT = endY - startY - attrColumnPaddingTop;

        paint.setColor(COLOR_LINE);
        paint.setStrokeWidth(attrLineWidth);
        canvas.drawLine(startX, startY, endX, endY, paint);

        startY = endY;
        endX = getWidth() - getPaddingRight() - attrColumnSpace;
        final float COLUMN_WIDTH = (endX - startX - attrColumnSpace) / columns.length - attrColumnSpace;
        canvas.drawLine(startX, startY, endX, endY, paint);

        // draw column and text
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(COLOR_FILL);
        textPaint.setColor(COLOR_LINE);

        for (int i = 0; i < columns.length; i++) {
            Column column= columns[i];

            float left = startX + attrColumnSpace + i * (COLUMN_WIDTH + attrColumnSpace);
            float bottom = startY;
            float height = factorStretch * (column.percent * COLUMN_MAX_HEIGHT);
            canvas.drawRect(
                    left,
                    bottom - height,
                    left + COLUMN_WIDTH,
                    bottom,
                    paint);

            StaticLayout staticLayout = new StaticLayout(column.title, textPaint, (int) COLUMN_WIDTH,
                    Layout.Alignment.ALIGN_CENTER, 0, 0, false);
            canvas.save();
            canvas.translate(left, startY);
            staticLayout.draw(canvas);
            canvas.restore();
        }
    }
}
