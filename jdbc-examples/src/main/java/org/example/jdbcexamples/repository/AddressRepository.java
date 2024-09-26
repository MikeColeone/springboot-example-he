package org.example.jdbcexamples.repository;

import org.example.jdbcexamples.dox.Address;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

    // 根据用户 ID 查询地址列表
    @Query("SELECT * FROM address a WHERE a.user_id = :userId")
    List<Address> findByUserId(String userId);

}
