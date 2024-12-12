package com.group.tiquetera.infrastructure.rest.request;

import com.group.tiquetera.domain.dto.PageRequest;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketRequestFilter extends PageRequest {

    private Long id;

     private Long idUser;

     private String userName;

    @PastOrPresent
    private LocalDateTime createdFrom;

    @PastOrPresent
    private LocalDateTime createdTo;

    @PastOrPresent
    private LocalDateTime updatedFrom;

    @PastOrPresent
    private LocalDateTime updatedTo;

     private Long idStatus;

     private String statusName;

}
