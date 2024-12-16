package com.soc.school;

import com.soc.school.client.StudentClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;

    public void saveSchool(School school) {
        repository.save(school);
    }

    public School saveSchool(String name, String alpha_two_code, String country, String web_pages, String domains, String stateProvince ) {
        School school = new School();
        school.setName(name);
        school.setAlpha_two_code(alpha_two_code);
        school.setCountry(country);
        school.setWeb_pages(web_pages);
        school.setDomains(domains);
        school.setStateProvince(stateProvince);
        return repository.save(school);
    }
/*
    @Transactional
    public void saveAll(List<School> universities) {
        repository.saveAll(universities);
    }*/

    public List<School> findAllSchools() {
        return repository.findAll();
    }


    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .alpha_two_code("NOT_FOUND")
                                .country("NOT_FOUND")
                                .web_pages("NOT_FOUND")
                                .domains("NOT_FOUND")
                                .stateProvince("NOT_FOUND")
                                .build()
                );
        System.out.println(school);
        var students = client.findAllStudentsBySchool(schoolId);
        System.out.println(students);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .country(school.getCountry())
                .students(students)
                .build();
    }


}
