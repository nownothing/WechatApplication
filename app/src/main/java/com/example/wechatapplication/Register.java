package com.example.wechatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist);

        Button register = findViewById(R.id.register_success);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.register_username);
                EditText password = findViewById(R.id.register_password);
                EditText passwordAffirm = findViewById(R.id.register_affirm);
                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();
                String inputAffirm = passwordAffirm.getText().toString();
                User user = new User();
                if (inputAffirm.equals(inputPassword)){
                    user.setUsername(inputUsername);
                    user.setPassword(inputPassword);
                    user.save();

                    Intent intent = new Intent();
                    intent.putExtra("username",inputUsername);
                    setResult(RESULT_OK,intent);
                    finish();
                }else {
                    Toast.makeText(Register.this,"两次密码不一样",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

