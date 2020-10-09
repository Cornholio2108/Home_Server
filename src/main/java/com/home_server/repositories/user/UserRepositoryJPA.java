package com.home_server.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home_server.domain.user.User;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, Long> {

}
