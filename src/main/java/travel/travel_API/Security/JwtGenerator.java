package travel.travel_API.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import travel.travel_API.SecurityModel.JwtUser;

import java.time.Instant;
import java.util.Date;

@Component
public class JwtGenerator {
    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);

    public String generate(JwtUser jwtUser){
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId",String.valueOf(jwtUser.getUserId()));
        claims.put("role",jwtUser.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(nowMillis + 2000))
                .signWith(SignatureAlgorithm.HS384,System.getenv("SECRET"))
                .compact();
    }
}













