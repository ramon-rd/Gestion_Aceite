package com.example.aceite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void lanzarAcercaDe (View view)
    {
        Intent i = new Intent (this, ProduccionRealizada.class);
        startActivity(i);
    }
    public void lanzarNuevoPedido (View view)
    {
        Intent i = new Intent (this, NuevoPedido.class);
        startActivity(i);
    }

    public void lanzarConsultarPedido (View view)
    {
        Intent i = new Intent (this, PedidosLista.class);
        startActivity(i);
    }

}

