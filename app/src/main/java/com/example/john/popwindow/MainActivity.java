package com.example.john.popwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private BaseCommonPopup newPopup;
//    private ActionPopup openPopup;

    @Bind(R.id.action_new)
    LinearLayout actionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<ActionItem> newItems = new ArrayList<>();
        ActionItem n1 = new ActionItem();
        n1.setText("New Series");
        ActionItem n2 = new ActionItem();
        n2.setText("New Curve");
        newItems.add(n1);
        newItems.add(n2);

        ActionItem ai = new ActionItem();
        ai.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
//        newPopup = new BaseCommonPopup(this, actionView, newItems,ai.getListener());


//        List<View> newItems = generateNewActionItems();
//        newPopup = new ActionPopup(this, actionView, newItems);
//
//        List<View> openItems = new ArrayList<View>();
//        View openCurve = genenrateActionItem("Open Curve", new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Listener", "Open Curve");
//            }
//        });
//        View openSeries = genenrateActionItem("Open Series", new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Listener", "Open Series");
//            }
//        });
//        openItems.add(openCurve);
//        openItems.add(openSeries);
//        openPopup = new ActionPopup(this, actionView, openItems);
    }

//    private List<View> generateNewActionItems() {
//        List<View> newItems = new ArrayList<View>();
//        View newCurve = genenrateActionItem("New Curve", new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Listener", "New Curve");
//            }
//        });
//        View newSeries = genenrateActionItem("New Series", new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Listener", "New Series");
//            }
//        });
//        newItems.add(newCurve);
//        newItems.add(newSeries);
//        return newItems;
//    }
//
//    private View genenrateActionItem(String name, View.OnClickListener listener) {
//        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        View itemView = inflater.inflate(R.layout.action_item_layout, null, false);
//        Button actionBtn = (Button) itemView.findViewById(R.id.action_btn);
//        actionBtn.setText(name);
//        actionBtn.setOnClickListener(listener);
//        return itemView;
//    }

    @OnClick(R.id.new_btn)
    void onNewClick() {
        newPopup.show();
    }

    @OnClick(R.id.open_btn)
    void onOpenClick() {
//        openPopup.show();
    }

}
