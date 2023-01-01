package api.pojos;

import java.util.ArrayList;

public class CarBrandsData {

    String brand;
    ArrayList<String> models;

    public CarBrandsData() {

    }

    public CarBrandsData(String brand, ArrayList<String> models) {
        this.brand = brand;
        this.models = models;
    }

    public String getBrand() {
        return brand;
    }

    public ArrayList<String> getModels() {
        return models;
    }
}
