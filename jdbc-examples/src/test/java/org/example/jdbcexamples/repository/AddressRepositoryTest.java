package org.example.jdbcexamples.repository;

import lombok.extern.slf4j.Slf4j;
import org.example.jdbcexamples.dox.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    private Address testAddress;


    @Test
    void saveAddress() {
        Address savedAddress = addressRepository.save(testAddress);
        assertNotNull(savedAddress);
        log.debug("Saved address: {}", savedAddress);
    }

    @Test
    void findByUserId() {
        List<Address> addresses = addressRepository.findByUserId("1283955714800693248");
        assertFalse(addresses.isEmpty());
        for (Address address : addresses) {
            log.debug("Address: {}", address);
        }
    }

    @Test
    void findById() {
        Address address = addressRepository.findById("1").orElse(null);
        assertNotNull(address);
        log.debug("Found address: {}", address);
    }

    @Test
    void deleteAddress() {
        addressRepository.deleteById("test_id");
        Address address = addressRepository.findById("2").orElse(null);
        assertNull(address);
        log.debug("Address deleted: {}", address);
    }
}
