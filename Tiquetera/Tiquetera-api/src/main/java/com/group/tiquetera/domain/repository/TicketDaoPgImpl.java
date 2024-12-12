package com.group.tiquetera.domain.repository;

import com.group.tiquetera.domain.dao.ITicketDao;
import com.group.tiquetera.domain.filter.TicketFilter;
import com.group.tiquetera.infrastructure.converter.TicketConverter;
import com.group.tiquetera.infrastructure.entity.TicketEntity;
import com.group.tiquetera.infrastructure.repository.ITicketDaoJpa;
import com.group.tiquetera.infrastructure.specificationQuery.TicketSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoPgImpl implements ITicketDao {


    private ITicketDaoJpa jpaDao;

    public ITicketDaoJpa getJpaDao() {
        return jpaDao;
    }

    private TicketConverter converter;


    public TicketConverter getConverter() {
        return this.converter;
    }

    @Autowired
    public void setJpaDao(ITicketDaoJpa jpaDao) {
        this.jpaDao = jpaDao;
    }

    @Autowired
    public void setMapper(TicketConverter converter) {
        this.converter = converter;
    }


    @Override
    public Page<TicketEntity> findTickets(TicketFilter ticketFilter) {
        Specification<TicketEntity> entitySpecification = TicketSpecification.buildSpecification(ticketFilter);
        return jpaDao.findAll(entitySpecification, ticketFilter.getPageable());
    }

}
