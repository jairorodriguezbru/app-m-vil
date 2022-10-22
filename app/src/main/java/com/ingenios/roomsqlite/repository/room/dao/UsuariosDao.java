package com.ingenios.roomsqlite.repository.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ingenios.roomsqlite.repository.room.entities.Usuarios;

import java.util.List;

@Dao
public interface UsuariosDao {
    @Query("SELECT * FROM usuarios")
    LiveData<List<Usuarios>> findAll();

    @Query("SELECT * FROM usuarios WHERE id = :id")
    Usuarios findByPk(int id);

    @Query("SELECT usuarios.id,usuarios.password FROM usuarios INNER JOIN personas WHERE usuarios.persona_id = personas.id AND personas.email = :email AND usuarios.password = :password")
    Usuarios init(String email, String password);

    @Query("SELECT COUNT(*) from usuarios")
    int count();

    @Insert
    void insertOne(Usuarios usuario);

    @Insert
    void insertAll(List<Usuarios> usuarios);

    @Delete
    void delete(Usuarios usuario);

    @Update
    void update(Usuarios usuario);
}
