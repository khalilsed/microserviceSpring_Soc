package com.soc.student;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StudentID")
    private Integer StudentID;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Age")
    private Integer Age;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Department")
    private String Department;
    @Column(name = "GPA")
    private Integer GPA;
    @Column(name = "GraduationYear")
    private Integer GraduationYear;
    @Column(name = "schoolId")
    private Integer schoolId;

}
