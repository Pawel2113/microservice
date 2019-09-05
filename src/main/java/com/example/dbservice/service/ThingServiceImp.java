package com.example.dbservice.service;

import com.example.dbservice.model.Thing;
import com.example.dbservice.repository.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("thingService")
public class ThingServiceImp implements ThingService{

    @Autowired
    private ThingRepository thingRepository;


    @Override
    public void saveThing(Thing thing) {
        thingRepository.save(thing);
    }
}
