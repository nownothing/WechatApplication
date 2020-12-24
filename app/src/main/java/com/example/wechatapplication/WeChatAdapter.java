package com.example.wechatapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class WeChatAdapter extends ArrayAdapter<WeChat> {
    private int resuorceId;
    public WeChatAdapter(Context context, int textViewResuorceId, List<WeChat> objects){
        super(context,textViewResuorceId,objects);
        resuorceId=textViewResuorceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        WeChat wechat=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resuorceId,parent,false);
        ImageView wechatImage=(ImageView) view.findViewById(R.id.wechat_image);
        TextView wechatNmae=(TextView) view.findViewById(R.id.wechat_name);
        TextView wechatNmae1=(TextView) view.findViewById(R.id.wechat_msg);
        wechatImage.setImageResource(wechat.getImage());
        wechatNmae.setText(wechat.getName());
        wechatNmae1.setText(wechat.getMsg());
        return view;
    }
}
