package com.example.dbservice.repository;

import com.example.dbservice.model.Thing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("thingRepository")
public interface ThingRepository extends JpaRepository<Thing, Integer> {

    List<Thing> findAll();
    List<Thing> findById(int id);


}
