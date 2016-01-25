package com.example.john.popwindow;

import android.view.View;

/**
 * Created by JY61201 on 1/25/2016.
 */
public class ActionItem {

    String text;
    View.OnClickListener listener;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }
}
