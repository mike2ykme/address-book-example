package com.example.addressbookexample.dao;


import com.example.addressbookexample.domain.AddressEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<AddressEntry,Long> {
    List<AddressEntry> findByAddressContaining(String address);
}
