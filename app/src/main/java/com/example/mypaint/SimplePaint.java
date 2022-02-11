package com.example.mypaint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimplePaint extends View {

    List<Paint> myPaintList;
    List<Path> myPathList;
    Paint currentPaint;
    Path currentPath;
    ColorDrawable currentColor;
    boolean desenhaCirculo;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        myPaintList = new ArrayList<Paint>();
        myPathList = new ArrayList<Path>();
        currentColor = new ColorDrawable();
        desenhaCirculo = false;
        currentColor.setColor(Color.BLACK);
        initLayerDraw();
    }
    public void initLayerDraw(){
        currentPaint = new Paint();
        currentPath = new Path();
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeWidth(20);
        currentPaint.setColor(currentColor.getColor());

    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        for(int i = 0; i < myPaintList.size(); i++) {
            canvas.drawPath(myPathList.get(i), myPaintList.get(i));
        }
        canvas.drawPath(currentPath, currentPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        float ly, lx;
        lx = event.getX();
        ly = event.getY();

        if(!desenhaCirculo){
            switch (event.getAction()) {
                case (MotionEvent.ACTION_DOWN):
                    currentPath.moveTo(lx, ly);
                    currentPath.lineTo(lx, ly);
                    break;
                case (MotionEvent.ACTION_MOVE):
                    currentPath.lineTo(lx, ly);
                    break;
                case (MotionEvent.ACTION_UP):
                    currentPath.lineTo(lx, ly);
                    myPaintList.add(currentPaint);
                    myPathList.add(currentPath);
                    initLayerDraw();
                    break;
                default:
                  break;
        }
    }else
    {
        currentPath.addCircle(lx, ly, 50, Path.Direction.CCW);
        myPaintList.add(currentPaint);
        myPathList.add(currentPath);
        initLayerDraw();
    }
    invalidate();
    return true;
    }

    public void setColor(Color color) {
        currentColor.setColor(color.toArgb());
        currentPaint.setColor(color.toArgb());
    }
}
