package com.example.securex.controller.Exception;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class UsernameEmailValidate {

    private final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";

    public UsernameEmailValidate() {
    }

    public String Validate(String username, String email) {
        String validateState;

        if (isValidEmail(email) && isvalidusername(username)) {
            validateState="valid";
        }

        else if (!isvalidusername(username) && !isValidEmail(email)) {
            validateState="not valid";
        }
        else if(!isvalidusername(username)){
            validateState="Username not valid";
        }
        else if(!isValidEmail(email)){
            validateState="Email not valid";
        }
        else {
            validateState="not valid";
        }

        return validateState;
    }


    public boolean isValidEmail(String email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.length()>0);
    }
    public boolean isvalidusername(String username){
        return (username.matches(USERNAME_PATTERN) && username.length()>=6);
    }

}
