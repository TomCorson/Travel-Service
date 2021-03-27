package travel.travel_API.Models;
import travel.travel_API.Enums.TypeOfLodging;
import javax.persistence.*;
import java.util.ArrayList;
import java.sql.Date;



@Entity
public class Lodging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeOfLodging typeOfLodging;
    private String name;
    private String description;
    private Double pricePerNight;
    private ArrayList<Date> datesBooked;

    public Lodging() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lodging(Long id, TypeOfLodging typeOfLodging, String name, String description, Double pricePerNight, ArrayList<Date> datesBooked) {
        this.id = id;
        this.typeOfLodging = typeOfLodging;
        this.name = name;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.datesBooked = datesBooked;
    }

    public ArrayList<Date> getDatesBooked() {
        return datesBooked;
    }

    public void setDatesBooked(ArrayList<Date> datesBooked) {
        this.datesBooked = datesBooked;
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
