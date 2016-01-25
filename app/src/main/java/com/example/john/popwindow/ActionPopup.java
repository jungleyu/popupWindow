package com.example.john.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.List;

/**
 * Created by John on 2016/1/24.
 */
public class ActionPopup extends PopupWindow {

    private Context context;
    private View actionView;

    private LinearLayout contentView;
    private List<View> actionItems;
    private boolean isLandscape;


    public ActionPopup(Context context, View actionView, List<View> actionItems) {
        this.context = context;
        this.actionView = actionView;
        this.actionItems = actionItems;
        initActionPopup();
    }

    private void initActionPopup() {
        contentView = new LinearLayout(context);
        contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        contentView.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < actionItems.size(); i++) {
            contentView.addView(actionItems.get(i));
        }
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        this.setContentView(contentView);
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

    private void updatePopWindow2Show() {
        int screenHeight, screenWidth, height;
        int yOffset = 0;
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        screenHeight = dm.heightPixels;
        screenWidth = dm.widthPixels;
        if (screenHeight > screenWidth) {
            isLandscape = false;
        } else {
            isLandscape = true;
        }
        height = contentView.getMeasuredHeight();
        if (!isLandscape) {
            yOffset = 0 - height - actionView.getHeight();
            this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            this.update();
        }
        this.showAsDropDown(actionView, 0, yOffset);
    }

    public void show() {
        if (this.isShowing()) {
            Log.d("Popup window", "Dismiss");
            this.dismiss();
            return;
        }
        updatePopWindow2Show();
    }
}
