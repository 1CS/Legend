package com.game.legend.mvp.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.avos.avoscloud.AVUser;
import com.game.legend.R;
import com.game.legend.databinding.ActivityLoginBinding;
import com.game.legend.mvp.contract.LoginContract;
import com.game.legend.mvp.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity implements LoginContract.IView {
    private ActivityLoginBinding binding;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        init();
    }

    private void init() {
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        presenter = new LoginPresenter(this);
        setPresenter(presenter);
    }

    @Override
    public void onLoginSuccess(AVUser user) {
        finish();
        startActivity(MainActivity.getIntent(this));
    }

    public void onClickLogin(View view) {
        String username = binding.etUsername.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();
        presenter.login(username, password);
    }

    public void onClickRegister(View view) {
        startActivityForResult(RegisterActivity.getIntent(this), 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onClickForget(View view) {}
}
