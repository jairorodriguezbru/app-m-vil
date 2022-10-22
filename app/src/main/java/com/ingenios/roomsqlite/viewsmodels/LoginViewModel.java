package com.ingenios.roomsqlite.viewsmodels;

import android.text.TextUtils;
import android.util.Patterns;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.ingenios.roomsqlite.repository.room.entities.Usuarios;

public class LoginViewModel extends BaseObservable {
    public Usuarios usuarios;

    // getter and setter methods
    // for email variable
    @Bindable
    public String getUserEmail() {
        return usuarios.getEmail();
    }

    public void setUserEmail(String email) {
        usuarios.setEmail(email);
        //notifyPropertyChanged(BR.userEmail);
    }

    // getter and setter methods
    // for password variable
    @Bindable
    public String getUserPassword() {
        return usuarios.getPassword();
    }

    public void setUserPassword(String password) {
        usuarios.setPassword(password);
        //notifyPropertyChanged(BR.userPassword);
    }

    // constructor of ViewModel class
    public LoginViewModel() {
        // instantiating object of
        // model class
        usuarios = new Usuarios();
    }


    // method to keep a check
    // that variable fields must
    // not be kept empty by user
    public boolean isValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 5;
    }
}

