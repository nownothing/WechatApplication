package com.example.wechatapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class Fragment_button2 extends Fragment {
    private ListView list2;
    private List<WeChat> WeChatList1=new ArrayList<WeChat>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_button2,container,false);
        list2= view.findViewById(R.id.people_frag);
        InitWechat();
        WeChatAdapter adapter=new WeChatAdapter(getActivity(),R.layout.item_layout,WeChatList1);
        list2.setAdapter(adapter);
        return view;
    }
    public  void InitWechat(){
        for (int i=0;i<1;i++){
            WeChat wechat=new WeChat("爸爸","",R.drawable.p1);
            WeChatList1.add(wechat);
            WeChat wechat1=new WeChat("妈妈","",R.drawable.p2);
            WeChatList1.add(wechat1);
            WeChat wechat2=new WeChat("儿子","",R.drawable.p3);
            WeChatList1.add(wechat2);

        }
    }
}