package com.example.addressbookexample;

import com.example.addressbookexample.dao.AddressRepository;
import com.example.addressbookexample.domain.AddressEntry;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Log
@SpringBootApplication
public class AddressBookExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(AddressRepository repository){
        return (args) -> {
            val address = new AddressEntry();
            address.setFirstName("first");
            address.setLastName("last");
            address.setAddress("123 fake street");
            address.setPhoneNumber("1234567890");

            repository.save(address);


            val address2 = new AddressEntry();
            address2.setFirstName("second");
            address2.setLastName("last");
            address2.setAddress("123 fake street");
            address2.setPhoneNumber("0987654321");

            repository.save(address2);


            val address3 = new AddressEntry();
            address3.setFirstName("third");
            address3.setLastName("last2");
            address3.setAddress("123 sesame street");
            address3.setPhoneNumber("5555555555");

            repository.save(address3);

            log.info("TEST");


            repository.findAll().forEach(addressEntry -> {
                log.info(addressEntry.toString());
            });

            repository.findByAddressContaining("fake").stream().forEach(addy->{
                log.info(addy.toString());
            });

        };
    }
}
