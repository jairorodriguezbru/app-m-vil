package com.ingenios.roomsqlite.repository.room.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.ingenios.roomsqlite.repository.room.utils.Converters;

import java.util.Date;

@Entity(tableName = "personas")
public class Personas {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = "id")
    public long id;

    @ColumnInfo(name = "nombres")
    String nombres;

    @ColumnInfo(name = "apellidos")
    String apellidos;

    @ColumnInfo(name = "email")
    String email;

    @TypeConverters(Converters.class)
    @ColumnInfo(name = "fechanacimiento")
    Date fechanacimiento;

    @ColumnInfo(name = "foto")
    String foto;

    @Ignore
    String file;

    public Personas() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
