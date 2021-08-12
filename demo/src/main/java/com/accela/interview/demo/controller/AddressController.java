package com.accela.interview.demo.controller;

import com.accela.interview.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable String id) throws Exception {
        addressService.deleteAddressId(id);
    }
}
