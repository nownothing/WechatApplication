package com.example.wechatapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建数据库
        Connector.getDatabase();
        TextView register = findViewById(R.id.login_register);
        register.setOnClickListener(this);

        Button loginButton = findViewById(R.id.login_login);
        loginButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_register:
                Intent intent1 = new Intent(MainActivity.this,Register.class);
                startActivity(intent1);
                break;
            case R.id.login_login:
                List<User> users = LitePal.findAll(User.class);
                EditText username = findViewById(R.id.login_username);
                EditText password = findViewById(R.id.login_password);
                //判断
                for (User user : users){
                    if (user.getUsername().equals(username.getText().toString())&&user.getPassword().equals(password.getText().toString())){
                        Intent intent2 = new Intent(MainActivity.this, HomePageActivity.class);
                        startActivity(intent2);
                    onDestroy();
                    }
                    else {
                        Toast.makeText(MainActivity.this,"账号密码错误",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode){
//            case 1:
//                if (requestCode == RESULT_OK){
//                    final EditText loginUsername = findViewById(R.id.login_username);
//                            String returnUsername = data.getStringExtra("username");
//                            loginUsername.setText(returnUsername);
//                            loginUsername.setSelection(returnUsername.length());
//                }
//                break;
//            default:
//                break;
//        }
//    }
}