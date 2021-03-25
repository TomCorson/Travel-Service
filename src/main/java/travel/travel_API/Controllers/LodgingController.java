package travel.travel_API.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import travel.travel_API.Models.Lodging;
import travel.travel_API.Services.LodgingService;

import java.util.List;

@RestController
public class LodgingController {

    @Autowired
    private LodgingService lodgingService;

    @GetMapping
    public List<Lodging> getAllLodging(){
        return lodgingService.getAllLodging();
    }
    @PostMapping
    public boolean createLodging(@RequestBody Lodging lodging){
        return lodgingService.createLodging(lodging);
    }
    @DeleteMapping("/{id}")
    public boolean deleteLodging(@PathVariable Long id){
        return lodgingService.deleteLodging(id);
    }
}
