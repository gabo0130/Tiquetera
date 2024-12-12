package com.group.tiquetera.infrastructure.rest.response;

import com.group.tiquetera.domain.dto.TicketData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class TicketDataList extends PaginatedData<TicketData> {

    private static final long serialVersionUID = -8197563285226321001L;

    public TicketDataList(List<TicketData> content) {
        super(content);
    }

    public TicketDataList(Page<TicketData> page) {
        super(page);
    }

    public TicketDataList(List<TicketData> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

}
