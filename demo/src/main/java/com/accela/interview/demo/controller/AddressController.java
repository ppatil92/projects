package com.accela.interview.demo.controller;

import com.accela.interview.demo.entity.Address;
import com.accela.interview.demo.entity.Person;
import com.accela.interview.demo.service.AddressService;
import com.accela.interview.demo.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable String id) throws Exception {
        addressService.deleteAddressId(id);
    }

    @PostMapping("/add")
    public void addAddress(@RequestBody AddressVO addressVO) {
        addressService.addAddress(addressVO);
    }

    @GetMapping("/getAllAddress")
    public @ResponseBody
    List<Address> getAllAddress() {
        return addressService.getAddresses();
    }


}
