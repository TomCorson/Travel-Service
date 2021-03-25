package travel.travel_API.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.travel_API.Models.Lodging;
import travel.travel_API.Repos.LodgingRepo;

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
}
