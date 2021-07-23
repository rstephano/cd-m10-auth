package br.com.iteris.auth.controller;

import br.com.iteris.auth.Paths;
import br.com.iteris.auth.dto.response.AuthResponse;
import br.com.iteris.auth.services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.annotation.ContinueSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @ContinueSpan(log = "authMethod")
    @GetMapping(path = Paths.AUTH_TOKEN)
    public ResponseEntity<AuthResponse> auth(@PathVariable @SpanTag("token") String token) {
        var authDTO = authService.findByToken(token);
        return ResponseEntity.ok( //
            AuthResponse.builder() //
                .userId(authDTO.getUserId()) //
                .username(authDTO.getUsername()) //
                .scope(authDTO.getScope()) //
                .build() //
        );
    }

}
