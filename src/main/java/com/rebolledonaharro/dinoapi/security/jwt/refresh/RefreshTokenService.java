package com.rebolledonaharro.dinoapi.security.jwt.refresh;

import com.rebolledonaharro.dinoapi.usuario.model.Person;
import com.rebolledonaharro.dinoapi.usuario.service.PersonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository repository;

    private final PersonService personService;

    @Value("${jwt.refresh.duration}")
    private int durationInMinutes;

    public Optional<RefreshToken> findByToken(String token){
        return repository.findByToken(token);
    }

    @Transactional
    public int deleteByPerson(Person person){
        return repository.deleteByPerson(person);
    }

    public RefreshToken createRefresjToken(Person person){


        RefreshToken refreshToken = RefreshToken.builder()
                .person(person)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusSeconds(durationInMinutes* 60L))
                .build();

        return repository.save(refreshToken);


    }

    public RefreshToken verify(RefreshToken refreshToken){

        if(refreshToken.getExpiryDate().compareTo(Instant.now())>0){
            repository.delete(refreshToken);
            throw new RefreshTokenException("Expried reresk token");
        }

        return refreshToken;


    }


}
