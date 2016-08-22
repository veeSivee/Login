package com.example.vi.login;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollapseActivity extends AppCompatActivity {

    @BindView(R.id.collapse_toolbar)
    CollapsingToolbarLayout collapse_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse);

        ButterKnife.bind(this);

        collapse_toolbar.setTitle("Collapse Activity");
        collapse_toolbar.setCollapsedTitleTextColor(Color.WHITE);

    }
}
