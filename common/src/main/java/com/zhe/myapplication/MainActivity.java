package com.zhe.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zhe.myapplication.R;
import com.zhe.myapplication.done.async.DialogProcessHandler;
import com.zhe.myapplication.done.util.CutImageUtil;
import com.zhe.myapplication.done.util.DisplayUtils;
import com.zhe.myapplication.done.widget.FileListExploer;
import com.zhe.myapplication.done.widget.dialog.AlertMessageDialog;

import java.io.File;
import java.util.ArrayList;

import me.iwf.photopicker.PhotoPickerActivity;
import me.iwf.photopicker.utils.PhotoPickerIntent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int REQUEST_CODE = 0x1001;
    private ImageView showImage;
    private Button takePhoto;
    private Button cutImage;
    private Button fileExplorer;
    private Button alertDialog;
    private Button customDialog;
    private Button dragActivity;
    private Button dataActivity;
    private ArrayList<String> photos;
    private CutImageUtil cutImageUtil;
    private Context mContext;
    private int screenWidth;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mContext = MainActivity.this;
        cutImageUtil = new CutImageUtil();
        screenWidth = DisplayUtils.getWidthPx((Activity) mContext);

        String fileName = cutImageUtil.getRandomFileName();
        file = new File(getExternalCacheDir(), fileName);
    }

    private void initView() {
        takePhoto = (Button) findViewById(R.id.take_photo);
        cutImage = (Button) findViewById(R.id.cut_image);
        fileExplorer = (Button) findViewById(R.id.file_explorer);
        alertDialog = (Button) findViewById(R.id.alert_dialog);
        customDialog = (Button) findViewById(R.id.custom_dialog);
        showImage = (ImageView) findViewById(R.id.show_image);
        dragActivity = (Button) findViewById(R.id.drag_activity);
        dataActivity = (Button) findViewById(R.id.data_activity);
        takePhoto.setOnClickListener(this);
        cutImage.setOnClickListener(this);
        fileExplorer.setOnClickListener(this);
        alertDialog.setOnClickListener(this);
        customDialog.setOnClickListener(this);
        dragActivity.setOnClickListener(this);
        dataActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.take_photo: {
                PhotoPickerIntent intent = new PhotoPickerIntent(MainActivity.this);
                intent.setPhotoCount(9);
                intent.setShowCamera(true);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            }
            case R.id.cut_image:
                autoCutImage();
                break;
            case R.id.file_explorer:
                showFileExplorer();
                break;
            case R.id.alert_dialog:
                showAlertDialog();
                break;
            case R.id.custom_dialog:
                showCustomDialog();
                break;
            case R.id.drag_activity: {
                Intent intent = new Intent();
                intent.setClass(mContext, com.zhe.myapplication.DragActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.data_activity: {
                Intent intent = new Intent();
                intent.setClass(mContext, com.zhe.myapplication.DataActivity.class);
                startActivity(intent);
            }
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data != null) {
                photos = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
            }
        }
    }

    private void autoCutImage() {
        new DialogProcessHandler(mContext) {
            @Override
            public void handleData() {
                if (photos != null && photos.size() > 0) {
                    Bitmap bitmap = cutImageUtil.getLocalBitmap(photos.get(0)); // 获取到本地图片
                    Bitmap scaleBmp = cutImageUtil.scale(bitmap, screenWidth, true); // 缩放到宽度和屏幕一样宽
                    int[] ratio = cutImageUtil.getRatios(scaleBmp); // 获取裁剪的比例
                    Bitmap cropBmp = cutImageUtil.ImageCrop(scaleBmp, ratio[0], ratio[1], true); // 按照长宽比例裁剪
                    cutImageUtil.saveOutput(mContext, Uri.fromFile(file), cropBmp, 50); // 保存到文件
                }
            }

            @Override
            public String initialContent() {
                return null;
            }

            @Override
            public void updateUI() {
                Bitmap bitmap = cutImageUtil.getLocalBitmap(file.getPath());
                showImage.setImageBitmap(bitmap);
            }
        }.show();
    }

    private void showFileExplorer() {
        new FileListExploer(mContext, "图片选择", FileListExploer.IMAGE) {

            @Override
            public void callback(Bundle bundle) {

            }
        };
    }

    private void showCustomDialog() {
        new AlertCustomDialog(mContext, "这个是tittle", "确定", "取消", "这个是内容") {
            @Override
            protected void positiveButton(DialogInterface dialog, int which) {

            }
        }.show();
    }

    private void showAlertDialog() {
        new AlertMessageDialog(mContext, "这个是tittle", "确定", "取消", "这个是内容") {
            @Override
            protected void positiveButton(DialogInterface dialog, int which) {

            }
        }.show();

//        String[] item = new String[]{"北京", "上海", "广州"};
//        boolean[] checked = new boolean[]{true, false, true};
//        new AlertMessageDialog(mContext, "这个是tittle", "确定", "取消", item, checked) {
//            @Override
//            protected void positiveButton(DialogInterface dialog, int which) {
//
//            }
//        }.show();

//        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, null);
//        new AlertMessageDialog(mContext, "这个是tittle", "确定", "取消", view) {
//            @Override
//            protected void positiveButton(DialogInterface dialog, int which) {
//
//            }
//        }.show();
    }
}
