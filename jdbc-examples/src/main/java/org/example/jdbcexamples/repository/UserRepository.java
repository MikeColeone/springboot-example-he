package org.example.jdbcexamples.repository;

import lombok.Data;
import org.example.jdbcexamples.dox.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    // 查询用户姓名以及对应的address个数，并按姓名正序排序（默认升序）
    @Query("""
            SELECT u.name, COUNT(a.id) AS address_count
            FROM user u
            LEFT JOIN address a ON u.id = a.user_id
            GROUP BY u.name
            ORDER BY u.name
            """)
    List<Map<String, Object>> findUserNamesWithAddressCount();
}
