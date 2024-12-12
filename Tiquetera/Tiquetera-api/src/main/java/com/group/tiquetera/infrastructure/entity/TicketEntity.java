package com.group.tiquetera.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Data
public class TicketEntity {

    public interface ATTRIBUTES {
        String ID = "id";
        String USER_ID = "user.id";
        String USER_NAME = "user.name";
        String CREATED_AT = "createdAt";
        String UPDATED_AT = "updatedAt";
        String STATUS_ID = "status.id";
        String STATUS_NAME = "status.name";
    }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserEntity user;

        @Column(nullable = false)
        private LocalDateTime createdAt;

        @Column(nullable = false)
        private LocalDateTime updatedAt;

        @ManyToOne
        @JoinColumn(name = "status_id")
        private TicketStatus status;

    }
