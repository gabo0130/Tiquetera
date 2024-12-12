package com.group.tiquetera.domain.service;

import com.group.tiquetera.domain.dto.TicketData;
import com.group.tiquetera.domain.filter.TicketFilter;
import com.group.tiquetera.infrastructure.rest.response.TicketDataList;
import org.springframework.data.domain.Page;

public interface ITicketService {
    Page<TicketData> findTickets(TicketFilter ticketFilter);


}
