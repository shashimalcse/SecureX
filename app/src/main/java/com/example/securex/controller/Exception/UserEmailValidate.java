package com.example.securex.controller.Exception;

public class UserEmailValidate {

    public UserEmailValidate() {
    }

    public String UsernameEmailValidate(String username, String email) {
        String validateState;
        if (username.length() >= 6 && email.length() > 0 && isValid(email)) {
            validateState="valid";
        }
        else if(username.length()<6){
            validateState="Username not valid";
        }
        else if(email.length() > 0 && isValid(email)){
            validateState="Email not valid";
        }
        else {
            validateState="not valid";
        }

        return validateState;
    }

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);


    }
}
