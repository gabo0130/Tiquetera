package com.group.tiquetera.usecases.services;

import com.group.tiquetera.domain.dao.ITicketDao;
import com.group.tiquetera.domain.dto.TicketData;
import com.group.tiquetera.domain.filter.TicketFilter;
import com.group.tiquetera.domain.service.ITicketService;
import com.group.tiquetera.infrastructure.converter.TicketConverter;
import com.group.tiquetera.infrastructure.entity.TicketEntity;
import org.springframework.data.domain.Page;

public class TicketService implements ITicketService {

    private ITicketDao dao;
    private TicketConverter converter;

    public TicketService(ITicketDao dao, TicketConverter converter) {
        this.dao = dao;
        this.converter = converter;
    }

    @Override
    public Page<TicketData> findTickets(TicketFilter ticketFilter) {
        Page<TicketEntity> ticketEntities = dao.findTickets(ticketFilter);
        return ticketEntities.map(this.converter::entityToData);
    }
}
