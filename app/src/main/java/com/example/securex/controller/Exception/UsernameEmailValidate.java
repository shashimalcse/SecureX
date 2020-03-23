package com.example.securex.controller.Exception;

import android.util.Patterns;

import java.util.regex.Pattern;

public class UsernameEmailValidate {


    public UsernameEmailValidate() {
    }

    public String Validate(String username, String email) {
        String validateState;
        if (username.length() >= 6 && email.length() > 0 && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            validateState="valid";
        }
        else if(username.length()<6){
            validateState="Username not valid";
        }
        else if(email.length() > 0 && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            validateState="Email not valid";
        }
        else {
            validateState="not valid";
        }

        return validateState;
    }
    

}
