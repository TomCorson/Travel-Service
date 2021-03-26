package travel.travel_API.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import travel.travel_API.Models.Lodging;
import travel.travel_API.Services.LodgingService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lodging")
public class LodgingController {

    @Autowired
    private LodgingService lodgingService;

    @GetMapping
    public List<Lodging> getAllLodging(){
        return lodgingService.getAllLodging();
    }
    @GetMapping("/{id}")
    public Optional<Lodging> getLodging(@PathVariable Long id){
        return lodgingService.getLodging(id);
    }
    @PostMapping
    public boolean createLodging(@RequestBody Lodging lodging){
        return lodgingService.createLodging(lodging);
    }
    @DeleteMapping("/{id}")
    public boolean deleteLodging(@PathVariable Long id){
        return lodgingService.deleteLodging(id);
    }
    @PutMapping("/{id}")
    public String requestDates(@PathVariable Long id, @RequestBody List<Date> dates){
        return lodgingService.requestDates(id, dates);
    }
}
