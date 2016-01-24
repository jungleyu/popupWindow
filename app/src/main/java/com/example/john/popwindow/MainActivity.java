package com.example.john.popwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private ActionPopup actionPopup;

    @Bind(R.id.action_new)
    LinearLayout actionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        actionPopup = new ActionPopup(this, actionView);
    }

    @OnClick(R.id.new_btn)
    void onNewClick() {
        actionPopup.show();
    }

}
