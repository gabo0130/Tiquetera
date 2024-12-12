package com.group.tiquetera.infrastructure.rest.controller;


import com.group.tiquetera.domain.dto.ObjectResponseSuccess;
import com.group.tiquetera.domain.service.ITicketService;
import com.group.tiquetera.infrastructure.converter.TicketConverter;
import com.group.tiquetera.infrastructure.rest.request.TicketRequestFilter;
import com.group.tiquetera.infrastructure.rest.response.TicketDataList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tickets")
@RestController
public class TicketsController {

    private static Logger LOGGER = LoggerFactory.getLogger(TicketsController.class);

    @Autowired
    private ITicketService ticketService;

    @Autowired
    private TicketConverter converter;

    @Operation(description = "Get tickets data")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "OK") })
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ObjectResponseSuccess<TicketDataList>> getAuditUser(
            @ModelAttribute TicketRequestFilter request) {
        TicketDataList ticketDataList = new TicketDataList(ticketService.findTickets(converter.requestFilterToTicketFilter(request)));
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ObjectResponseSuccess<>(ticketDataList));
    }


}
