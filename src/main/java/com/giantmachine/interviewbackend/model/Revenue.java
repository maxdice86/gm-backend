package com.giantmachine.interviewbackend.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Table(name = "billing")
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String dates;

    @Column
    private String clients;

    @Column
    private String project;

    @Column
    private String projectCode;

    @Column
    private Double hours;

    @Column
    private String billable;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int billRate;
}
