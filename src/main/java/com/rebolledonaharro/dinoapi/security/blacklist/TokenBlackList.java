package com.rebolledonaharro.dinoapi.security.blacklist;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("token_black_list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenBlackList {

    @Id
    private String id;

    @Indexed
    private String token;


}
