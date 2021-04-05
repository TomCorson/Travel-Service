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
            Lodging updatedLodging = new Lodging();
            updatedLodging.setId(lodging.get().getId());
            updatedLodging.setTypeOfLodging(lodging.get().getTypeOfLodging());
            updatedLodging.setName(lodging.get().getName());
            updatedLodging.setDescription(lodging.get().getDescription());
            updatedLodging.setPricePerNight(lodging.get().getPricePerNight());

            ArrayList<Date> combinedDates = lodging.get().getDatesBooked();
            combinedDates.addAll(dates);
            updatedLodging.setDatesBooked(combinedDates);
            lodgingRepo.save(updatedLodging);
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
}














