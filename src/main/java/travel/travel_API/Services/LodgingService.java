package travel.travel_API.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.travel_API.Models.Lodging;
import travel.travel_API.Repos.LodgingRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LodgingService {
    @Autowired
    LodgingRepo lodgingRepo;

    public List<Lodging> getAllLodging() {
       return lodgingRepo.findAll();
    }

    public boolean createLodging(Lodging requestLodging) {
        Lodging savedLodging = new Lodging();
        savedLodging.setTypeOfLodging(requestLodging.getTypeOfLodging());
        savedLodging.setName(requestLodging.getName());
        savedLodging.setDescription(requestLodging.getDescription());
        savedLodging.setPricePerNight(requestLodging.getPricePerNight());
        savedLodging.setDatesBooked(requestLodging.getDatesBooked());

        lodgingRepo.save(savedLodging);
        return true;
    }

    public boolean deleteLodging(Long id) {
        lodgingRepo.deleteById(id);
        return true;
    }

    public Optional<Lodging> getLodging(Long id) {
        return lodgingRepo.findById(id);
    }




    //change database type to date
    public String requestDates(Long id, List<Date> dates) {
        Optional<Lodging> lodging = lodgingRepo.findById(id);
        if(dateIsAvailabile(dates,lodging)){
            ArrayList<Date> combinedDates = lodging.get().getDatesBooked();
            combinedDates.addAll(dates);
            updateLodgingDates(lodging, combinedDates);
            return "Booking successful";
        }
        else
            return "Dates unavailable";

    }
    public boolean dateIsAvailabile(List<Date> dates, Optional<Lodging> lodging){

       if(lodging.isPresent()) {
           ArrayList<Date> bookedDates = lodging.get().getDatesBooked();
           for(Date requestedDate: dates){
               if(bookedDates.contains(requestedDate))
                   return false;
           }
           return true;
       }
       else
           return false;
    }

    public String cancelBooking(Long id, List<Date> dates) {
        Optional<Lodging> lodging = lodgingRepo.findById(id);
        if(lodging.isPresent()){
            ArrayList<Date> bookedDates = lodging.get().getDatesBooked();
            for(Date dateToDelete: dates){
                if(bookedDates.contains(dateToDelete)){
                    bookedDates.remove(dateToDelete);
                    System.out.println("removed " + dateToDelete.toString());
                }
            }
            updateLodgingDates(lodging, bookedDates);
            return "Dates deleted";
        }
        else
            return "lodging id not found";
    }
    public void updateLodgingDates(Optional<Lodging> originalLodging, ArrayList<Date> newDates){
        Lodging updatedLodging = new Lodging();
        updatedLodging.setId(originalLodging.get().getId());
        updatedLodging.setTypeOfLodging(originalLodging.get().getTypeOfLodging());
        updatedLodging.setName(originalLodging.get().getName());
        updatedLodging.setDescription(originalLodging.get().getDescription());
        updatedLodging.setPricePerNight(originalLodging.get().getPricePerNight());
        updatedLodging.setDatesBooked(newDates);
        lodgingRepo.save(updatedLodging);
    }
}














