package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/year/{year}")
    public List<Whisky> findWhiskiesByYear(@PathVariable int year){
        return whiskyRepository.findWhiskyByYear(year);
    }

    @GetMapping(value = "/{distilleryId}/{age}")
    public List<Whisky> findWhiskiesFromASpecificDistilleryWithACertainAge(@PathVariable Long distilleryId, @PathVariable int age){
        return whiskyRepository.findWhiskysOfACertainAgeFromASpecificDistillery(distilleryId, age);
    }

    @GetMapping(value = "/region/{distilleryRegion}")
    public List<Whisky> findWhiskiesByRegion(@PathVariable String distilleryRegion){
        return whiskyRepository.findWhiskiesByRegion(distilleryRegion);
    }

}
