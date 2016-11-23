package com.game.legend.mvp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.game.legend.R;

public class MainActivity extends BaseActivity {
    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
