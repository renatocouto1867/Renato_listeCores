package com.example.renato_listecores;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout layoutPrincipal;
    private ListView listViewCores;
    private  String[] cores;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listViewCores=findViewById(R.id.listView1);
        preencherLista();
        preencherAdapter();
        listViewCores.setAdapter(adapter);
        layoutPrincipal = findViewById(R.id.main);
        listViewCores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String cor = corSelecionda(((TextView) view).getText().toString());
                layoutPrincipal.setBackgroundColor(Color.parseColor(cor));
            }
        });

    }

    private void preencherAdapter(){
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,cores);
    }

    private void preencherLista(){
        Resources res = getResources();
        cores = res.getStringArray(R.array.cores_Array);
    }

    private String corSelecionda(String cor){
        switch (cor){
            case "Vermelho":
                return "#FF0000";
            case "Verde":
                return "#00FF00";
            case "Azul":
                return "#5175D1";
            case "Amarelo":
                return "#FFFF00";
            case "Laranja":
                return "#FFA500";
            default:
                return "#757575";
        }
    }
}