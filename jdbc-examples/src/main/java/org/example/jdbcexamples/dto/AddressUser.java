package org.example.jdbcexamples.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dox.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressUser {
    private User user;
    private Address address;
}