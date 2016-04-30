package com.example.james.mobilepractical;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PostActivity extends AppCompatActivity {

    private ImageView imgView;
    private String selectedImagePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

//        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE});

        imgView = (ImageView) findViewById(R.id.imageView);
        ImageButton img = (ImageButton) findViewById(R.id.btn_picture);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
            }
        });
    }



    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == RESULT_OK)
        {
            if(requestCode == 1)
            {
                Uri image = data.getData();
                String selectedImagePath = getPath(image);
                System.out.println("Image Path: " + selectedImagePath);
                imgView.bringToFront();
                imgView.setImageURI(image);
            }
        }
    }

    public String getPath(Uri uri)
    {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}
