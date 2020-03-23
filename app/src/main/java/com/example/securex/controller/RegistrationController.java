package com.example.securex.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.securex.data.User;

public class RegistrationController {

    private String Username;
    private String Email;
    private String Color;
    private int Pin;
    private String Password;
    private int PasswordSize;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;
    private User user;

    public RegistrationController(Context context) {
        this.context = context;
        pref = context.getSharedPreferences("com.android.app.users", Context.MODE_PRIVATE);
        editor = pref.edit();
    }


    public void createUser(User user) {
        Username = user.getUsername();
        Email = user.getEmail();
        Color = user.getColor();
        Pin = user.getPin();
        Password = user.getPassword();
        PasswordSize = user.getPasswordSize();
        try {
            editor.putString("Username", Username);
            editor.putString("Email", Email);
            editor.putString("Color", Color);
            editor.putInt("Pin", Pin);
            editor.putString("Password", Password);
            editor.putInt("PasswordSize", PasswordSize);

            editor.apply();
        } catch (Exception e) {
            e.printStackTrace(); // throw better exception
        }


    }

    public User getUser() {

        try {
            Username = pref.getString("Username", null);
            Email = pref.getString("Email", null);
            Color = pref.getString("Color", null);
            Password = pref.getString("Password", null);
            Pin = pref.getInt("Pin", -1);
            PasswordSize = pref.getInt("PasswordSize", -1);

            if (Username == null || Email == null || Color == null || Password == null || Pin == -1 || PasswordSize == -1) {
                throw new Exception(); // throw better exception
            } else {
                user = new User(Username, Email, Color, Pin, Password, PasswordSize);

            }

        } catch (Exception e) {
            e.printStackTrace(); // throw better exception
        }

        return user;
    }


}