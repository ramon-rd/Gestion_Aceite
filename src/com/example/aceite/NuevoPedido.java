package com.example.aceite;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by USUARIO on 10/04/14.
 */
public class NuevoPedido extends MyActivity {

    private Button ins;
    private EditText pedido, litros, fecha;
    Pedidos ped = new Pedidos();

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.pedidonuevo);
        escribirXML();
    }

    private void escribirXML(){

        ins = (Button)findViewById(R.id.buttonIns);

        ins.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                pedido = (EditText) findViewById(R.id.editTextCliente);
                ped.cliente = pedido.getText().toString();
                litros = (EditText) findViewById(R.id.editTextCantidad);
                ped.cantidad = litros.getText().toString();
                fecha = (EditText) findViewById(R.id.editTextFecha);
                ped.fecha = fecha.getText().toString();

                ped.toXML();

                Context context = getApplicationContext();
                CharSequence text = "¡Guardado con éxito!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }


    /*
    private Button ins;
    private EditText pedido, litros, fecha;


    public static boolean isExternalStorageReadOnly() {
        boolean lectura_escritura = false;
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            lectura_escritura = true;
        }
        else{
            lectura_escritura = false;
        }
        return lectura_escritura;
    }

    public static boolean isExternalStorageAvailable() {
        boolean sd_montada = false;
        String extStorageState = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(extStorageState)){
            sd_montada= true;
        }
        else{
            sd_montada = false;
        }

        return sd_montada;
    }

       */      /*
    void guardarArchivo ()
    {
        ins = (Button)findViewById(R.id.buttonIns);
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Comprobamos si se ha pulsado el botón para guardar el pedido de aceite.
                if(v.getId()==findViewById(R.id.buttonIns).getId()){

                    File sdCard, directory_padre, directory_hijo, file;

                    try {
                        // validamos si se encuentra montada nuestra memoria externa y se puede escribir en ella...
                        if (isExternalStorageAvailable() && !isExternalStorageReadOnly()) {

                            // Obtenemos el directorio de la memoria externa
                            sdCard = Environment.getExternalStorageDirectory();

                            // Clase que permite grabar texto en un archivo
                            FileOutputStream fout;
                            try {
                                // instanciamos un onjeto File para crear un nuevo
                                // directorio
                                // la memoria externa

                                directory_padre = new File(sdCard.getAbsolutePath()
                                        + "/Pedidos");
                                // se crea el nuevo directorio donde se creará el
                                // archivo
                                directory_padre.mkdirs();
                                // Se crea o identifica (si ya está creado) el directorio hijo.
                                directory_hijo = new File(directory_padre.getAbsolutePath());
                                directory_hijo.mkdirs();
                                Toast.makeText(getBaseContext(),
                                        directory_padre.getAbsolutePath(),
                                        Toast.LENGTH_SHORT).show();

                                // creamos el archivo en el nuevo directorio creado
                                String nuevo_archivo = "prueba.txt";

                                file = new File(directory_hijo, nuevo_archivo);
                                Toast.makeText(getBaseContext(),
                                        "creo fichero!!!",
                                        Toast.LENGTH_SHORT).show();
                                // Es necesario definir a true el segundo campo de FileOutputStream para que no sobreescriba.

                                fout = new FileOutputStream(file,true);

                                Toast.makeText(getBaseContext(),
                                        "ya lo hemos creado, vamos a recoger los datos!!!",
                                        Toast.LENGTH_SHORT).show();

                                OutputStreamWriter ows = new OutputStreamWriter(fout);

                                pedido = (EditText)findViewById(R.id.editTextCliente);
                                litros = (EditText)findViewById(R.id.editTextCantidad);
                                fecha = (EditText)findViewById(R.id.editTextFecha);

                                String n_cliente, n_litros, n_fecha;

                                n_cliente = pedido.getText().toString();
                                n_litros = litros.getText().toString();
                                n_fecha = fecha.getText().toString();

                                Toast.makeText(getBaseContext(),
                                        n_cliente,
                                        Toast.LENGTH_SHORT).show();

                                ows.write(n_cliente);
                                ows.write(n_litros);
                                ows.write(n_fecha);

                                ows.flush(); // Vuelca lo que hay en el buffer dentro del archivo
                                ows.close(); // Cierra el archivo de texto

                                Toast.makeText(getBaseContext(),
                                        "El pedido se ha almacenado correctamente!!!",
                                        Toast.LENGTH_SHORT).show();

                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                            //}

                        }else{
                            Toast.makeText(getBaseContext(),
                                    "El almacenamineto externo no se encuentra disponible",
                                    Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        // TODO: handle exception

                    }

                }

            }

        });

    }      */

}

