package com.netflix.backend.services;

import com.netflix.backend.entities.Token;

public interface TokenService {
    void createToken(String tokenId, String userName,  String jwt);
    public void updateToken(Token token);
    Token getToken(String userName);

    void deleteToken(Token token);

    Token getTokenByJwt(String jwtToken);
}
