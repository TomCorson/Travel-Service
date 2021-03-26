package travel.travel_API.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travel.travel_API.Security.JwtGenerator;
import travel.travel_API.SecurityModel.JwtUser;

@RestController
@RequestMapping("/signOn")
public class JwtTokenController {

    private JwtGenerator jwtGenerator;

    public JwtTokenController(JwtGenerator jwtGenerator){
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser){
        return jwtGenerator.generate(jwtUser);
    }
}
