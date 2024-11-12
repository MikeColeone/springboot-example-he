package org.example.backendexamples.repository;

import lombok.Data;
import org.example.backendexamples.dox.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends ListCrudRepository<User, String> {

   User findByAccount(String account);

}
