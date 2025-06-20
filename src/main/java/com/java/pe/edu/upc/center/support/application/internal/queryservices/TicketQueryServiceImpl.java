package com.java.pe.edu.upc.center.support.application.internal.queryservices;

import com.java.pe.edu.upc.center.support.domain.model.aggregates.Ticket;
import com.java.pe.edu.upc.center.support.domain.model.queries.GetAllTicketQuery;
import com.java.pe.edu.upc.center.support.domain.services.TicketQueryService;
import com.java.pe.edu.upc.center.support.infrastructure.persistence.jpa.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketQueryServiceImpl implements TicketQueryService {

    private final TicketRepository ticketRepository;

    public TicketQueryServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> handle(GetAllTicketQuery query) {
        return ticketRepository.findAll();
    }
}
