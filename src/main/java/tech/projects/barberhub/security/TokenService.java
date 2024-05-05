package tech.projects.barberhub.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tech.projects.barberhub.constants.authentication.AuthenticationConstants;
import tech.projects.barberhub.exceptions.security.InvalidTokenException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(String subject, String role){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("barber")
                    .withSubject(subject)
                    .withExpiresAt(this.generateExpirationDate())
                    .withClaim("role", role)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error while authenticating");
        }
    }

    public String getEmailFromJWT(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("barber")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new InvalidTokenException("Invalid token");
        }
    }

    public String getRoleFromJWT(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            Claim claim = JWT.require(algorithm)
                    .withIssuer("barber")
                    .build()
                    .verify(token)
                    .getClaim("role");
            return claim.asString();
        } catch (JWTVerificationException exception) {
            return null;
        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}