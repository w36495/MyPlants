package com.w36495.myplants;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class PlantInfoDialog extends Dialog {

    private Context context;
    private TextView plant_info_type, plant_info_smell, plant_info_poison, plant_info_level, plant_info_require,
            plant_info_growthRate, plant_info_growthTemperature, plant_info_temperature, plant_info_humidity,
            plant_info_fertilizer, plant_info_spring, plant_info_summer, plant_info_fall, plant_info_winter;
    private Button plant_info_close;

    public PlantInfoDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_info);

        plant_info_type = findViewById(R.id.plant_info_type);
        plant_info_smell = findViewById(R.id.plant_info_smell);
        plant_info_poison = findViewById(R.id.plant_info_poison);
        plant_info_level = findViewById(R.id.plant_info_level);
        plant_info_require = findViewById(R.id.plant_info_require);
        plant_info_growthRate = findViewById(R.id.plant_info_growthRate);
        plant_info_growthTemperature = findViewById(R.id.plant_info_growthTemperature);
        plant_info_temperature = findViewById(R.id.plant_info_temperature);
        plant_info_humidity = findViewById(R.id.plant_info_humidity);
        plant_info_fertilizer = findViewById(R.id.plant_info_fertilizer);
        plant_info_spring = findViewById(R.id.plant_info_spring);
        plant_info_summer = findViewById(R.id.plant_info_summer);
        plant_info_fall = findViewById(R.id.plant_info_fall);
        plant_info_winter = findViewById(R.id.plant_info_winter);
        plant_info_close = findViewById(R.id.plant_info_close);

        // 닫힘 버튼
        plant_info_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }
}
