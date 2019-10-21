package com.example.controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;



public class actividad_2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_2);
        cargarLista();

    }

    private void cargarLista(){
        final Webs [] webs = new Webs[] {
                new Webs(1,"Google", "https://google.com", getResources().getIdentifier("google", "drawable", getPackageName())),
                new Webs(2,"Youtube", "https://www.youtube.com", getResources().getIdentifier("youtube", "drawable", getPackageName())),
                new Webs(3,"Bing", "https://www.bing.com", getResources().getIdentifier("bing", "drawable", getPackageName())),
                new Webs(4,"PcComponentes","https://www.pccomponentes.com", getResources().getIdentifier("pc", "drawable", getPackageName()))
        };


        AdaptadorWebs adapter = new AdaptadorWebs(this, webs);
        ListView lv = (ListView) findViewById(R.id.listaWebs);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = webs[position].getUrl();

                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
