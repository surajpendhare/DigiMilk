package com.app.digimilk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginScreen extends AppCompatActivity {
    private static final String SHARED_PREF_NAME = "mysharedpref";
    private static final String USERNAME = "username";
    private EditText userNameEdt, passwordEdt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        userNameEdt = findViewById(R.id.idEdtUserName);
        passwordEdt = findViewById(R.id.idEdtPassword);
        loginBtn = findViewById(R.id.idBtnLogin);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = userNameEdt.getText().toString();
                String password = passwordEdt.getText().toString();

                SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                if (TextUtils.isEmpty(userName.trim()) || TextUtils.isEmpty(password.trim())) {
                    Toast.makeText(LoginScreen.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();
                }else{
                    editor.putString(USERNAME, userName);
                    editor.apply();

                    Toast.makeText(LoginScreen.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginScreen.this, MainActivity.class);
                    i.putExtra("username", userName);
                    startActivity(i);
                    finish();

                }

                // calling a method to login our user.
//                loginUser(userName, password);
            }
        });
    }

//    private void loginUser(String userName, String password) {
//        // calling a method to login a user.
//        ParseUser.logInInBackground(userName, password, (parseUser, e) -> {
//            // after login checking if the user is null or not.
//            if (parseUser != null) {
//                // if the user is not null then we will display a toast message
//                // with user login and passing that user to new activity.
//                Toast.makeText(this, "Login Successful ", Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(LoginScreen.this, MainActivity.class);
//                i.putExtra("username", userName);
//                startActivity(i);
//            } else {
//                // display a toast message when user logout of the app.
//                ParseUser.logOut();
//                Toast.makeText(LoginScreen.this, 'Logout success', Toast.LENGTH_LONG).show();
//            }
//        });
//    }
}