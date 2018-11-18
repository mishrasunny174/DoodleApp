package io.github.mishrasunny174.doodleapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class DoodleView extends TextView {

    private LinkedList<Dot> points;
    private Paint paint;
    public DoodleView(Context context){
        super((context));
        points = new LinkedList<>();
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){}
                if(motionEvent.getAction()==MotionEvent.ACTION_MOVE){
                    points.add(new Dot(motionEvent.getX(),motionEvent.getY()));
                }
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){}
                invalidate();
                return true;
            }
        });
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(Dot d : points)
            canvas.drawCircle(d.x,d.y,2,paint);
    }

}
