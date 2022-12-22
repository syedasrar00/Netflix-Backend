package com.netflix.backend.services.implementation;

import com.netflix.backend.entities.Token;
import com.netflix.backend.repositories.TokenRepository;
import com.netflix.backend.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImplementation implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;
    @Override
    public void createToken(String tokenId, String userName, String jwt) {
        tokenRepository.save(new Token(tokenId,userName,jwt));
    }
    public void updateToken(Token token){
        tokenRepository.save(token);
    }

    @Override
    public Token getToken(String userName) {
        return tokenRepository.findByUserName(userName).orElse(null);
    }

    @Override
    public void deleteToken(Token token) {
        tokenRepository.delete(token);
    }

    @Override
    public Token getTokenByJwt(String jwtToken) {
        return tokenRepository.findByJwt(jwtToken.substring(7)).orElse(null);
    }
}
