package br.com.iteris.auth.services;

import br.com.iteris.auth.dto.Auth;
import br.com.iteris.auth.exceptions.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthService {

    private final Map<String, Auth> tokensDb;

    public Auth findByToken(String token) {
        log.info("Checking token {}", token);
        var auth = Optional.ofNullable(tokensDb.get(token)).orElseThrow(() -> { //
            log.error("Invalid token");
            return new InvalidTokenException();
        });
        log.info("Valid token. {}", auth.toString());
        return auth;
    }

}
