package com.group.tiquetera.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group.tiquetera.infrastructure.entity.TicketStatus;
import com.group.tiquetera.infrastructure.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
public class TicketData {

    private Long id;

    private UserData user;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private TicketStatus status;
}
