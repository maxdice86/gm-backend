package com.giantmachine.interviewbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViewKeys implements Serializable {

    private String name;

    private String clients;
}
