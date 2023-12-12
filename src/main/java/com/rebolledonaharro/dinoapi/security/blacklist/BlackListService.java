package com.rebolledonaharro.dinoapi.security.blacklist;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BlackListService  {

    private final BlackListRepository repository;

    public boolean isBlacklisted (String token){

        Iterable<TokenBlackList> iterable = repository.findAll();
        Iterator<TokenBlackList> iterator = iterable.iterator();

        while (iterator.hasNext()) {
            TokenBlackList x = iterator.next();
            if (x.getToken().equals(token)) {
                return true;
            }
        }

        return false;

    }

    public void addToBlackList (String token){

        TokenBlackList tokenBlackList = new TokenBlackList(null,token);

        repository.save(tokenBlackList);

    }




}