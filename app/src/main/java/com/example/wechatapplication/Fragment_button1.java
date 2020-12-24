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

public class Fragment_button1 extends Fragment {
    private ListView list1;
    private List<WeChat>WechatList=new ArrayList<WeChat>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_button1,container,false);
        list1=view.findViewById(R.id.msg_frag);
        InitWechat();
        WeChatAdapter adapter=new WeChatAdapter(getActivity(),R.layout.item_layout,WechatList);
        list1.setAdapter(adapter);
        return view;
    }
    public void InitWechat(){
        for (int i=0;i<1;i++){
            WeChat wechat=new WeChat("爸爸                                                                                   昨天","吃了吗",R.drawable.p1);
            WechatList.add(wechat);
            WeChat wechat1=new WeChat("妈妈                                                                                  8：41","在干嘛",R.drawable.p2);
            WechatList.add(wechat1);
            WeChat wechat2=new WeChat("儿子                                                                                  10:20","想你了",R.drawable.p3);
            WechatList.add(wechat2);

         }
    }

}
