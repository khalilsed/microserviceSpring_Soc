package com.soc.school;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;

    @QueryMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody School school
    ) {
        service.saveSchool(school);
    }


    @QueryMapping
    public Iterable<School> findAllSchools() {
        return service.findAllSchools();
    }

    @MutationMapping
    public School saveSchool(@Argument String name, @Argument String alpha_two_code, @Argument String country, @Argument String web_pages, @Argument String domains, @Argument String stateProvince) {
        return service.saveSchool(name, alpha_two_code, country, web_pages, domains, stateProvince);
    }

    @QueryMapping
    public FullSchoolResponse findSchoolWithStudents(@Argument Integer schoolId) {
        System.out.println("schoolId: " + schoolId);
        FullSchoolResponse response = service.findSchoolsWithStudents(schoolId);
        System.out.println("GraphQL Response: " + response);
        return response;
    }


}
