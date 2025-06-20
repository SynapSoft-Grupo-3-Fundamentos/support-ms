package com.java.pe.edu.upc.center.support.interfaces.rest.transform;

import com.java.pe.edu.upc.center.support.domain.model.aggregates.Ticket;
import com.java.pe.edu.upc.center.support.interfaces.rest.resources.TicketResource;

public class TicketResourceFromEntityAssembler {

    public static TicketResource toResourceFromEntity(Ticket entity) {
        return new TicketResource(
                entity.getId(),
                entity.getName(),
                entity.getMail(),
                entity.getDescription(),
                entity.getStatus().name()
        );
    }
}