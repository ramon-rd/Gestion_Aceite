package com.example.aceite;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Created by USUARIO on 7/04/14.
 */
public class ProduccionRealizada extends MyActivity {
    Spinner spinner;
    String[] lista = {
            "7 ml",
            "8 ml",
            "10 ml",
            "14 ml",
            "15 ml",
            "18 ml",
            "20 ml",
            "30 ml"
    };

    private TextView txt; //para mostrar el resultado
    private TextView txt2; //para mostrar los litros restantes
    private EditText num_p;
    private Button guardar;
    private int litrosTotales = 1000;

    @Override
    public
    void onCreate (Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.produccion);
        //  DatosPorDefecto();
        //  obtenerDatos();
        //}

        // private void DatosPorDefecto()
        //{
        iniciar();
        // calcularAceiteEnvasado (ml);

    }


    void iniciar()
    {
        spinner = (Spinner) findViewById(R.id.spinner);
        // spinner = (Spinner) this.findViewById(R.id.spinner);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
        // adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);
        // final int[] posicion = {0};
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int index = spinner.getSelectedItemPosition();
                Toast.makeText(getBaseContext(),"Has seleccionado: " + lista[index], Toast.LENGTH_SHORT).show();
                calcularAceiteEnvasado (index);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    int capacidadTarrina (int tipo)
    {
        int resultado = 0;

        if (tipo == 0)
        {
            resultado = 7;
        }
        else if (tipo == 1)
        {
            resultado = 8;
        }
        else if (tipo == 2)
        {
            resultado = 10;
        }

        else if (tipo == 3)
        {
            resultado = 14;
        }
        else if (tipo == 4)
        {
            resultado = 15;
        }
        else if (tipo == 5)
        {
            resultado = 18;
        }
        else if (tipo == 6)
        {
            resultado = 20;
        }
        else if (tipo == 7)
        {
            resultado = 30;
        }
        return resultado;
    }

    //Ya conocemos el nÃºmero de tarrinas por palÃ©
    int tarrinasPorPale (int tipo)
    {
        int total = 0;

        if (tipo == 7 || tipo == 8 || tipo == 10)
        {
            int unidadCaja = 360;
            total = 140*unidadCaja;
        }
        else if (tipo == 14 || tipo == 15)
        {
            int unidadCaja = 296;
            total = 140*unidadCaja;
        }
        else if (tipo == 18 || tipo == 20)
        {
            int unidadCaja = 224;
            total = 140*unidadCaja;
        }
        else if (tipo == 30)
        {
            int unidadCaja = 160;
            total = 80*unidadCaja;
        }

        return total;
    }
    //vemos cuantos ml corresponde a la posiciÃ³n seleccionada
    int corresponde (int tipo)
    {
        int t = 0;
        if (tipo == 0)
            t = 7;
        else if (tipo == 1)
            t = 8;
        else if (tipo == 2)
            t = 10;
        else if (tipo == 3)
            t = 14;
        else if (tipo == 4)
            t = 15;
        else if (tipo == 5)
            t = 18;
        else if (tipo == 6)
            t = 20;
        else if (tipo == 7)
            t = 30;

        return t;
    }

    double calcularAceite (int totalTarrinas, int tipo)
    {
        double aceiteTotal = 0;

        //  int t = corresponde(tipo);

        double aux = tipo*totalTarrinas;
        aceiteTotal = aux/1000;

        return aceiteTotal;
    }



    void calcularAceiteEnvasado (int ml)
    {
        int num_pales = 0;
        final int M = corresponde(ml);
        // Toast.makeText(getBaseContext(),"tipo tarrina" + M, Toast.LENGTH_SHORT).show();
        final int num = capacidadTarrina(ml);

        guardar = (Button)findViewById(R.id.buttonOk);
        guardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                num_p = (EditText)findViewById(R.id.editText);
                String texto = num_p.getText().toString();
                int aux = Integer.parseInt(texto); //contiene el nÃºmero de palÃ©s introducidos por el usuario
                int n = tarrinasPorPale(M);
                double aceite = calcularAceite(n,M);
                double r = aux*aceite;
                // Toast.makeText(getBaseContext(),"total " + r, Toast.LENGTH_SHORT).show();
                String tx = Double.toString(r);
                txt = (TextView)findViewById(R.id.textView3);
                txt.setText("");
                txt.append(tx);
                double restantes = litrosTotales - r;
                txt2 = (TextView)findViewById(R.id.textView5);

                String tx2 = Double.toString(restantes);
                txt2 = (TextView)findViewById(R.id.textView5);
                txt2.setText("");
                txt2.append(tx2);

            }
        });
    }

}
