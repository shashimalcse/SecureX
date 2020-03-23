package com.example.securex.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.securex.R;
import com.example.securex.controller.Exception.UsernameEmailValidate;
import com.example.securex.controller.RegistrationController;

public class RegistrationActivity extends AppCompatActivity {

    EditText EmailView;
    EditText UsernameView;
    Button SubmitView;

    String EmailValue;
    String UsernameValue;

    UsernameEmailValidate usernameEmailValidate;

    RegistrationController registrationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        EmailView = (EditText) findViewById(R.id.registrationEmail);
        UsernameView = (EditText) findViewById(R.id.registrationUsername);
        SubmitView = (Button) findViewById(R.id.registrationSubmitBtn);

        SubmitView.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          EmailValue = EmailView.getText().toString().trim();
                                          UsernameValue = UsernameView.getText().toString();

                                          usernameEmailValidate = new UsernameEmailValidate();

                                          try {
                                              String Valid = usernameEmailValidate.Validate(UsernameValue,EmailValue);

                                              switch (Valid){

                                                  case "valid":
                                                      Toast t = Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT);
                                                      t.show();
                                                      break;
                                                  case "not valid":
                                                      UsernameView.setError("Not Valid");
                                                      EmailView.setError("Not Valid");
                                                      break;
                                                  case "Username not valid":
                                                      UsernameView.setError("Not Valid");
                                                      break;
                                                  case "Email not valid":
                                                      EmailView.setError("Not Valid");
                                                      break;
                                              }
                                          }
                                          catch (Exception e){
                                              Toast t = Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT);
                                              t.show();
                                          }



                                      }
                                  }
        );

    }

    @Override
    protected void onStart() {
        super.onStart();

        registrationController = new RegistrationController(getApplicationContext());
        if(registrationController.userExists()){
            startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
        }
    }


}


