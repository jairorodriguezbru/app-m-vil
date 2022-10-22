package com.ingenios.roomsqlite.views.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.ingenios.roomsqlite.databinding.ActivityRegistrarmeBinding;
import com.ingenios.roomsqlite.R;
import com.ingenios.roomsqlite.views.callback.RegistrarmeClickCallback;
import com.ingenios.roomsqlite.viewsmodels.RegistrarmeViewModel;

public class RegistrarmeActivity extends AppCompatActivity {
    ActivityRegistrarmeBinding binding;
    RegistrarmeViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(RegistrarmeViewModel.class);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_registrarme);
        binding.executePendingBindings();

        binding.setLogin(new RegistrarmeClickCallback() {
            @Override
            public void doSignin() {
                viewModel.registrarme(binding);
            }

            @Override
            public void goLogin() {
                Intent intent = new Intent(RegistrarmeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}