package com.accela.interview.demo.service;

import com.accela.interview.demo.entity.Address;
import com.accela.interview.demo.entity.Person;
import com.accela.interview.demo.repository.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
        Optional<Address> p = Optional.of(new Address());
        p.get().setAddressid(1L);
        Mockito.when(addressRepository.findById(1L)).thenReturn(Optional.of(p.get()));
        addressService.deleteAddressId("1");
    }

    @Test(expected = Exception.class)
    public void deleteAddressId_noIdFound_exception() throws Exception {
        Optional<Address> p = Optional.of(new Address());
        p.get().setAddressid(1L);
        addressService.deleteAddressId("1");
    }
}
