package com.group.tiquetera.infrastructure.converter;

import com.group.tiquetera.domain.dto.TicketData;
import com.group.tiquetera.domain.filter.TicketFilter;
import com.group.tiquetera.infrastructure.entity.TicketEntity;
import com.group.tiquetera.infrastructure.rest.request.TicketRequestFilter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-11T21:13:52-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class TicketConverterImpl implements TicketConverter {

    @Override
    public TicketFilter requestFilterToTicketFilter(TicketRequestFilter request) {
        if ( request == null ) {
            return null;
        }

        TicketFilter ticketFilter = new TicketFilter();

        return ticketFilter;
    }

    @Override
    public TicketData entityToData(TicketEntity ticketEntity) {
        if ( ticketEntity == null ) {
            return null;
        }

        TicketData ticketData = new TicketData();

        return ticketData;
    }
}
