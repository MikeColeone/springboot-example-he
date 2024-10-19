package org.example.jdbcexamples.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.jdbcexamples.dox.Address;
import org.example.jdbcexamples.dox.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;


    //查询测试
    @Test
    void findByUserId() {
        List<Address> addresses = addressRepository.findByUserId("1283955714800693248");
        for (Address address : addresses) {
            log.debug("Address: {}", address);
        }
    }


    //查询测试
    @Test
    void findById() {
        Address address = addressRepository.findById("1").orElse(null);
        log.debug("Found address: {}", address);
    }

    //删除测试
    @Test
    void deleteAddress() {
        addressRepository.deleteById("1");
        Address address = addressRepository.findById("1").orElse(null);
        log.debug("Address deleted: {}", address);
    }



    @Test
    void updateDetailUser() {
        addressRepository.updateDetail("110","1");
        Optional<Address> address = addressRepository.findById("1");
        address.ifPresent(System.out::println);

    }

    @Test
    public void saveAddress(){
        Address address = Address.builder().id("1").detail("100").build();
        addressRepository.save(address);
    }
}
