package com.group.tiquetera.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ticket_status")
@Data
public class TicketStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 100)
    private String description;

}
