package com.lxx.activity;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.lxx.Adapter.SendAdapterGridview;
import com.lxx.Utils.ActivityForResultUtil;
import com.yanghuan.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public class SendDynamic extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;// 从相册中选择
    public static final int REQUEST_CODE1 = 2;// 拍照
    private static final int PHOTO_REQUEST_CUT = 3;// 结果
    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    List<Bitmap> bitmapList;
    SendAdapterGridview sendAdapterGridview;
    Button button;
    private File tempFile;
    ImageView imageView;
    Button button1;
    GridView gridView;
    private String mPhotoPath;// 上传的图片路径
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_dynamic);
        initView();
        initdata();


    }

    private void initView() {
        button = (Button)findViewById(R.id.btn_ok);
        button1 = (Button)findViewById(R.id.btn_cancel);
        gridView= (GridView) findViewById(R.id.sendGridview);
        imageView = (ImageView) findViewById(R.id.ceshiimage);
        PhotoDialog();

    }

    private void initdata() {

    }
    private void PhotoDialog() {
        Builder builder = new Builder(SendDynamic.this);
        builder.setTitle("插入照片");
        builder.setItems(new String[] { "拍照上传", "上传手机中的照片" },
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = null;
                        switch (which) {
                            case 0:
                                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                if (hasSdcard()){// 判断存储卡是否可以用，可用进行存储
                                    intent.putExtra(MediaStore.EXTRA_OUTPUT,
                                            Uri.fromFile(new File(Environment
                                                    .getExternalStorageDirectory(), PHOTO_FILE_NAME)));
                                }
                                startActivityForResult(intent,  ActivityForResultUtil.REQUESTCODE_UPLOADPHOTO_CAMERA);
                               /* intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                File dir = new File("/sdcard/KaiXin/Camera/");
                                if (!dir.exists()) {
                                    dir.mkdirs();
                                }
                                mPhotoPath = "/sdcard/KaiXin/Camera/"
                                        + UUID.randomUUID().toString();
                                File file = new File(mPhotoPath);
                                if (!file.exists()) {
                                    try {
                                        file.createNewFile();
                                    } catch (IOException e) {

                                    }
                                }
                                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                                        Uri.fromFile(file));
                                startActivityForResult(
                                        intent,
                                        ActivityForResultUtil.REQUESTCODE_UPLOADPHOTO_CAMERA);
                               */ break;

                            case 1:

                                intent = new Intent(Intent.ACTION_PICK, null);
                                intent.setDataAndType(
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                        "image/*");
                                startActivityForResult(
                                        intent,
                                        ActivityForResultUtil.REQUESTCODE_UPLOADPHOTO_LOCATION);
                                break;
                        }
                    }
                });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap;


        if (resultCode == RESULT_OK &&requestCode== ActivityForResultUtil.REQUESTCODE_UPLOADPHOTO_LOCATION) {
            Uri uri = data.getData();// 得到图片的全路径
            bitmapFactory(uri);
          //把拍摄的照片转成圆角显示在预览控件

            // Log.e("uri", uri.toString());
           // crop(uri);
          /*   ContentResolver cr = this.getContentResolver();

                            bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                            bitmap=toRoundBitmap(bitmap);

                            *//* 将Bitmap设定到ImageView *//*
                            imageView.setImageBitmap(bitmap);*/
        }
        else if(resultCode == RESULT_OK &&requestCode==ActivityForResultUtil.REQUESTCODE_UPLOADPHOTO_CAMERA) {
            if (hasSdcard()) {tempFile = new File(Environment.getExternalStorageDirectory(),
                    PHOTO_FILE_NAME );

                    bitmapFactory(Uri.fromFile(tempFile));
                }


            else {
                Toast.makeText(SendDynamic.this, "未找到存储卡，无法存储照片！", 0).show();
            }
        }
        else if (requestCode == PHOTO_REQUEST_CUT) {
            try {
                bitmap = data.getParcelableExtra("data");

                imageView.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    private boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(///检查SD卡正常挂载
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
    private void bitmapFactory(Uri uri){
        BitmapFactory.Options options = new BitmapFactory.Options();
        //options.inSampleSize = 8;//设置生成的图片为原图的八分之一
        options.inJustDecodeBounds = true;//这将通知 BitmapFactory类只须返回该图像的范围,而无须尝试解码图像本身
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int heightRadio = (int) Math.ceil(options.outHeight/(float)height);
        int widthRadio = (int) Math.ceil(options.outWidth/(float)width);
        if (heightRadio>1&&widthRadio>1) {
            if (heightRadio>widthRadio) {
                options.inSampleSize = heightRadio;
            }else {
                options.inSampleSize = widthRadio;
            }
        }
        //真正解码图片
        options.inJustDecodeBounds = false;
        Bitmap b;
        try {
            b = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri),null, options);
            imageView.setImageBitmap(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
