package com.example.dbservice.repository;

import com.example.dbservice.model.Thing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("thingRepository")
public interface ThingRepository extends CrudRepository<Thing, Integer> {

    List<Thing> findAll();
    List<Thing> findById(int id);

}
