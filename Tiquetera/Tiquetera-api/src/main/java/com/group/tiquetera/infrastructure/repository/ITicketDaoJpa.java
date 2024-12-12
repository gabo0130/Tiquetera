package com.group.tiquetera.infrastructure.repository;

import com.group.tiquetera.infrastructure.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ITicketDaoJpa  extends JpaRepository<TicketEntity, Long>, JpaSpecificationExecutor<TicketEntity> {

}


