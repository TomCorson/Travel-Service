package travel.travel_API.Models;

import travel.travel_API.Enums.TypeOfLodging;

import javax.persistence.Entity;

@Entity
public class Lodging {

    private TypeOfLodging typeOfLodging;
    private String name;
    private String description;
    private Double pricePerNight;
    //private availability

    public TypeOfLodging getTypeOfLodging() {
        return typeOfLodging;
    }

    public void setTypeOfLodging(TypeOfLodging typeOfLodging) {
        this.typeOfLodging = typeOfLodging;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}
