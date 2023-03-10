package com.giantmachine.interviewbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Immutable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Immutable
@Getter
@IdClass(ViewKeys.class)
public class RevenueView {
    @Id
    private String name;
    @Id
    private String clients;

    private double hours;

    private double billableHours;

    private double billableAmount;
}


