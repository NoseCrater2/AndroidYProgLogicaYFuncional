package com.example.ngel.example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


   RadioButton r1 ;
    RadioButton r2 ;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r1=(RadioButton)findViewById(R.id.tema1);
        t=(TextView)findViewById(R.id.texto);
        r2=(RadioButton)findViewById(R.id.tema2);

        r1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //AQUÍ INTENTÉ REINICIAR LA ACTIVIDAD PARA QUE REINICIARA CON EL TEMA PUESTO
                //PERO NO NO HACE NI VERGAS :(
                //Intent intent = new Intent(getApplication(),MainActivity.class);
              //  startActivity(intent);
                setTheme(R.style.AppTheme1);
                //finish();


                r2.setChecked(false);
            }
        });

        r2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setTheme(R.style.AppTheme1);
                Toast.makeText(getApplication(),"Seleccionado",Toast.LENGTH_SHORT).show();
                r1.setChecked(false);
            }
        });




    }












}
