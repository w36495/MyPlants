package com.w36495.myplants;

import java.io.Serializable;

public class Plant implements Serializable {

    private String plantName;
    private String plantDate;
    private String plantMemo;

    public Plant(String plantName, String plantDate, String plantMemo) {
        this.plantName = plantName;
        this.plantDate = plantDate;
        this.plantMemo = plantMemo;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getPlantDate() {
        return plantDate;
    }

    public void setPlantDate(String plantDate) {
        this.plantDate = plantDate;
    }

    public String getPlantMemo() {
        return plantMemo;
    }

    public void setPlantMemo(String plantMemo) {
        this.plantMemo = plantMemo;
    }
}
