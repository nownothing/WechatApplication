package com.example.wechatapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePageActivity extends AppCompatActivity {

    private ImageView msg;
    private ImageView people;
    private ImageView discovery;
    private ImageView me;
    private ImageView music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_homepage);
        msg=findViewById(R.id.msg);
        people=findViewById(R.id.people);
        discovery=findViewById(R.id.discovery);
        me=findViewById(R.id.me);
        music = findViewById(R.id.musicpage);

        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.top_content,new Fragment_button1());
                fragmentTransaction.commit();
            }
        });
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.top_content,new Fragment_button2());
                fragmentTransaction.commit();
            }
        });
        discovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.top_content,new Fragment_button3());
                fragmentTransaction.commit();
            }
        });
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.top_content,new Fragment_button4());
                fragmentTransaction.commit();
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this,MusicMainActivity.class);
                startActivity(intent);
            }
        });
    }

}