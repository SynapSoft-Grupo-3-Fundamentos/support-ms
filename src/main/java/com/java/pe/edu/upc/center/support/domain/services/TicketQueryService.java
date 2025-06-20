package com.java.pe.edu.upc.center.support.domain.services;

import com.java.pe.edu.upc.center.support.domain.model.aggregates.Ticket;
import com.java.pe.edu.upc.center.support.domain.model.queries.GetAllTicketQuery;

import java.util.List;

public interface TicketQueryService {
    List<Ticket> handle(GetAllTicketQuery query);
}
