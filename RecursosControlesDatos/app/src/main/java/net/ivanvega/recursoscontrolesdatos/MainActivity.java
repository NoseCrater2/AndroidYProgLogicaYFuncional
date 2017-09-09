package net.ivanvega.recursoscontrolesdatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView lista;
    private ArrayList<String>listaContactos = new ArrayList<String>();
    private ArrayAdapter<String>adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Button btn = (Button) findViewById(R.id.btnAgregar);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplication(), DatosActividad.class);

                startActivityForResult(i,1000);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            try {

                ObjContacto o = (ObjContacto) data.getSerializableExtra("obj");
                listaContactos.add(o.getNombre().toString() +" "+ o.getEmail().toString());
                adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaContactos);
                lista = (ListView) findViewById(R.id.lsv);
                lista.setAdapter(adaptador);
                adaptador.notifyDataSetChanged();
            }catch (Exception err){
                Toast.makeText(getApplicationContext(), err.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,0,0,"Relative Layout");
        menu.add(0,1,1,"Salir");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 0:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }




}
