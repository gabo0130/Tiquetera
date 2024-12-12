package com.group.tiquetera.domain.filter;

import com.group.tiquetera.domain.dto.PageRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TicketFilter extends PageRequest {

    private Long id;

    private Long idUser;

    private String userName;

    private LocalDateTime createdFrom;

    private LocalDateTime createdTo;

    private LocalDateTime updatedFrom;

    private LocalDateTime updatedTo;

    private Long idStatus;

    private String statusName;


}
