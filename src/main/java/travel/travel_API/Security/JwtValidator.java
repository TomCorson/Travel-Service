package travel.travel_API.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import travel.travel_API.SecurityModel.JwtUser;

import java.util.Date;

@Component
public class JwtValidator {
    private String secret = System.getenv("SECRET");

    public JwtUser validate(String token) {
        JwtUser jwtUser = null;
        try{
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Long.parseLong((String)body.get("userId")));
            jwtUser.setRole((String)body.get("role"));
        }
        catch (Exception e){
            System.out.println(e);
        }
        return jwtUser;
    }
}
