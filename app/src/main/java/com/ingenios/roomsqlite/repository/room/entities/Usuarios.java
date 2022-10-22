package com.ingenios.roomsqlite.repository.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuarios", foreignKeys = {@ForeignKey(entity = Personas.class,parentColumns = "id",childColumns = "persona_id",onDelete = 1,onUpdate = 1)})

public class Usuarios {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = "id")
    int id;

    @ColumnInfo(name = "email")
    String email;

    @ColumnInfo(name = "password")
    String password;

    @ColumnInfo(index = true, name = "persona_id")
    long persona_id;

    public Usuarios() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(long persona_id) {
        this.persona_id = persona_id;
    }
}

