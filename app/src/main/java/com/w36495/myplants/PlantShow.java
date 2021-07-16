package com.w36495.myplants;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class PlantShow extends AppCompatActivity implements View.OnClickListener {

    private TextView plant_show_name, plant_show_date, plant_show_memo;
    private ImageView plant_show_back, plant_show_info, plant_show_calendar, plant_show_update;
    private int plantPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);

        init();
    }

    protected void init() {

        plant_show_name = findViewById(R.id.plant_show_name);
        plant_show_date = findViewById(R.id.plant_show_date);
        plant_show_memo = findViewById(R.id.plant_show_memo);

        plant_show_back = findViewById(R.id.plant_show_back);
        plant_show_info = findViewById(R.id.plant_show_info);
        plant_show_calendar = findViewById(R.id.plant_show_calendar);
        plant_show_update = findViewById(R.id.plant_show_update);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras().getBundle("plantBundle");
        Plant plant = (Plant) bundle.getSerializable("plant");
        plantPosition = bundle.getInt("plantPosition");

        plant_show_name.setText(plant.getPlantName());
        plant_show_date.setText(plant.getPlantDate());
        plant_show_memo.setText(plant.getPlantMemo());

        // click event
        plant_show_back.setOnClickListener(this);
        plant_show_update.setOnClickListener(this);
        plant_show_info.setOnClickListener(this);
        plant_show_calendar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.plant_show_back : // 뒤로가기 버튼
                Toast.makeText(getApplicationContext(), "back", Toast.LENGTH_LONG).show();
                break;
            case R.id.plant_show_calendar : // 캘린더(물주기 표시) 버튼
                Toast.makeText(getApplicationContext(), "calendar", Toast.LENGTH_LONG).show();
                break;
            case R.id.plant_show_info : // 식물에 대한 자세한 정보 버튼
                PlantInfoDialog dialog = new PlantInfoDialog(PlantShow.this);
                dialog.setCanceledOnTouchOutside(true);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                dialog.show();
                break;
            case R.id.plant_show_update :   // 수정 버튼
                intent = new Intent(PlantShow.this, PlantAdd.class);
                intent.putExtra("name", plant_show_name.getText());
                intent.putExtra("date", plant_show_date.getText());
                intent.putExtra("memo", plant_show_memo.getText());
                intent.putExtra("position", plantPosition);
                startActivity(intent);
                finish();
                break;
        }
    }


}
