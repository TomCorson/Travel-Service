package travel.travel_API.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import travel.travel_API.SecurityModel.JwtUser;

@Component
public class JwtGenerator {
    public String generate(JwtUser jwtUser){
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId",String.valueOf(jwtUser.getUserId()));
        claims.put("role",jwtUser.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS384,System.getenv("SECRET"))
                .compact();
    }
}
