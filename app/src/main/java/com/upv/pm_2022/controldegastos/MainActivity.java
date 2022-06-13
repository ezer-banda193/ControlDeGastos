package com.upv.pm_2022.controldegastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView, listView2;
    Button Ok, Ok2;
    String array[]=new String[]{"Gasto 1","Gasto 2","Gasto 3","Gasto 4","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5","Gasto 5"};
    String array2[]=new String[]{"Ingreso 1","Ingreso 2","Ingreso 3","Ingreso 4","Ingreso 5"};
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.lv1);
        listView2 = (ListView) findViewById(R.id.lv2);
        Ok = (Button)findViewById(R.id.buttonGastos);
        Ok2 = (Button)findViewById(R.id.buttonIngresos);

        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,array));
        listView2.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,array2));
        //listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Estatus = (((CheckedTextView) view).isChecked() ? "Seleccionado" : "Des-seleccionado");
                String Elemento = ((CheckedTextView) view).getText().toString();
                Toast.makeText(getApplicationContext(),"Seleccionaste el "+Elemento,Toast.LENGTH_SHORT).show();
            }
        });
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Estatus = (((CheckedTextView) view).isChecked() ? "Seleccionado" : "Des-seleccionado");
                String Elemento = ((CheckedTextView) view).getText().toString();
                Toast.makeText(getApplicationContext(),"Seleccionaste el "+ Elemento,Toast.LENGTH_SHORT).show();
            }
        });

        Ok.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Agregaste un Gasto", Toast.LENGTH_SHORT).show();;
            }
        });

        Ok2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Agregaste un Ingreso", Toast.LENGTH_SHORT).show();
            }
        });

        // Importante: Esto va antes de instanciar controles dentro de cada pestaña

        // Agregar las pestañas---
        Resources res = getResources();
        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec spec1 = tabHost.newTabSpec("");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("GASTOS");

        TabHost.TabSpec spec2 = tabHost.newTabSpec("");
        spec2.setContent(R.id.tab2);
        spec2.setIndicator("INGRESOS");

        TabHost.TabSpec spec3 = tabHost.newTabSpec("");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("BALANCE");
        //spec3.setIndicator("",getResources().getDrawable(R.mipmap.ic_launcher));

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);

        // Otros Recursos (TextView, Buttons, ListView, EditText, etx)
    }
}