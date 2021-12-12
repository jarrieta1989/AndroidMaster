package com.example.androidmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Principal extends AppCompatActivity {

    ListView lista;
    String[][] datos = {
            {"Torre del Reloj", "Cartagena", "5,890", "10", "La Puerta del Reloj, Torre del Reloj o Boca del Puente o Plaza Internacional Carlos Campillo es la puerta de entrada principal al centro histórico de Cartagena de Indias en Colombia y la entrada original a la ciudad fortificada."},
            {"Playa de Bocagrande", "Cartagena", "7,962", "7", "Popular playa urbana con bares y restaurantes"},
            {"Castillo San Felipe de Barajas", "Cartagena", "42,534", "8", "El Castillo San Felipe de Barajas es una fortificación localizada en la ciudad de Cartagena de Indias en Colombia. Su nombre real es Fuerte de San Felipe de Barajas."},
            {"Plaza Santo Domingo", "Cartagena", "7,176", "7", "Animada plaza con escultura de Botero"},
            {"Islas del Rosario", "Cartagena", "73", "9", "Las islas del Rosario es un pequeño archipiélago formado por unas 28 islas, ​ que es parte de la zona insular de Cartagena de indias, ​​​ con una superficie terrestre de 20 hectáreas ubicado frente a las costas del Departamento de Bolívar, a la misma latitud que la península de Barú."},
            {"Las Bovedas", "Cartagena", "5,204", "8", "Antiguas mazmorras con tiendas"}
    };

    int[] datosImg = {R.drawable.torre, R.drawable.playa, R.drawable.castillo, R.drawable.plaza, R.drawable.isla, R.drawable.bovedas};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        lista = (ListView) findViewById(R.id.IvLista);
        lista.setAdapter(new Adaptador(this,datos,datosImg));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), DetallesPelicula.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][4]);
                startActivity(visorDetalles);
            }
        });
    }
}