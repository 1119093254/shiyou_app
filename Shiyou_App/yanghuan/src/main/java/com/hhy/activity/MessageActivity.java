package com.hhy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yanghuan.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView mImageView;
    ImageView mCommentImage,mPraiseImage,mChatroomImage,mNocareImage,mNewfansImage;
    boolean flag1 = false,flag2 = false,flag3 = false,flag4 = false,flag5 = false;
    String mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hhy_activity_message);
        initView();

    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.hhy_message_back_image);
        mCommentImage = (ImageView) findViewById(R.id.hhy_message_comment);
        mPraiseImage = (ImageView) findViewById(R.id.hhy_message_praise);
        mChatroomImage = (ImageView) findViewById(R.id.hhy_message_chatroom);
        mNocareImage = (ImageView) findViewById(R.id.hhy_message_nocare_message);
        mNewfansImage = (ImageView) findViewById(R.id.hhy_message_newfans);

        mImageView.setOnClickListener(this);
        mCommentImage.setOnClickListener(this);
        mPraiseImage.setOnClickListener(this);
        mChatroomImage.setOnClickListener(this);
        mNocareImage.setOnClickListener(this);
        mNewfansImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.hhy_message_back_image:
                //返回上一个界面
                MessageActivity.this.finish();
                break;
            case R.id.hhy_message_comment:
                if(flag1){
                    mCommentImage.setImageResource(R.drawable.butn_close);
                    flag1 = false;
                }else{
                    mCommentImage.setImageResource(R.drawable.butn_open);
                    flag1 = true;//表示推送消息按钮打开
                    getTest(flag1,"comment");
                }
                break;
            case R.id.hhy_message_praise:
                if(flag2){
                    mPraiseImage.setImageResource(R.drawable.butn_close);
                    flag2 = false;
                }else{
                    mPraiseImage.setImageResource(R.drawable.butn_open);
                    flag2 = true;//表示推送消息按钮打开
                    getTest(flag2,"praise");
                }
                break;
            case R.id.hhy_message_chatroom:
                if(flag3){
                    mChatroomImage.setImageResource(R.drawable.butn_close);
                    flag3 = false;
                }else{
                    mChatroomImage.setImageResource(R.drawable.butn_open);
                    flag3 = true;//表示推送消息按钮打开
                    getTest(flag3,"chatroom");
                }
                break;
            case R.id.hhy_message_nocare_message:
                if(flag4){
                    mNocareImage.setImageResource(R.drawable.butn_close);
                    flag4 = false;
                }else{
                    mNocareImage.setImageResource(R.drawable.butn_open);
                    flag4 = true;//表示推送消息按钮打开
                    getTest(flag4,"nocare");
                }
                break;
            case R.id.hhy_message_newfans:
                if(flag5){
                    mNewfansImage.setImageResource(R.drawable.butn_close);
                    flag5 = false;
                }else{
                    mNewfansImage.setImageResource(R.drawable.butn_open);
                    flag5 = true;//表示推送消息按钮打开
                    getTest(flag5,"newfans");
                }
                break;
            default:
                break;
        }
    }

    private void getTest(boolean flag,String biaozhi) {
        //POST请求
        //第一步：设置访问路径以及携带数据
        if(flag){
            mPath = "http://10.201.1.148:8888/HttpServer/HttpServer";
            RequestParams params = new RequestParams(mPath);
            params.addBodyParameter("biaozhi",biaozhi);
            //代表相关按钮被打开，可以发送通知了
            //第二步：开始请求，设置请求方式，同时实现回调函数
          x.http().post(params, new Callback.CommonCallback<String>() {
              @Override
              public void onSuccess(String result) {
                  Toast.makeText(MessageActivity.this, result, Toast.LENGTH_SHORT).show();
              }

              @Override
              public void onError(Throwable ex, boolean isOnCallback) {

              }

              @Override
              public void onCancelled(CancelledException cex) {

              }

              @Override
              public void onFinished() {

              }
          });
     }
    }
}
