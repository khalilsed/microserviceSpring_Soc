package com.soc.teacher;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "Student")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TeacherID")
    private Integer TeacherID;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Age")
    private Integer Age;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Specialite")
    private String Specialite;
    @Column(name = "Grade")
    private String Grade; // Example: "Maitre Assistant" or "Maitre de Conference"
    @Column(name = "Phone_number")
    private String PhoneNumber;
    @Column(name = "cin")
    private String cin;
    @Column(name = "schoolId")
    private Integer schoolId;
}
