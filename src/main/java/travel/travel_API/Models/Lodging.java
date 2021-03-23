package travel.travel_API.Models;

import travel.travel_API.Enums.TypeOfLodging;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lodging {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TypeOfLodging typeOfLodging;
    private String name;
    private String description;
    private Double pricePerNight;
    //private availability

    public Lodging() {
    }

    public Lodging(TypeOfLodging typeOfLodging, String name, String description, Double pricePerNight) {
        this.typeOfLodging = typeOfLodging;
        this.name = name;
        this.description = description;
        this.pricePerNight = pricePerNight;
    }

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
