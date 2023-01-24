package api.dtos;

import java.util.ArrayList;

public class CarBrandsDTO {

    private String brand;
    private ArrayList<String> models;

    public CarBrandsDTO() {

    }

    public CarBrandsDTO(String brand, ArrayList<String> models) {
        this.brand = brand;
        this.models = models;
    }

    public String getBrand() {
        return brand;
    }

    public ArrayList<String> getModels() {
        return models;
    }

    @Override
    public String toString() {
        return getBrand();
    }
}
