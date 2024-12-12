package com.group.tiquetera.infrastructure.specificationQuery;

import com.group.tiquetera.domain.filter.TicketFilter;
import com.group.tiquetera.infrastructure.entity.TicketEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class TicketSpecification extends BaseQuerySpecification<TicketEntity> {

    public static Specification<TicketEntity> buildSpecification(TicketFilter filter) {
        Specification<TicketEntity> specification = Specification.where(null);

        if (filter.getId() != null) {
            specification = specification.and(equals(TicketEntity.ATTRIBUTES.ID, filter.getId()));
        }

        if (filter.getIdUser() != null) {
            specification = specification.and(equals(TicketEntity.ATTRIBUTES.USER_ID, filter.getIdUser()));
        }

        if (StringUtils.isNotBlank(filter.getUserName())) {
            specification = specification.and(like(TicketEntity.ATTRIBUTES.USER_NAME, filter.getUserName(), false));
        }

        if (StringUtils.isNotBlank(filter.getStatusName())) {
            specification = specification.and(like(TicketEntity.ATTRIBUTES.STATUS_NAME, filter.getStatusName(), true));
        }

        if (filter.getCreatedFrom() != null) {
            if (filter.getCreatedTo() != null) {
                specification = specification.and(between(TicketEntity.ATTRIBUTES.CREATED_AT, filter.getCreatedFrom(), filter.getCreatedTo()));
            } else {
                specification = specification.and(greaterOrEqual(TicketEntity.ATTRIBUTES.CREATED_AT, filter.getCreatedFrom()));
            }
        } else if (filter.getCreatedTo() != null) {
            specification = specification.and(lessOrEqual(TicketEntity.ATTRIBUTES.CREATED_AT, filter.getCreatedTo()));
        }

        if (filter.getUpdatedFrom() != null) {
            if (filter.getUpdatedTo() != null) {
                specification = specification.and(between(TicketEntity.ATTRIBUTES.UPDATED_AT, filter.getUpdatedFrom(), filter.getUpdatedTo()));
            } else {
                specification = specification.and(greaterOrEqual(TicketEntity.ATTRIBUTES.UPDATED_AT, filter.getUpdatedFrom()));
            }
        } else if (filter.getUpdatedTo() != null) {
            specification = specification.and(lessOrEqual(TicketEntity.ATTRIBUTES.UPDATED_AT, filter.getUpdatedTo()));
        }

        return specification;
    }
}
