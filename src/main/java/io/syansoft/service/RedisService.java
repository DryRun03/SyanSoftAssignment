package io.syansoft.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RedisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisService.class);
    @Autowired
    private RedisTemplate<String, Map<String, String>> valueOperations;


    //@Todo:- Add env profile to the method
    public void saveTokenInRedis(String userName, String accessToken) {
//        if(env.getActiveProfile().equals(PROD) || env.getActiveProfile().equals(DEV)) {
        Map<String, String> userTokensFromDifferentMachine = valueOperations.opsForValue().get(userName);
        String tokenKey = getTokenKey(accessToken);
        if(Optional.ofNullable(userTokensFromDifferentMachine).isPresent()) {
            userTokensFromDifferentMachine.put(tokenKey, accessToken);
        } else {
            userTokensFromDifferentMachine = new HashMap<>();
            userTokensFromDifferentMachine.put(tokenKey, accessToken);
        }
        valueOperations.opsForValue().set(userName, userTokensFromDifferentMachine);
        LOGGER.info("saved user token into redis");
//        }
    }

    public void invalidateAllTokenOfUser(String userName) {
//        if(env.getActiveProfile().equals(PROD) || env.getActiveProfile().equals(DEV)) {
        valueOperations.delete(userName);
//        }
    }

    private String getTokenKey(String accessToken) {
        String[] tokenSplitString = accessToken.split("\\.");
        return tokenSplitString[tokenSplitString.length - 1].toLowerCase();
    }



    public boolean verifyTokenInRedisServer(String userName, String accessToken) {
        Map<String, String> userTokensFromDifferentMachine = valueOperations.opsForValue().get(userName);
        boolean validToken = false;
        if(userTokensFromDifferentMachine != null) {
            String userAccessToken = userTokensFromDifferentMachine.get(getTokenKey(accessToken));
            if(accessToken.equalsIgnoreCase(userAccessToken)) validToken = true;
        }
        return validToken;
    }

    public boolean removeUserTokenFromRedisByUserNameAndToken(String userName,  String accessToken) {
        boolean tokenRemoved = false;
        Map<String, String> userTokensFromDifferentMachine = valueOperations.opsForValue().get(userName);
        if(Optional.ofNullable(userTokensFromDifferentMachine).isPresent()) {
            String tokenKey = getTokenKey(accessToken);
            if(userTokensFromDifferentMachine.size() == 1) valueOperations.delete(userName);
            else {
                if(userTokensFromDifferentMachine.containsKey(tokenKey)) {
                    if (!userTokensFromDifferentMachine.get(tokenKey).equalsIgnoreCase(accessToken))
                        return false;

                    userTokensFromDifferentMachine.remove(tokenKey);
                    valueOperations.opsForValue().set(userName, userTokensFromDifferentMachine);
                }
            }
            tokenRemoved = true;
        } else return false;
        return tokenRemoved;
    }
}
