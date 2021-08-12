package com.accela.interview.demo.service;

import com.accela.interview.demo.entity.Person;
import com.accela.interview.demo.repository.AddressRepository;
import com.accela.interview.demo.service.AddressService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * this class demonstrates test cases using mockito
 * and no need to load application context
 */
@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @InjectMocks
    AddressService addressService;

    @Mock
    AddressRepository addressRepository;

    @Test
    public void deleteAddressId_success() throws Exception {
        Optional<Person> p = Optional.of(new Person());
        p.get().setId(1L);
        Mockito.when(addressRepository.findById(1L)).thenReturn(Optional.of(p.get()));
        addressService.deleteAddressId("1");
    }

    @Test(expected = Exception.class)
    public void deleteAddressId_noIdFound_exception() throws Exception {
        Optional<Person> p = Optional.of(new Person());
        p.get().setId(1L);
        Mockito.when(addressRepository.findById(2L)).thenReturn(Optional.of(p.get()));
        addressService.deleteAddressId("1");
    }
}
