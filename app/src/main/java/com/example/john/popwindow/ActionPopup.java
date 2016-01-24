package com.example.john.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by John on 2016/1/24.
 */
public class ActionPopup extends PopupWindow {

    private Context context;
    private View actionView;
    private PopupWindow popupWindow;

    private View contentView;
    private boolean isLandscape;


    public ActionPopup(Context context, View actionView) {
        this.context = context;
        this.actionView = actionView;
        initActionPopup();
    }

    private void initActionPopup() {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int h = dm.heightPixels;
        int w = dm.widthPixels;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View childView = inflater.inflate(R.layout.action_layout, null, false);
        this.setContentView(childView);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.update();
        ColorDrawable dw = new ColorDrawable(0000000000);
        this.setBackgroundDrawable(dw);
        this.setOutsideTouchable(true);
        this.setTouchable(true);

        this.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    ActionPopup.this.dismiss();
                    return true;
                }
                return false;
            }
        });
    }

    private void resizePopWindow2Show() {
        int screenHeight, screenWidth;
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        screenHeight = dm.heightPixels;
        screenWidth = dm.widthPixels;
        if (screenHeight > screenWidth) {
            isLandscape = false;
        } else {
            isLandscape = true;
        }
        if (!isLandscape) {
            this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            this.update();
        } else {
            this.showAsDropDown(actionView, 0, -410);
            return;
        }
        this.showAsDropDown(actionView);
    }

    public void show() {
        if (this.isShowing()) {
            Log.d("Popup window", "Dismiss");
            this.dismiss();
            return;
        }
        resizePopWindow2Show();
    }
}
