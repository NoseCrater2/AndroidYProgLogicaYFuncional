package net.ivanvega.misqliteenandroidb;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import modelo.Contacto;
import modelo.DAOContactos;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    DAOContactos dao;
    ListView lsvC;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lsvC = (ListView)findViewById(R.id.lscContactos);
        registerForContextMenu(lsvC);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private SearchView mSearchView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        MenuItem searchItem = menu.findItem(R.id.buscar);
        mSearchView = (SearchView) searchItem.getActionView();
        mSearchView.setOnQueryTextListener(this);

        return true;
    }
String id;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        int mPosition;

        if (v.getId() ==R.id.lscContactos) {
            mPosition = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
            menu.setHeaderTitle(lsvC.getAdapter().getItem(mPosition).toString());
            id = lsvC.getAdapter().getItem(mPosition).toString().substring(0,1);


            this.getMenuInflater().inflate(R.menu.menu_main,menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case R.id.buscar:
                Toast.makeText(this, "Se presionó el botón ", Toast.LENGTH_SHORT).show();

                break;
        }

       return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:
                 dao = new DAOContactos(this);
                Toast.makeText(this, "Id: "+id, Toast.LENGTH_SHORT).show();
              dao.delete(Integer.parseInt(id));
               lsvC.invalidateViews();
               lsvC.refreshDrawableState();
                return true;

            case R.id.action_edit:


                return true;

        }



        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {

        Toast.makeText(this, query, Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {


        return false;
    }
}
