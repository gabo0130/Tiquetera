package com.group.tiquetera.infrastructure.converter;

import com.group.tiquetera.domain.dto.TicketData;
import com.group.tiquetera.domain.filter.TicketFilter;
import com.group.tiquetera.infrastructure.entity.TicketEntity;
import com.group.tiquetera.infrastructure.rest.request.TicketRequestFilter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketConverter {
    TicketFilter requestFilterToTicketFilter(TicketRequestFilter request);

    TicketData entityToData(TicketEntity ticketEntity);
}
