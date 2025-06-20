package com.java.pe.edu.upc.center.support.infrastructure.persistence.jpa.repositories;

import com.java.pe.edu.upc.center.support.domain.model.aggregates.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
