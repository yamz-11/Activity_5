package com.example.activity_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ListView list;
    private ListViewAdapter adapter;
    String[] listNama;
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    Bundle bundle = new Bundle();
    Intent intent;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listNama = new String[]{"Muhammad", "Athallariq", "Wira", "Tama", "Arya", "Ditya"};


        list = findViewById(R.id.listKontak);

        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i <listNama.length; i++){
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }

        adapter = new ListViewAdapter(this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String nama = classNamaArrayList.get(position).getNama();

                bundle.putString("a", nama.trim());

                PopupMenu pm = new PopupMenu(getApplicationContext(),view);

                pm.setOnMenuItemClickListener(HomeActivity.this);

                pm.inflate(R.menu.popup_menu);

                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),HasilActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"Ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}
