package com.example.usuario.tarea;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.usuario.tarea.bean.Carrito;
import com.example.usuario.tarea.dao.CarritoDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();



        assertEquals("com.example.usuario.tarea", appContext.getPackageName());

        CarritoDAO dao=new CarritoDAO(appContext);

        Carrito carrito = new Carrito();
        carrito.setCodProducto(1L);
        carrito.setDesProducto("KEN");
        carrito.setCantidad(1.00);
        carrito.setPrecio(5.00);
        carrito.setTotal(2.00);

        dao.saveCarrito(carrito);

        //Carrito ccarrito = dao.findPersonById("1");
       // assertEquals("KEN", ccarrito.getDesProducto());

        List<Carrito> list=dao.findCarritoAll();
        Log.i("xD::::::",list.size()+"");
        dao.close();
    }
}


