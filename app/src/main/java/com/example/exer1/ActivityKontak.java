package com.example.exer1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityKontak extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, SearchView.OnQueryTextListener {
    private ListView list;
    private ArrayAdapter<String> stringArrayAdapter;
    private  AdapterList adapter;
    String nama;
    private  SearchView svCari;
    String[] listNama;
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    Bundle b = new Bundle();
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);
        listNama = new String[]{"Inayah","Ilham","Eris","Fikri","Maul",
                "Intan","Vina","Gita","Vian","Lutfi"};

        list = findViewById(R.id.listkontak);

        classNamaArrayList = new ArrayList<>();
        int i = 0;
        while (true){
            String[] strArr = listNama;
            if (i< strArr.length){
                classNamaArrayList.add(new ClassNama(strArr[i]));
                i++;
            } else {
                adapter = new AdapterList(this);
                list.setAdapter(adapter);
                SearchView searchView = findViewById(R.id.search);
                svCari = searchView;
                searchView.setOnQueryTextListener(this);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String nama = classNamaArrayList.get(position).getNama();
                        b.putString("a",nama.trim());
                        PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                        pm.setOnMenuItemClickListener(ActivityKontak.this);
                        pm.inflate(R.menu.popup_menu);
                        pm.show();
                    }
                });
                return;
            }
        }
    }
    @Override
    public  boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                i = new Intent(getApplicationContext(),ActivityLihatData.class);
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"Ga Nemu Caranya Bang",Toast.LENGTH_LONG).show();
                //if
        }
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String x) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String x) {
        adapter.filterSearch(x);
        return false;
    }
}