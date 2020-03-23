package com.example.securex.controller.Exception;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class UsernameEmailValidate {

    public UsernameEmailValidate() {
    }

    public String Validate(String username, String email) {
        String validateState;

        if (isValidEmail(email) && username.length()>=6) {
            validateState="valid";
        }

        else if (username.length() < 6 && !isValidEmail(email)) {
            validateState="not valid";
        }
        else if(username.length()<6){
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
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.length()>0);
    }

}
