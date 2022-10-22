package com.ingenios.roomsqlite.repository.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ingenios.roomsqlite.repository.room.entities.Personas;

import java.util.List;

@Dao
public interface PersonasDao {
    @Query("SELECT * FROM personas")
    LiveData<List<Personas>> findAll();

    @Query("SELECT * FROM personas WHERE id = :id")
    Personas findByPk(int id);

    @Query("SELECT COUNT(*) from personas")
    int count();

    @Insert()
    long insertOne(Personas persona);

    @Insert
    void insertAll(List<Personas> persona);

    @Delete
    void delete(Personas persona);

    @Update
    void update(Personas persona);
}
