package com.home_server.repositories.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home_server.domain.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
