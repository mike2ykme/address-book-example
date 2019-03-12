package com.example.addressbookexample.controllers;

import com.example.addressbookexample.dao.AddressRepository;
import com.example.addressbookexample.domain.AddressEntry;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Log
@Controller
public class MainController {

    private AddressRepository repository;

    public MainController(AddressRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public String getAll(Model model){
        List<AddressEntry> addresses = new ArrayList<>();
//        this.repository.findAll().forEach(addresses::add);
        this.repository.findAll().forEach(addy->{
            log.info(addy.toString());
            addresses.add(addy);
        });
        model.addAttribute("addresses",addresses);
        return "all";
    }
}
