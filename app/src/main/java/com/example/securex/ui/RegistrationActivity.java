package com.example.securex.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.securex.R;
import com.example.securex.controller.Exception.UsernameEmailValidate;

public class RegistrationActivity extends AppCompatActivity {

    EditText EmailView;
    EditText UsernameView;
    Button SubmitView;

    String EmailValue;
    String UsernameValue;

    UsernameEmailValidate usernameEmailValidate;

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

                                          EmailValue = EmailView.getText().toString();
                                          UsernameValue = UsernameView.getText().toString();

                                          usernameEmailValidate = new UsernameEmailValidate();
                                          try {
                                              String Valid = usernameEmailValidate.Validate(EmailValue,UsernameValue);
                                              if(Valid.equals("valid")){
                                                  Toast t = Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT);
                                                  t.show();
                                              }
                                              else if(Valid.equals("not valid")) {
                                                  UsernameView.setError("Not Valid");
                                                  EmailView.setError("Not Valid");
                                              }
                                              else if (Valid.equals("Username not valid")){
                                                  UsernameView.setError("Not Valid");
                                              }
                                              else if (Valid.equals("Email not valid")){
                                                  EmailView.setError("Not Valid");
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
    }


}


