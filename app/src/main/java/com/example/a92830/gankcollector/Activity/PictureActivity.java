package com.example.a92830.gankcollector.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a92830.gankcollector.R;

public class PictureActivity extends AppCompatActivity {
    private ImageView mImageView;
    private static final String TAG = "PictureActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        mImageView = (ImageView)findViewById(R.id.picture);
        mImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(PictureActivity.this);
                dialog.setTitle("保存在本地吗？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.setNegativeButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //逻辑
                    }
                });
                dialog.show();

                return true;
            }
        });
        String url = getIntent().getStringExtra("url");
        Glide.with(PictureActivity.this).load(url).into(mImageView);
    }
}
