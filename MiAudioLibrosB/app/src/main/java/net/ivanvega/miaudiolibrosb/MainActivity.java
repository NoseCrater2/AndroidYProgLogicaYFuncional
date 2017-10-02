package net.ivanvega.miaudiolibrosb;

import android.app.LauncherActivity;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import net.ivanvega.miaudiolibrosb.fragments.DetalleFragment;
import net.ivanvega.miaudiolibrosb.fragments.SelectorFragment;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);



        if ((findViewById(R.id.contenedor_pequeno) != null)
                && (getSupportFragmentManager().findFragmentById(
                R.id.contenedor_pequeno) == null)){
            SelectorFragment primerFragment = new SelectorFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenedor_pequeno, primerFragment)
                    .commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//Botón flotante
       // FloatingActionButton fab = (FloatingActionButton) findViewById(
         //       R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {
            //    Snackbar.make(view, "Replace with your own action",
             //           Snackbar.LENGTH_LONG).setAction("Action", null).show();
            //}
        //});



    }

    public void mostrarDetalle(int id) {
        DetalleFragment detalleFragment =
                (DetalleFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.detalle_fragment);
        if (detalleFragment != null) {
            detalleFragment.ponInfoLibro(id);
        }
        else {
            DetalleFragment nuevoFragment = new DetalleFragment();
            Bundle args = new Bundle();
            args.putInt(DetalleFragment.ARG_ID_LIBRO, id);
            nuevoFragment.setArguments(args);
            FragmentTransaction transaccion = getSupportFragmentManager()
                    .beginTransaction();
            transaccion.replace(R.id.contenedor_pequeno, nuevoFragment);
            transaccion.addToBackStack(null);

            transaccion.commit();
        }

        SharedPreferences pref = getSharedPreferences(
                "com.example.audiolibros_internal", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("ultimo", id);
        editor.commit();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_preferencias) {
            Toast.makeText(this, "Preferencias", Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.menu_ultimo) {
            irUltimoVisitado();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void irUltimoVisitado() {
        SharedPreferences pref = getSharedPreferences(
                "com.example.audiolibros_internal", MODE_PRIVATE);
        int id = pref.getInt("ultimo", -1);
        if (id >= 0) {
            mostrarDetalle(id);
        } else {
            Toast.makeText(this,"Sin última vista",Toast.LENGTH_LONG).show();
        }
    }




}
