package com.deploy.peenector.domain.student;

import com.deploy.peenector.domain.team.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String schoolNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Builder
    Student(String schoolNumber, String name, String password, String contact, String email) {
        this.schoolNumber = schoolNumber;
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.email = email;
    }
}
