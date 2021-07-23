package br.com.iteris.auth;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Paths {

    public static final String AUTH = "/auth";

    public static final String AUTH_TOKEN = AUTH + "/{token}";

}
