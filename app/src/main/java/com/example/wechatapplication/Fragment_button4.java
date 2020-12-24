package com.example.wechatapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_button4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_button4 extends Fragment {
    private ListView l4;
    private List<WeChat> WeChatList3 =new ArrayList<WeChat>();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_button4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_button4.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_button4 newInstance(String param1, String param2) {
        Fragment_button4 fragment = new Fragment_button4();
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
        View view=inflater.inflate(R.layout.fragment_button4,container,false);
        l4=view.findViewById(R.id.l4);
        InitWechat();
        WeChatAdapter adapter=new WeChatAdapter(getActivity(),R.layout.item_layout, WeChatList3);
        l4.setAdapter(adapter);
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageView takephoto = getActivity().findViewById(R.id.me_title);
        Button locate = getActivity().findViewById(R.id.locate_text);
        takephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),CameraActivity.class);
                startActivity(intent);
            }
        });

        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(),LocateMainActivity.class);
                startActivity(intent);
            }
        });
    }


    public  void InitWechat(){
        for (int i=0;i<1;i++){
            WeChat wechat=new WeChat("支付","",R.drawable.p28);
            WeChatList3.add(wechat);
            WeChat wechat1=new WeChat("收藏","",R.drawable.p29);
            WeChatList3.add(wechat1);
            WeChat wechat2=new WeChat("相册","",R.drawable.p30);
            WeChatList3.add(wechat2);
            WeChat wechat3=new WeChat("卡包","",R.drawable.p31);
            WeChatList3.add(wechat3);
            WeChat wechat4=new WeChat("表情","",R.drawable.p32);
            WeChatList3.add(wechat4);
            WeChat wechat5=new WeChat("设置","",R.drawable.p33);
            WeChatList3.add(wechat5);
}}}