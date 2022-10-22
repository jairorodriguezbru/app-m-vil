package com.ingenios.roomsqlite.repository.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ingenios.roomsqlite.repository.room.dao.PersonasDao;
import com.ingenios.roomsqlite.repository.room.dao.UsuariosDao;
import com.ingenios.roomsqlite.repository.room.entities.Personas;
import com.ingenios.roomsqlite.repository.room.entities.Usuarios;

//Here initialise daos with respective tables
@Database(entities = {Personas.class, Usuarios.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "my_database.db";
    private static AppDatabase sInstance;

    public abstract PersonasDao personasDao();
    public abstract UsuariosDao usuariosDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return sInstance;
    }

    public static void destroyInstance() {
        sInstance = null;
    }
}
