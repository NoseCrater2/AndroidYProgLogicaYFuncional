package modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alcohonsilver on 04/10/17.
 */

public class MiSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String  TABLE_CONTACTOS_NAME="contactos";
    public static final String[] COLUMNS_NAME_TABLE_CONTACTOS = {"_id", "nombre","correo_electronico"
    , "twitter","telefono","fecha_nacimiento"};

    private  final String SCRIPT_TABLE_CONTACTOS="create table " + TABLE_CONTACTOS_NAME + "(" +
              COLUMNS_NAME_TABLE_CONTACTOS[0] + " integer primary key autoincrement, " +
            COLUMNS_NAME_TABLE_CONTACTOS[1] + " varchar(100) not null, " +
            COLUMNS_NAME_TABLE_CONTACTOS[2] + " varchar(200) not null, " +
            COLUMNS_NAME_TABLE_CONTACTOS[3] + " varchar(100) null, " +
            COLUMNS_NAME_TABLE_CONTACTOS[4] + " varchar(20) null, " +
            COLUMNS_NAME_TABLE_CONTACTOS[5] + " date null " +
            ");";
    private static final int VERSION_DB = 1;

    public MiSQLiteOpenHelper(Context contexto){

        super(contexto, "miBD", null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SCRIPT_TABLE_CONTACTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
