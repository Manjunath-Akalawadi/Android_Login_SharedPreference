package com.example.manju7.android_login_sharedpreference;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class HomeActivity extends Activity {
    Button logout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView=(TextView)findViewById(R.id.hi);

        logout=(Button)findViewById(R.id.logout);


        Intent intent=getIntent();
        String str=intent.getStringExtra("message");
        textView.setText(str);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor e=sp.edit();
                e.clear();
                e.commit();

                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                finish();   //finish current activity
            }
        });
    }
}