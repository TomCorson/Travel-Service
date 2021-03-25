package travel.travel_API.Security;

import org.springframework.security.authentication.AuthenticationManager;

public class JwtAuthenticationTokenFilter {
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
    }

    public void setAuthenticationSuccessHandler(JwtSuccessHandler jwtSuccessHandler) {
    }
}
