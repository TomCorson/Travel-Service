package travel.travel_API.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import travel.travel_API.Services.LodgingService;

@RestController
public class LodgingController {

    @Autowired
    private LodgingService lodgingService;
}
