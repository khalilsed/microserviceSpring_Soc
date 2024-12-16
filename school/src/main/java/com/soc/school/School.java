package com.soc.school;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
@Table(name = "School")
public class School {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

    private String name;
    private String alpha_two_code;
    private String country;

    @Column(name = "web_page")
    private String web_pages;

    @Column(name = "domain")
    private String domains;

    @Column(name = "state-province")
    private String stateProvince;

}