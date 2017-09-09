package net.ivanvega.recursoscontrolesdatos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;


public class DatosActividad extends AppCompatActivity {

    EditText txtNom;
    EditText txtEm;
    EditText txtTw;
    EditText txtT;
    EditText txtF;
    Button btnGuardar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);




        btnGuardar = (Button) findViewById(R.id.btnAceptar);
       btnGuardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                txtNom = (EditText)findViewById(R.id.txtNombre);
                txtEm = (EditText)findViewById(R.id.txtEmail);
                txtTw = (EditText)findViewById(R.id.txtTwittter);
                txtT = (EditText)findViewById(R.id.txtTel);
                txtF = (EditText)findViewById(R.id.txtNac);

                ObjContacto os = new ObjContacto(txtNom.getText().toString(),
                        txtEm.getText().toString(),
                        txtTw.getText().toString(),
                        txtT.getText().toString(),
                        txtF.getText().toString());


                Intent intent = new Intent();
                intent.putExtra("obj",os);

                setResult(RESULT_OK, intent);
                finish();
            }

        });



    }
}
