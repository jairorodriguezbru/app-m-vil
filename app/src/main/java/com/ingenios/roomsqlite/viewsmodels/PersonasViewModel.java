package com.ingenios.roomsqlite.viewsmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ingenios.roomsqlite.repository.room.dao.PersonasDao;
import com.ingenios.roomsqlite.repository.room.database.AppDatabase;
import com.ingenios.roomsqlite.repository.room.entities.Personas;

import java.util.Date;
import java.util.List;

public class PersonasViewModel extends AndroidViewModel {
    PersonasDao personasDao;
    AppDatabase db;
    public PersonasViewModel(Application application) {
        super(application);
        db = AppDatabase.getAppDatabase(application);
        personasDao = db.personasDao();
    }

    public void insertDummyPersonas() {
        //List<Usuarios> usersList = new ArrayList<>();
        //for (int i = 0; i < 5; i++) {
        Personas persona = new Personas();
        persona.setNombres("Jose Luis");
        persona.setApellidos("Gomez Liñan");
        Date fecha = new Date("12/04/87");
        persona.setFechanacimiento(fecha);
        persona.setFoto("");
        //  usersList.add(usuarios);
        //}
        personasDao.insertOne(persona);
    }

    public int count(){
        int total = personasDao.count();
        return total;
    }

    public Personas findByPk(int id) {

        return personasDao.findByPk(id);
    }

    public LiveData<List<Personas>> findAll() {
        return personasDao.findAll();
    }

}
