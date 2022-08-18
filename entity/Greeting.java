package com.bridgelabz.greetingapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Table(name = "Greeting_Table")
public class Greeting {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String message;

    public Greeting() {

    }
}
