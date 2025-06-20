package com.java.pe.edu.upc.center.support.domain.services;

import com.java.pe.edu.upc.center.support.domain.model.aggregates.Ticket;
import com.java.pe.edu.upc.center.support.domain.model.commands.CreateTicketCommand;

public interface TicketCommandService {
    Ticket handle(CreateTicketCommand command);
}
