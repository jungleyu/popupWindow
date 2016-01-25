package com.example.john.popwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.List;

/**
 * Created by JY61201 on 1/25/2016.
 */
public class BasePopup<T extends BasePopup.BasePopupItem> {

    private Context context;
    private View anchor;
    private LinearLayout contentView;
    private List<T> actionItems;
    private boolean isTablet;

    private PopupWindow popupWindow;
    private BasePopupItemClickListener listener;

    public BasePopup(Context context, View anchor, List<T> actionItems, BasePopupItemClickListener listener) {
        this.context = context;
        this.anchor = anchor;
        this.actionItems = actionItems;
        this.listener = listener;

        popupWindow = new PopupWindow(context);
        initBasePopup();
    }

    private void initBasePopup() {
        contentView = new LinearLayout(context);
        contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        contentView.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < actionItems.size(); i++) {
            T t = actionItems.get(i);
            if (t != null) {
                contentView.addView(genenrateActionItem(t));
            }
        }
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popupWindow.setContentView(contentView);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.update();
        ColorDrawable dw = new ColorDrawable(0000000000);
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });
    }

    private View genenrateActionItem(final T t) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.action_item_layout, null, false);
        Button actionBtn = (Button) itemView.findViewById(R.id.action_btn);
        actionBtn.setText(t.getText());
        actionBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(t);
                }
                dismiss();
            }
        });
        return itemView;
    }

    public void show() {
        popupWindow.showAsDropDown(anchor);
    }

    public void dismiss() {
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

    public interface BasePopupItem {
        String getText();
    }

    public interface BasePopupItemClickListener<T extends BasePopupItem> {
        void onClick(T t);
    }
}
