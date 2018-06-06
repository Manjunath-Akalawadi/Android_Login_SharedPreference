package com.example.manju7.android_login_sharedpreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
    EditText username,password;
    Button button;
    SharedPreferences sp;
    public View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        button=(Button) findViewById(R.id.login);

        sp=getSharedPreferences("login",MODE_PRIVATE);
        String str=username.getText().toString();
        if(sp.contains("username") && sp.contains("password")){
            finish();   //finish current activity

            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra("message", str);
            startActivity(intent);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCheck();
            }
        });




    }

    void loginCheck(){
        if(username.getText().toString().equals("manju") && password.getText().toString().equals("manju")){
            SharedPreferences.Editor e=sp.edit();
            e.putString("username","manju");
            e.putString("password","manju");
            e.commit();

            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();

            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();
        }
        else{
            Toast.makeText(MainActivity.this,"Incorrect Login Details",Toast.LENGTH_LONG).show();
        }
    }
}
