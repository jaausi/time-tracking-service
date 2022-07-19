package com.sirvja.timetrackingservice.controller;

import com.sirvja.timetrackingservice.model.Hour;
import com.sirvja.timetrackingservice.repository.HourRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HourController {
    private final HourRepository hourRepository;

    public HourController(HourRepository hourRepository){
        this.hourRepository = hourRepository;
    }

    @QueryMapping
    public List<Hour> allHours(){
        return hourRepository.findAll();
    }
}
