package com.game.legend.mvp.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.avos.avoscloud.AVUser;
import com.game.legend.R;
import com.game.legend.databinding.ActivityRegisterBinding;
import com.game.legend.mvp.contract.RegisterContract;
import com.game.legend.mvp.presenter.RegisterPresenter;

public class RegisterActivity extends BaseActivity implements RegisterContract.IView {
    private ActivityRegisterBinding binding;
    private RegisterPresenter presenter;

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        init();
    }

    private void init() {
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.register);
        }
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        presenter = new RegisterPresenter(this);
        setPresenter(presenter);
    }

    public void onClickRegister(View view) {
        String email = binding.etUsername.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();
        presenter.register(email,password);
    }

    @Override
    public void onRegisterSuccess(AVUser user) {

    }
}
