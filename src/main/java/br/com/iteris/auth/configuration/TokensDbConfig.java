package br.com.iteris.auth.configuration;

import br.com.iteris.auth.dto.Auth;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
@Configuration
public class TokensDbConfig {

    private static final String ADMIN_SCOPE = "admin";

    private final Faker faker;

    @Bean
    public Map<String, Auth> tokensDb() {
        var tokens = new HashMap<String, Auth>();
        var userIds = new AtomicLong(100L);
        tokens.put("21f1a62b-be8e-4ae9-8b4a-c2ded999fd32", //
                Auth.builder() //
                        .userId(userIds.getAndIncrement()) //
                        .username(faker.funnyName().name()) //
                        .scope(ADMIN_SCOPE) //
                        .build() //
        );
        tokens.put("77c75cca-4919-4d69-a6f7-8a8efc77a947", //
                Auth.builder() //
                        .userId(userIds.getAndIncrement()) //
                        .username(faker.funnyName().name()) //
                        .scope(ADMIN_SCOPE) //
                        .build() //
        );
        tokens.put("b3aea542-4ac5-4d69-9b48-7dd5506ccbc0", //
                Auth.builder() //
                        .userId(userIds.getAndIncrement()) //
                        .username(faker.funnyName().name()) //
                        .scope(ADMIN_SCOPE) //
                        .build() //
        );
        tokens.put("dcd8abbd-6104-4c7c-8037-a1cced6e5339", //
                Auth.builder() //
                        .userId(userIds.getAndIncrement()) //
                        .username(faker.funnyName().name()) //
                        .scope(ADMIN_SCOPE) //
                        .build() //
        );
        tokens.put("3f82ed73-85d0-40b1-8f07-2b033e4b9ad3", //
                Auth.builder() //
                        .userId(userIds.getAndIncrement()) //
                        .username(faker.funnyName().name()) //
                        .scope(ADMIN_SCOPE) //
                        .build() //
        );
        return tokens;
    }

}
