package com.rebolledonaharro.dinoapi.security.jwt.refresh;

import com.rebolledonaharro.dinoapi.usuario.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Person> {

    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByPerson(Person person);

}
