package com.example.springapp.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    private String id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Type type;

}
