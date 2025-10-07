package com.steverado9.Teamwork.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gif")
public class Gif {
    @Id
    @GeneratedValue
    private Long id;

}
