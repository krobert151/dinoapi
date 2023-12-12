package com.rebolledonaharro.dinoapi.security.blacklist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlackListRepository extends CrudRepository<TokenBlackList, String> {


}
