package com.soc.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import java.util.List;

@Endpoint
public class TeacherEndpoint {

    private static final String NAMESPACE_URI = "http://soc.com/teachers";

    @Autowired
    private TeacherService teacherService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllTeachersRequest")
    @ResponsePayload
    public GetAllTeachersResponse getAllTeachers(@RequestPayload GetAllTeachersRequest request) {
        List<Teacher> teachers = teacherService.getAllTeachers();

        // Construire la réponse
        GetAllTeachersResponse response = new GetAllTeachersResponse();
        for (Teacher teacher : teachers) {
            TeacherDTO dto = new TeacherDTO();
            dto.setTeacherID(teacher.getTeacherID());
            dto.setName(teacher.getName());
            dto.setAge(teacher.getAge());
            dto.setEmail(teacher.getEmail());
            dto.setSpecialite(teacher.getSpecialite());
            dto.setGrade(teacher.getGrade());
            dto.setPhoneNumber(teacher.getPhoneNumber());
            dto.setCin(teacher.getCin());
            response.getTeachers().add(dto);
        }
        return response;
    }
}