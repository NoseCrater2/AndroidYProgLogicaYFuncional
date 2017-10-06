package com.example.ngel.apppermisos;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button btnVibrar;
    Button btnCamara;
    private ImageView img;
    public static final int MY_PERMISION =0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVibrar = (Button)findViewById(R.id.btnVibrar);
        btnVibrar.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v){

                Vibrator vi = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                long [] patron ={0,500,300,1000,500};
                vi.vibrate(patron,3);

            }

        });

        btnCamara = (Button)findViewById(R.id.btnCamara);
        btnCamara.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v){
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File imagesFolder = new File(Environment.getExternalStorageDirectory(),"fotoPermiso");
                imagesFolder.mkdirs();

                File image = new File(imagesFolder,"fotoPermiso.jpg");
                Uri uriSavedImage = Uri.fromFile(image);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,uriSavedImage);
                startActivityForResult(cameraIntent,1);
            }

        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1 && resultCode == RESULT_OK){
            Bitmap bMap = BitmapFactory.decodeFile(Environment.getDownloadCacheDirectory()+"/fotoPermiso/"+"fotoPermiso.jpg");
        }
    }

}



