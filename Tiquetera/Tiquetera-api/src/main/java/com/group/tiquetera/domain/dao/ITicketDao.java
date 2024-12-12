package com.group.tiquetera.domain.dao;

import com.group.tiquetera.domain.filter.TicketFilter;
import com.group.tiquetera.infrastructure.entity.TicketEntity;
import org.springframework.data.domain.Page;

public interface ITicketDao {
    Page<TicketEntity> findTickets(TicketFilter ticketFilter);
}
