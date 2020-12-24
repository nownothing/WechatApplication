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


public class Fragment_button3 extends Fragment {
    private ListView list3;
    private List<WeChat> WechatList2=new ArrayList<WeChat>();

    // TODO: Rename parameter arguments, choose names that match

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_button3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_button3.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_button3 newInstance(String param1, String param2) {
        Fragment_button3 fragment = new Fragment_button3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_button3,container,false);
        list3 = view.findViewById(R.id.discovery_frag);
        InitWechat();
        WeChatAdapter adapter=new WeChatAdapter(getActivity(),R.layout.item_layout,WechatList2);
        list3.setAdapter(adapter);
        return view;
    }
    public  void InitWechat(){
        for (int i=0;i<1;i++){
            WeChat wechat=new WeChat("朋友圈","",R.drawable.p20);
            WechatList2.add(wechat);
            WeChat wechat1=new WeChat("视频号","",R.drawable.p21);
            WechatList2.add(wechat1);
            WeChat wechat2=new WeChat("扫一扫","",R.drawable.p27);
            WechatList2.add(wechat2);
            WeChat wechat3=new WeChat("摇一摇","",R.drawable.p22);
            WechatList2.add(wechat3);
            WeChat wechat4=new WeChat("看一看","",R.drawable.p23);
            WechatList2.add(wechat4);
            WeChat wechat5=new WeChat("搜一搜","",R.drawable.p24);
            WechatList2.add(wechat5);
            WeChat wechat6=new WeChat("定 位 ","",R.drawable.p25);
            WechatList2.add(wechat6);
            WeChat wechat7=new WeChat("小程序","",R.drawable.p26);
            WechatList2.add(wechat7);
}}}