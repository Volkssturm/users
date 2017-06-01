package com.example.user.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 王 ：王万鹏
 * 2017/5/30 19:48 .：
 * & 作用  ：
 * & 思路  ：
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Bean.DataBean.ComicsBean> mlist;
    private ViewHodler hodler;
    private ArrayList<String> list=new ArrayList<>();

    public MyAdapter(Context context, List<Bean.DataBean.ComicsBean> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            hodler = new ViewHodler();
            convertView=View.inflate(context, R.layout.xlistview_view,null);
            hodler.type= (TextView) convertView.findViewById(R.id.type);
            hodler.name=(TextView) convertView.findViewById(R.id.name);
            hodler.quan=(TextView) convertView.findViewById(R.id.quan);
            hodler.image=(ImageView) convertView.findViewById(R.id.image_view);
            hodler.huaju=(TextView) convertView.findViewById(R.id.huaju);
            convertView.setTag(hodler);
        }else {
            hodler= (ViewHodler) convertView.getTag();
        }
        hodler.type.setText(mlist.get(position).getLabel_text());
        hodler.name.setText(mlist.get(position).getTopic().getTitle());
        hodler.quan.setText(mlist.get(position).getTopic().getUpdate_status());
        x.image().bind(hodler.image,mlist.get(position).getCover_image_url());
        hodler.huaju.setText(mlist.get(position).getTitle());


        //跳转 传值
        hodler.quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeActivity.class);

                for (int i = 0; i <mlist.size() ; i++) {
                    list.add(mlist.get(i).getLabel_text());
                }
                intent.putStringArrayListExtra("list",list);
                context.startActivity(intent);
                list.clear();//清空集合
            }
        });

        return convertView;
    }
    static class  ViewHodler{
        TextView type;
        TextView name;
        TextView quan;
        ImageView image;
        TextView huaju;
    }
}
