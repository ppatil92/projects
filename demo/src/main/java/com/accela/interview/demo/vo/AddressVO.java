package com.accela.interview.demo.vo;

import com.accela.interview.demo.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class AddressVO {
    private List<Address> addressList;
    private String personId;
}
