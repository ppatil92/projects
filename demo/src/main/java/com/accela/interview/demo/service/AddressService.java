package com.accela.interview.demo.service;

import com.accela.interview.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void addAddress() {

    }

    @Transactional
    public void deleteAddressId(String id) throws Exception {
        long inputId = Long.parseLong(id);
        addressRepository.findById(inputId).map(address -> {
            addressRepository.delete(address);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new Exception("id " + id + " not found"));
    }

}
