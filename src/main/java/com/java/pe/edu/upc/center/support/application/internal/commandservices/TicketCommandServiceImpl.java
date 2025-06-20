package com.java.pe.edu.upc.center.support.application.internal.commandservices;

import com.java.pe.edu.upc.center.support.domain.model.aggregates.Ticket;
import com.java.pe.edu.upc.center.support.domain.model.commands.CreateTicketCommand;
import com.java.pe.edu.upc.center.support.domain.services.TicketCommandService;
import com.java.pe.edu.upc.center.support.infrastructure.persistence.jpa.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TicketCommandServiceImpl implements TicketCommandService {

    private final TicketRepository ticketRepository;

    public TicketCommandServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket handle(CreateTicketCommand command) {
        Ticket ticket = new Ticket(command);
        return ticketRepository.save(ticket);
    }
}
