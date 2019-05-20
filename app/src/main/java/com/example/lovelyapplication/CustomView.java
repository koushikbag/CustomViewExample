package com.example.lovelyapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {
    //circle and text colors
    private int circleCol;
    private int labelCol;
    //label text
    private String circleText;
    //paint for drawing custom view
    private Paint circlePaint;


    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //paint object for drawing in onDraw
        circlePaint = new Paint();

        //get the attributes specified in attrs.xml using the name we included
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomView,
                0, 0);

        try {
            circleText = array.getString(R.styleable.CustomView_circleLabel);
            circleCol = array.getInteger(R.styleable.CustomView_circleColor, 0);
            labelCol = array.getInteger(R.styleable.CustomView_labelColor, 0);
        } finally {
            array.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidthHalf = this.getMeasuredWidth() / 2;
        int viewHeightHalf = this.getMeasuredHeight() / 2;

        int radius = 0;
        if (viewHeightHalf > viewWidthHalf) {
            radius = viewWidthHalf - 10;
        } else {
            radius = viewHeightHalf - 10;
        }

        circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(circleCol);

        canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint);

        // draw the text
        circlePaint.setColor(labelCol);

        //set text properties
        circlePaint.setTextAlign(Paint.Align.CENTER);
        circlePaint.setTextSize(50);

        canvas.drawText(circleText, viewWidthHalf, viewHeightHalf, circlePaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public int getCircleColor() {
        return circleCol;
    }

    public int getLabelColor() {
        return labelCol;
    }

    public String getLabelText() {
        return circleText;
    }

    public void setCircleColor(int circleCol) {
        //update the instance variable
        this.circleCol = circleCol;
        //redraw the view
        invalidate();
        requestLayout();
    }

    public void setLabelColor(int labelCol) {
        //update the instance variable
        this.labelCol = labelCol;
        //redraw the view
        invalidate();
        requestLayout();
    }

    public void setLabelText(String circleText) {
        this.circleText = circleText;
        invalidate();
        requestLayout();
    }
}
