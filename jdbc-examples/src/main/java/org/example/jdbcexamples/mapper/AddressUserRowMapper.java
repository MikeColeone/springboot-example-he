package org.example.jdbcexamples.mapper;

import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dox.User;
import org.example.jdbcexamples.dto.AddressUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

//创建AddressUserMapper 实现接口Rowmapper
public class AddressUserRowMapper implements RowMapper<AddressUser> {

    @Override
    public AddressUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = User.builder()
                .id(rs.getString("u.id"))
                .name(rs.getString("name"))
                .createTime(rs.getObject("u.create_time", LocalDateTime.class))
                .build();
        Address address = Address.builder()
                .id(rs.getString("a.id"))
                .detail(rs.getString("detail"))
                .userId(rs.getString("a.user_id"))
                .createTime(rs.getObject("a.create_time", LocalDateTime.class))
                .build();
        return AddressUser.builder()
                .user(user)
                .address(address)
                .build();
    }
}