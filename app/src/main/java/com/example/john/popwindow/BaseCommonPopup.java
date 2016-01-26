package com.example.john.popwindow;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * Created by JY61201 on 1/25/2016.
 */
public class BaseCommonPopup<BaseCommomPopupItem> extends BasePopup {

    public BaseCommonPopup(Context context, View anchor, List<BaseCommomPopupItem> actionItems, BasePopupItemClickListener listener) {
        super(context, anchor, actionItems, listener);
    }

    public class BaseCommomPopupItem implements BasePopupItem {
        private String text;

        public BaseCommomPopupItem(String text) {
            this.text = text;
        }

        @Override
        public String getText() {
            return text;
        }
    }

}
