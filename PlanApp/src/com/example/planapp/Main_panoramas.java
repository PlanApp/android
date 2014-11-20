package com.example.planapp;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main_panoramas extends Activity {

	private ListView lista; 
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_panoramas);
	
	    ArrayList<Lista_panoramas> datos = new ArrayList<Lista_panoramas>();  

	    datos.add(new Lista_panoramas(R.drawable.ic_launcher, "BUHO", "B�ho es el nombre com�n de aves de la familia Strigidae, del orden de las estrigiformes o aves rapaces nocturnas. Habitualmente designa especies que, a diferencia de las lechuzas, tienen plumas alzadas que parecen orejas."));
        datos.add(new Lista_panoramas(R.drawable.ic_launcher, "COLIBR�", "Los troquilinos (Trochilinae) son una subfamilia de aves apodiformes de la familia Trochilidae, conocidas vulgarmente como colibr�es, quindes, tucusitos, picaflores, chupamirtos, chuparrosas, huichichiquis (idioma nahuatl), mainumby (idioma guaran�) o guanumby. Conjuntamente con las ermitas, que pertenecen a la subfamilia Phaethornithinae, conforman la familia Trochilidae que, en la sistem�tica de Charles Sibley, se clasifica en un orden propio: Trochiliformes, independiente de los vencejos del orden Apodiformes. La subfamilia Trochilinae incluye m�s de 100 g�neros que comprenden un total de 330 a 340 especies."));
        datos.add(new Lista_panoramas(R.drawable.ic_launcher, "CUERVO", "El cuervo com�n (Corvus corax) es una especie de ave paseriforme de la familia de los c�rvidos (Corvidae). Presente en todo el hemisferio septentrional, es la especie de c�rvido con la mayor superficie de distribuci�n. Con el cuervo de pico grueso, es el mayor de los c�rvidos y probablemente la paseriforme m�s pesada; en su madurez, el cuervo com�n mide entre 52 y 69 cent�metros de longitud y su peso var�a de 0,69 a 1,7 kilogramos. Los cuervos comunes viven generalmente de 10 a 15 a�os pero algunos individuos han vivido 40 a�os. Los juveniles pueden desplazarse en grupos pero las parejas ya formadas permanecen juntas toda su vida, cada pareja defendiendo un territorio. Existen 8 subespecies conocidas que se diferencian muy poco aparentemente, aunque estudios recientes hayan demostrado diferencias gen�ticas significativas entre las poblaciones de distintas regiones."));
        datos.add(new Lista_panoramas(R.drawable.ic_launcher, "FLAMENCO", "Los fenicopteriformes (Phoenicopteriformes), los cuales reciben el nombre vulgar de flamencos, son un orden de aves neognatas, con un �nico g�nero viviente: Phoenicopterus. Son aves que se distribuyen tanto por el hemisferio occidental como por el hemisferio oriental: existen cuatro especies en Am�rica y dos en el Viejo Mundo. Tienen cr�neo desmognato holorrino, con 16 a 20 v�rtebras cervicales y pies anisod�ctilos."));
        datos.add(new Lista_panoramas(R.drawable.ic_launcher, "KIWI", "Los kiwis (Apterix, gr. 'sin alas') son un g�nero de aves paleognatas compuesto por cinco especies end�micas de Nueva Zelanda.1 2 Son aves no voladoras peque�as, aproximadamente del tama�o de una gallina. Antes de la llegada de los humanos alrededor del a�o 1300, en Nueva Zelanda los �nicos mam�feros que hab�a eran murci�lagos, y los nichos ecol�gicos que en otras partes del mundo eran ocupados por animales tan diversos como caballos, lobos y ratones fueron utilizados en Nueva Zelanda por p�jaros (y en menor proporci�n por ciertas especies de reptiles). La denominaci�n kiwi es maor�, idioma del pueblo hom�nimo de linaje malayopolinesio que coloniz� Nueva Zelanda antes de la llegada de los europeos."));
        datos.add(new Lista_panoramas(R.drawable.ic_launcher, "LORO", "Las Psit�cidas (Psittacidae) son una familia de aves psitaciformes llamadas com�nmente loros o papagayos, e incluye a los guacamayos, las cotorras, los periquitos, los agapornis y formas afines."));
        datos.add(new Lista_panoramas(R.drawable.ic_launcher, "PAVO", "Pavo es un g�nero de aves galliformes de la familia Phasianidae, que incluye dos especies, el pavo real com�n (Pavo cristatus) y el pavo real cuelliverde (Pavo muticus).1"));
        datos.add(new Lista_panoramas(R.drawable.ic_launcher, "PING�INO", "Los ping�inos (familia Spheniscidae, orden Sphenisciformes) son un grupo de aves marinas, no voladoras, que se distribuyen �nicamente en el Hemisferio Sur, sobre todo en sus altas latitudes."));

        lista = (ListView) findViewById(R.id.listado_panorama);
        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada_panoramas, datos){
			@Override
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.titulo); 
		            if (texto_superior_entrada != null) 
		            	texto_superior_entrada.setText(((Lista_panoramas) entrada).get_textoEncima()); 

		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.descripcion); 
		            if (texto_inferior_entrada != null)
		            	texto_inferior_entrada.setText(((Lista_panoramas) entrada).get_textoDebajo()); 

		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            if (imagen_entrada != null)
		            	imagen_entrada.setImageResource(((Lista_panoramas) entrada).get_idImagen());
		        }
			}
		});

        lista.setOnItemClickListener(new OnItemClickListener() { 
			@Override
			public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
				Lista_panoramas elegido = (Lista_panoramas) pariente.getItemAtPosition(posicion); 

                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                Toast toast = Toast.makeText(Main_panoramas.this, texto, Toast.LENGTH_LONG);
                toast.show();
			}
        });

    }
	
}
