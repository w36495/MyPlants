package com.w36495.myplants;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.BuddhistCalendar;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static int REQUEST_ADD = 1;
    private static int PLANT_ADD = 2;
    private static int PLANT_UPDATE = 3;

    private RecyclerView recyclerView;
    private PlantAdapter plantAdapter;

    private FloatingActionButton fab_plantAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    protected void init() {

        recyclerView = findViewById(R.id.recyclerView);


        plantAdapter = new PlantAdapter();
        recyclerView.setAdapter(plantAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ArrayList<Plant> plants = new ArrayList<>();
        plants.add(new Plant("행운목1", "2020/02/20", "첫식물"));
        plants.add(new Plant("행운목2", "2020/02/20", "첫식물"));
        plants.add(new Plant("행운목3", "2020/02/20", "첫식물"));

        for(Plant p : plants) {
            plantAdapter.plantAdd(p);
        }

        plantAdapter.setOnPlantItemClickListener(new OnPlantItemClickListener() {
            @Override
            public void onPlantItemClick(View view, int position) {
                Plant plant = plantAdapter.getItem(position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("plant", plant);
                bundle.putInt("plantPosition", position);
                Intent intent = new Intent(MainActivity.this, PlantShow.class);
                intent.putExtra("plantBundle", bundle);
                startActivity(intent);
            }
        });

        fab_plantAdd = findViewById(R.id.fab_plant_add);
        fab_plantAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlantAdd.class);
                startActivityForResult(intent, REQUEST_ADD);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ADD) {
            if (resultCode == RESULT_OK) {
                Plant plant = new Plant(data.getStringExtra("name"), data.getStringExtra("date"), data.getStringExtra("memo"));
                plantAdapter.plantAdd(plant);
            }
            plantAdapter.notifyDataSetChanged();
        }

    }
}