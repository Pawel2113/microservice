package com.example.dbservice.controller;

import com.example.dbservice.model.Thing;
import com.example.dbservice.repository.ThingRepository;
import com.example.dbservice.service.ThingService;
import com.example.dbservice.validator.ThingRegisterValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class DBServiceResource {

    @Autowired
    private ThingService thingService;

    @Autowired
    private ThingRepository thingRepository;

    public DBServiceResource(ThingService thingService, ThingRepository thingRepository) {
        this.thingService = thingService;
        this.thingRepository = thingRepository;
    }

    @PostMapping(value = "/add")
    public List<Thing> addThing(@RequestBody final Thing thing, BindingResult result) {

    new ThingRegisterValidator().validate(thing, result);
        if (result.hasErrors()) {
            List<Thing> message = new ArrayList<Thing>();
            Thing messageObj = new Thing();
            messageObj.setName("Nazwa nie może być pusta");
            message.add(messageObj);
            return message;
        } else {
            thingService.saveThing(thing);
            return getThingById(thing.getId());
        }
    }

    @GetMapping(value = "/list")
    public List<Thing> getThings(){
        return getAllThings();
    }


    private List<Thing> getThingById(@PathVariable("id") final int id) {
        return thingRepository.findById(id).stream().collect(Collectors.toList());
    }


    private List<Thing> getAllThings() {
        return thingRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostConstruct
    private void createDb() {
        Thing thing1 = new Thing("szafa");
        Thing thing2 = new Thing("drzwi");
        thing1 = thingRepository.save(thing1);
        thing2 = thingRepository.save(thing2);
    }
}

