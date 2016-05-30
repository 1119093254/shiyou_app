package com.hhy.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hhy.bean.Fans;
import com.yanghuan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanhongyang on 2016/5/16.
 */
public class FansAdapter extends BaseAdapter {
    List<Fans> mList;
    private List<ViewHolder> holders = new ArrayList<ViewHolder>();//用于存放不同item行的viewHoder
    Context mContext;
    LayoutInflater mInflater;
    //boolean flag = false;
    ViewHolder viewHolder;
    ImageView mImageView;


    public FansAdapter(List<Fans> list, Context context) {
        mList = list;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        ImageView tou_image;
        TextView text;
        ImageView right_image;
        boolean flag = false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_fans, null);
            viewHolder.tou_image = (ImageView) convertView.findViewById(R.id.touxiang);
            viewHolder.text = (TextView) convertView.findViewById(R.id.fans_text);
            viewHolder.right_image = (ImageView) convertView.findViewById(R.id.guanzhu_image);
            //***
            viewHolder.right_image.setTag(position+"");//用于区分各个item行的右边那个图片
            holders.add(viewHolder);

            convertView.setTag(R.string.app_name,viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag(R.string.app_name);
        }
        //绑定数据
        final Fans fans = mList.get(position);
        viewHolder.tou_image.setImageResource(fans.getTou_image());
        viewHolder.text.setText(fans.getText());
        viewHolder.right_image.setImageResource(fans.getRight_image());

       // mImageView = (ImageView) convertView.findViewById(R.id.guanzhu_image);
        viewHolder.right_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = Integer.parseInt(v.getTag().toString());
                Toast.makeText(mContext,index+"",Toast.LENGTH_SHORT).show();
                viewHolder = holders.get(index);

                if (viewHolder.flag == true) {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(mContext);
                    mBuilder.setMessage("确定不再关注此人？")
                            .setNegativeButton("取消", null)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Toast.makeText(mContext,index+"",Toast.LENGTH_SHORT).show();
                                    viewHolder.right_image.setImageResource(R.drawable.card_icon_addattention);
                                    viewHolder.flag = false;
                                }
                            });
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();
                } else {
                    viewHolder.right_image.setImageResource(R.drawable.card_icon_arrow);
                    viewHolder.flag = true;
                }
            }

        });
        return convertView;
    }


}
