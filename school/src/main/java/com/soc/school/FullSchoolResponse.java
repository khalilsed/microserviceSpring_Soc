package com.soc.school;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class FullSchoolResponse {

    private String name;
    private String country;
    private List<Student> students;

}
