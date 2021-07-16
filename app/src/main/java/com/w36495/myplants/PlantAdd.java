package com.w36495.myplants;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PlantAdd extends AppCompatActivity {
    private static int PLANT_ADD = 0;
    private static int PLANT_UPDATE = 1;


    private EditText input_plant_name;
    private EditText input_plant_date;
    private EditText input_plant_memo;
    private Button btn_plant_add;

    private String inputPlantName;
    private String inputPlantDate;
    private String inputPlantMemo;

    private int flag = 0;
    private int plantPosition;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_add);

        init();
    }



    protected void init() {

        input_plant_name = findViewById(R.id.input_plant_name);
        input_plant_date = findViewById(R.id.input_plant_date);
        input_plant_memo = findViewById(R.id.input_plant_memo);
        btn_plant_add = findViewById(R.id.btn_plant_add);


        btn_plant_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputPlantName = input_plant_name.getText().toString();
                inputPlantDate = input_plant_date.getText().toString();
                inputPlantMemo = input_plant_memo.getText().toString();


                // 데이터 추가 -> 메인액티비티로 데이터 전달
                Intent intent = new Intent(PlantAdd.this, MainActivity.class);
                intent.putExtra("name", inputPlantName);
                intent.putExtra("date", inputPlantDate);
                intent.putExtra("memo", inputPlantMemo);
                setResult(RESULT_OK, intent);
                finish();

            }
        });





    }


}
