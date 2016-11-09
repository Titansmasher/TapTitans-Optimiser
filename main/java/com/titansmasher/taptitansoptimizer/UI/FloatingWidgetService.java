package com.titansmasher.taptitansoptimizer.UI;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.v4.content.ContextCompat;
import android.view.*;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.Date;

/**
 * Created by Danny on 28/10/2016.
 */

public class FloatingWidgetService extends Service {
    private WindowManager windowManager;
    private ImageButton close;
    private LinearLayout layout;
    private WindowManager.LayoutParams params;
    private static View view;
    private static int X = 16;
    private static int Y = 16;

    @Override
    public void onCreate(){
        generateWidget();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (view != null)
            windowManager.removeView(layout);
    }

    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    private void generateWidget(){
        if (view == null){
            stopService(new Intent(getApplication(), FloatingWidgetService.class));
            return;
        }
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        layout = new LinearLayout(this);

        close = new ImageButton(this);
        close.setBackgroundDrawable(ContextCompat.getDrawable(this, android.R.drawable.ic_menu_close_clear_cancel));
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplication(), FloatingWidgetService.class));
            }
        });

        params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = X;
        params.y = Y;

        final View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;
            private boolean moving;
            private boolean closing;
            private Date initialTime;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (closing)
                    return false;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        initialTime = new Date();
                        break;
                    case MotionEvent.ACTION_UP:
                        moving = false;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (!moving){
                            double absDistance = Math.pow(Math.abs(Math.pow(initialTouchX - event.getRawX(), 2) + (initialTouchY - event.getRawY())), 0.5);
                            moving = absDistance > 2;
                        }
                        if (moving) {
                            X = initialX
                                    + (int) (event.getRawX() - initialTouchX);
                            Y = initialY
                                    + (int) (event.getRawY() - initialTouchY);
                            params.x = X;
                            params.y = Y;
                            windowManager.updateViewLayout(layout, params);
                            break;
                        } else {
                            if (initialTime.getTime() + ViewConfiguration.getLongPressTimeout() < new Date().getTime()){
                                closing = true;
                                stopService(new Intent(getApplication(), FloatingWidgetService.class));
                                return true;
                            }
                        }
                }
                return false;
            }
        };
        layout.setOnTouchListener(onTouchListener);
        view.setOnTouchListener(onTouchListener);

        layout.addView(view);
        layout.addView(close);

        windowManager.addView(layout, params);
    }

    public static void setContent(View view){
        FloatingWidgetService.view = view;
    }
}
