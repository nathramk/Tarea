package com.example.usuario.tarea.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.usuario.tarea.bean.Carrito;
import com.example.usuario.tarea.util.Commons;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 02/05/2017.
 */

public class CarritoDAO extends SQLiteOpenHelper {
    private  static final int VERSION=1;

    public CarritoDAO(Context context) {
        super(context, Commons.DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String ddl="CREATE TABLE Carrito (" +
                " codProducto INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " desProducto TEXT," +
                " cantidad REAL," +
                " precio REAL," +
                " total REAL" +
                ");";
        db.execSQL(ddl);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String ddl = "DROP TABLE IF EXISTS Person";
        db.execSQL(ddl);
        this.onCreate(db);

    }
    public void deletePerson(Long id){
        getWritableDatabase().delete("Carrito",null,null);
    }

    public void updatePerson(Carrito carrito){
        ContentValues values = new ContentValues();
        values.put("desProducto",carrito.getDesProducto());
        values.put("cantidad", carrito.getCantidad());
        values.put("precio", carrito.getPrecio());
        values.put("total", carrito.getTotal());


        getWritableDatabase().update("Carrito",values,"id="+carrito.getCodProducto(),null);
    }
    public Carrito findPersonById(String id){
        String columns[]={"codProducto","desProducto","cantidad","precio","total"};
        String where = "codProducto = "+id;

        Carrito carrito=null;
        Cursor cursor = getReadableDatabase().query("Carrito",columns,where,null,null,null,null);
        if(cursor.moveToFirst()){
            carrito=new Carrito();
            carrito.setCodProducto(cursor.getLong(0));
            carrito.setDesProducto(cursor.getString(1));
            carrito.setCantidad(cursor.getDouble(2));
            carrito.setPrecio(cursor.getDouble(3));
            carrito.setTotal(cursor.getDouble(4));
        }
        cursor.close();
        return carrito;
    }

    public void saveCarrito(Carrito carrito){
        ContentValues values=new ContentValues();
        values.put("desProduct",carrito.getDesProducto());
        values.put("cantidadReal",carrito.getCantidad());
        values.put("precio", carrito.getPrecio());
        values.put("total", carrito.getTotal());

        getWritableDatabase().insert("Carrito", null,values);
    }


    public List<Carrito> findCarritoAll(){
        ArrayList<Carrito> listCursor = new ArrayList<Carrito>();
        String columns[]={"codProducto","desProducto","cantidad","precio","total"};
        String where = null;
        Cursor cursor = getReadableDatabase().query("Carrito",columns,where,null,null,null,null);

        Carrito carrito;
        while(cursor.moveToNext()){
            carrito = new Carrito();
            carrito=new Carrito();
            carrito.setCodProducto(cursor.getLong(0));
            carrito.setDesProducto(cursor.getString(1));
            carrito.setCantidad(cursor.getDouble(2));
            carrito.setPrecio(cursor.getDouble(3));
            carrito.setTotal(cursor.getDouble(4));

            listCursor.add(carrito);
        }

        return listCursor;
    }

}
