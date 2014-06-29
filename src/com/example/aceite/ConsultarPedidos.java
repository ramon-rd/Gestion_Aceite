package com.example.aceite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by USUARIO on 19/05/2014.
 */
public class ConsultarPedidos extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public ConsultarPedidos(Context context,String[] values) {
        super(context, R.layout.pedidosimple, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.pedidosimple, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.proveedor);
      //  TextView textView2 = (TextView) rowView.findViewById(R.id.cantida);
      //  TextView textView3 = (TextView) rowView.findViewById(R.id.fecha);
       // ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values[position]);
     //   textView2.setText(values.get(position).getCantidad());
     //   textView3.setText(values.get(position).getFecha());
        // change the icon for Windows and iPhone
       /* String s = values[position];
        if (s.startsWith("iPhone")) {
            imageView.setImageResource(R.drawable.no);
        } else {
            imageView.setImageResource(R.drawable.ok);
        }*/

        return rowView;
    }


}

   /* public static final String TAG = "TratamientoXML";
    private ArrayList<Pedidos> datos;
    Activity context;
  //  Pedidos pedido=();

    TextView cliente,cant,fech;

    // Array TEXTO donde guardaremos los nombres de los ficheros
    private List<String> item = new ArrayList<String>();

    void listarDirectorio()
    {
        File f = new File(Environment.getExternalStorageDirectory() + "/pedidos/");
        //Creo el array de tipo File con el contenido de la carpeta
        File[] files = f.listFiles();
        //Hacemos un Loop por cada fichero para extraer el nombre de cada uno

        for (int i = 0; i < files.length; i++)
        {
        //Sacamos del array files un fichero
            File file = files[i];

        //Si es directorio...
            if (file.isDirectory())

                item.add(file.getName() + "/");

            //Si es fichero...
            else

                item.add(file.getName());
        }
}
     /*   ListView lstOpciones = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> fileList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        lstOpciones.setAdapter(fileList);

        // Accion para realizar al pulsar sobre un item de la lista
        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterVew<?>a,View v,int position,long id){

                //Devolvemos el resultado de la selección
                Intent data = new Intent();
                data.putExtra("filename", item.get(position));
                setResult(RESULT_OK, data);
                finish();
            }
        });*/



    //Defino la ruta donde busco los ficheros

/*
    public ConsultarPedidos(Activity context, ArrayList<Pedidos> datos) {
        super(context, R.layout.consultarpedidos, datos);
        // Guardamos los parámetros en variables de clase.
        this.context = context;
        this.datos = datos;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {

        // En primer lugar "inflamos" una nueva vista, que será la que se
        // mostrará en la celda del ListView.
        //View item = LayoutInflater.from(context).inflate(R.layout.item_lista_alumnos, null);
        View item = convertView;
        //item.findViewById(R.id.checkbox).setOnClickListener(this);

        final Estructura elem;

        if (item == null) {

           // Activity context;
            Activity context = null;
            LayoutInflater inflater = context.getLayoutInflater();
            // Definimos en la vista de vuelta el tipo de diseño
            item = inflater.inflate(R.layout.consultarpedidos, null);


            // Definimos el objeto que vamos a almacenar en el nuevo elemento
            elem = new Estructura();
            // Obtenemos los punteros a las etiquetas recién infladas y al icono
            elem.cliente = (TextView) item.findViewById(R.id.client);
            elem.cantidad = (TextView) item.findViewById(R.id.cantida);
            elem.fecha = (TextView) item.findViewById(R.id.fecha);
         //   elem.icon = (ImageView) item.findViewById(R.id.foto);

            // Guardamos el objeto en el elemento
            item.setTag(elem);
        } else {
            // Si estamos reutilizando una Vista, recuperamos el objeto interno
            elem = (Estructura) item.getTag();
        }

        // Cargamos los datos de las opciones de la matriz de datos
        elem.cliente.setText(datos.get(position).getCliente());
        elem.cantidad.setText(datos.get(position).getCantidad());
        elem.fecha.setText(datos.get(position).getFecha());
     //  elem.birth_date.setText(obtenerCadenaDeFecha(datos.get(position).getFechaNacimiento()));
      //  elem.checker.setChecked(datos.get(position).getAsiste());
      //  elem.icon.setImageBitmap(datos.get(position).getFoto());

        return(item);
    }*/
/*
    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.consultarpedidos);
        leerXML();
    }


    private String nombre, cantidad, fecha;

    public void leerXML()
    {
        listarDirectorio();

        ListView listaOpciones = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> fileList = new ArrayAdapter<String>(this,R.layout.listapedidos)

        Pedidos ped = new Pedidos();
        ped.LeerPedidos("juan.xml");

       cliente = (TextView) findViewById(R.id.client);
       cliente.setText(ped.cliente);
       cant = (TextView) findViewById(R.id.cantida);
       cant.setText(ped.cantidad);
       fech = (TextView) findViewById(R.id.fecha);
       fech.setText(ped.fecha);

       for (int i = 0; i < item.size(); i++)
       {
           Context context = getApplicationContext();
           CharSequence text = item.get(i);
           int duration = Toast.LENGTH_SHORT;

           Toast toast = Toast.makeText(context, text, duration);
           toast.show();
       }

    }
}
*/
/*class Estructura{
    TextView cliente;
    TextView cantidad;
    TextView fecha;
}*/