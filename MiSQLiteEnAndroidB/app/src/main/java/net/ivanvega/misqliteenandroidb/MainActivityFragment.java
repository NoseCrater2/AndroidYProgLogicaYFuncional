package net.ivanvega.misqliteenandroidb;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import modelo.Contacto;
import modelo.DAOContactos;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    ListView lsvC;


    public MainActivityFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DAOContactos dao = new DAOContactos(getActivity());

        //dao.insert(new Contacto(0, "Perro Negro", "perro-negro@gmail.com"));
       // dao.insert(new Contacto(0, "Black Dog", "back-dog@gmail.com"));
       // dao.insert(new Contacto(0,"Angel","angel-hndz@hotmail.com","@NoseCrater","4471082981"));


        View layout = inflater.inflate(R.layout.fragment_main,
                container, false);

        lsvC = layout.findViewById(R.id.lscContactos);

        ArrayAdapter<Contacto> adp = new ArrayAdapter<Contacto>(
                getActivity(), android.R.layout.simple_list_item_1,
                dao.getAll()
        );

        lsvC.setAdapter(adp);



        return layout;
    }




}