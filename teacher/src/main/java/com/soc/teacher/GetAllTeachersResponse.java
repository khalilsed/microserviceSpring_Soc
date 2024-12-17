package com.soc.teacher;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "getAllTeachersResponse")
public class GetAllTeachersResponse {

    private List<TeacherDTO> teachers = new ArrayList<>();

    @XmlElement(name = "Teacher")
    public List<TeacherDTO> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherDTO> teachers) {
        this.teachers = teachers;
    }
}