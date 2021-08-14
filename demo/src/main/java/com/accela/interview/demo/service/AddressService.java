package com.accela.interview.demo.service;

import com.accela.interview.demo.entity.Address;
import com.accela.interview.demo.entity.Person;
import com.accela.interview.demo.repository.AddressRepository;
import com.accela.interview.demo.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonService personService;

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Transactional
    public void addAddress(AddressVO addressVo) {
        List<Address> addressList = addressVo.getAddressList();
        ResponseEntity<Person> p = personService.getPersonById(addressVo.getPersonId());
        Person dbPerson = p.getBody();
        for (Address address:addressList) {
            Address address_temp = new Address();
            address_temp.setCity(address.getCity());
            address_temp.setPerson(dbPerson);
            addressRepository.save(address_temp);
        }
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
