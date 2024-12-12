package com.group.tiquetera.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String user;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;



}
