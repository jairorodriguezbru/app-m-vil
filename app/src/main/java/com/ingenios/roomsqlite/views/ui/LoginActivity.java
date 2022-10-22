package com.ingenios.roomsqlite.views.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ingenios.roomsqlite.R;
import com.ingenios.roomsqlite.databinding.ActivityLoginBinding;
import com.ingenios.roomsqlite.repository.room.dao.UsuariosDao;
import com.ingenios.roomsqlite.repository.room.database.AppDatabase;
import com.ingenios.roomsqlite.repository.room.entities.Personas;
import com.ingenios.roomsqlite.repository.room.entities.Usuarios;
import com.ingenios.roomsqlite.views.callback.LoginClickCallback;
import com.ingenios.roomsqlite.views.utils.ToastUtils;
import com.ingenios.roomsqlite.viewsmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    AppDatabase db;
    public UsuariosDao usuariosDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        binding.setViewModel(new LoginViewModel());
        binding.executePendingBindings();
        db = AppDatabase.getAppDatabase(this);
        usuariosDao = db.usuariosDao();
        ToastUtils.longToast("Usuarios creados" + usuariosDao.count());

        binding.setLogin(new LoginClickCallback() {
            @Override
            public void doLogin() {
                try {
                    usuariosDao = db.usuariosDao();
                    Usuarios usuario = usuariosDao.init(binding.inEmail.getText().toString(),binding.inPassword.getText().toString());
                    if(!usuario.getPassword().isEmpty()){
                        //2. Hacer login utilizando datos de la tabla usuarios

                        Intent intent = new Intent(LoginActivity.this,PersonasActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        ToastUtils.longToast("Datos inválidos, intente nuevamente");
                    }
                }catch (Exception e){
                    ToastUtils.longToast("A ocurrido un error, intente nuevamente");
                }

            }

            @Override
            public void goSignin() {
                Intent intent = new Intent(LoginActivity.this,RegistrarmeActivity.class);
                startActivity(intent);
            }
        });

    }
}