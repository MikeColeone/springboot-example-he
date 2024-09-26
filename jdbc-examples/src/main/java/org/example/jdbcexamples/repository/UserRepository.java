package org.example.jdbcexamples.repository;

import org.example.jdbcexamples.dox.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
}