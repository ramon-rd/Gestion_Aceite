package com.example.aceite;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.File;

/**
 * Created by USUARIO on 31/05/2014.
 */
public class PedidosLista extends ListActivity {

   String[] item;
    TextView cliente,cant,fech;
    public void leerXML(String nombre)
    {
        Pedidos ped = new Pedidos();
        ped.LeerPedidos(nombre);

        cliente = (TextView) findViewById(R.id.client);
        cliente.setText(ped.cliente);
        cant = (TextView) findViewById(R.id.cantida);
        cant.setText(ped.cantidad);
        fech = (TextView) findViewById(R.id.fecha);
        fech.setText(ped.fecha);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    //    requestWindowFeature(Window.FEATURE_NO_TITLE); // para quitar titulo
      //  setContentView(R.layout.listapedidos);

        File f = new File(Environment.getExternalStorageDirectory() + "/pedidos/");
        File[] files = f.listFiles();

        item = new String[files.length] ;

        for (int i = 0; i < files.length; i++)

        {
            File file = files[i];

            if (file.isDirectory())

                item[i]=(file.getName() + "/");

            else

                item[i]=(file.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.pedidosimple, R.id.proveedor, item);

        setListAdapter(adapter);
/*

        //Localizamos y llenamos la lista
        ListView lstOpciones = (ListView) findViewById(R.id.);
        ArrayAdapter<String> fileList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        lstOpciones.setAdapter(fileList);

        // Accion para realizar al pulsar sobre la lista
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Devuelvo los datos a la activity principal
                Intent data = new Intent();
                data.putExtra("filename", item.get(i));
                setResult(RESULT_OK, data);
                finish();
            }
        });*/
    }


}


