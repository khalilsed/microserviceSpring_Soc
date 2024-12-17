package com.soc.school;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Student {
    private String Name;
    private Integer Age;
    private String Email;
    private String Department;
    private Integer GPA;
    private Integer GraduationYear;
}
