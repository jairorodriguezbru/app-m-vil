package com.ingenios.roomsqlite.viewsmodels;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;

import com.ingenios.roomsqlite.databinding.ActivityRegistrarmeBinding;
import com.ingenios.roomsqlite.repository.room.dao.PersonasDao;
import com.ingenios.roomsqlite.repository.room.dao.UsuariosDao;
import com.ingenios.roomsqlite.repository.room.database.AppDatabase;
import com.ingenios.roomsqlite.repository.room.entities.Personas;
import com.ingenios.roomsqlite.repository.room.entities.Usuarios;
import com.ingenios.roomsqlite.views.utils.ToastUtils;

import java.util.Date;

public class RegistrarmeViewModel extends AndroidViewModel {
    AppDatabase db;
    public Usuarios usuarios;
    public Personas personas;
    public PersonasDao personasDao;
    public UsuariosDao usuariosDao;

    public RegistrarmeViewModel(Application application) {
        super(application);
        db = AppDatabase.getAppDatabase(application);
        usuarios = new Usuarios();
        personas = new Personas();
        personasDao = db.personasDao();
        usuariosDao = db.usuariosDao();
    }

    public void registrarme(ActivityRegistrarmeBinding binding) {
        Personas persona = new Personas();
        persona.setNombres(binding.inNombres.getText().toString());
        persona.setApellidos(binding.inApellidos.getText().toString());
        Date fecha = new Date("12/04/87");
        persona.setFechanacimiento(fecha);
        persona.setFoto("");
        long id = personasDao.insertOne(persona);
        Usuarios usuario = new Usuarios();
        usuario.setEmail(binding.inEmail.getText().toString());
        //1. Encriptar setPassword
        usuario.setPassword(binding.inPassword.getText().toString());
        usuario.setPersona_id(id);
        usuariosDao.insertOne(usuario);
        ToastUtils.longToast("Registro agregado exitosamente");
    }

}
