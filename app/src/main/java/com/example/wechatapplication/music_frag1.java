package com.example.wechatapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class music_frag1 extends Fragment {
    private View view;
    public String[] name={"邓紫棋——光年之外","蔡健雅——红色高跟鞋","Taylor Swift——Love Story"};
    public static int[] icons={R.drawable.music0,R.drawable.music1,R.drawable.music2};
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view=inflater.inflate(R.layout.music_list,null);
        ListView listView=view.findViewById(R.id.lv);
        MyBaseAdapter adapter=new MyBaseAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(music_frag1.this.getContext(),Music_Activity.class);//创建Intent对象，启动check
                //将数据存入Intent对象
                intent.putExtra("name",name[position]);
                intent.putExtra("position", String.valueOf(position));
                startActivity(intent);
            }
        });
        return view;
    }
    class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount(){return  name.length;}
        @Override
        public Object getItem(int i){return name[i];}
        @Override
        public long getItemId(int i){return i;}

        @Override
        public View getView(int i , View convertView, ViewGroup parent) {
            View view= View.inflate(music_frag1.this.getContext(),R.layout.musicitem_layout,null);
            TextView tv_name=view.findViewById(R.id.item_name);
            ImageView iv=view.findViewById(R.id.iv);

            tv_name.setText(name[i]);
            iv.setImageResource(icons[i]);
            return view;
        }
    }


}
