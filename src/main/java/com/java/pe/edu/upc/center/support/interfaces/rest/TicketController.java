package com.java.pe.edu.upc.center.support.interfaces.rest;

import com.java.pe.edu.upc.center.support.domain.model.aggregates.Ticket;
import com.java.pe.edu.upc.center.support.domain.model.queries.GetAllTicketQuery;
import com.java.pe.edu.upc.center.support.domain.services.TicketCommandService;
import com.java.pe.edu.upc.center.support.domain.services.TicketQueryService;
import com.java.pe.edu.upc.center.support.interfaces.rest.resources.CreateTicketResource;
import com.java.pe.edu.upc.center.support.interfaces.rest.resources.TicketResource;
import com.java.pe.edu.upc.center.support.interfaces.rest.transform.CreateTicketCommandFromResourceAssembler;
import com.java.pe.edu.upc.center.support.interfaces.rest.transform.TicketResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/tickets")
@Tag(name="Ticket", description = "Ticket Management Endpoints")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class TicketController {
    private final TicketCommandService ticketCommandService;
    private final TicketQueryService ticketQueryService;

    public TicketController(TicketCommandService ticketCommandService, TicketQueryService ticketQueryService) {
        this.ticketCommandService = ticketCommandService;
        this.ticketQueryService = ticketQueryService;
    }

    @PostMapping
    public ResponseEntity<TicketResource> createTicket(@RequestBody CreateTicketResource resource) throws Exception {
        var createTicketCommand = CreateTicketCommandFromResourceAssembler.toCommandFromResource(resource);

        Ticket ticket = ticketCommandService.handle(createTicketCommand);

        return new ResponseEntity<>(TicketResourceFromEntityAssembler.toResourceFromEntity(ticket), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<TicketResource>> getAllTicket() {
        GetAllTicketQuery getAllTicketQuery = new GetAllTicketQuery();

        List<Ticket> tickets = ticketQueryService.handle(getAllTicketQuery);

        return new ResponseEntity<>(tickets.stream().map(TicketResourceFromEntityAssembler::toResourceFromEntity).toList(), HttpStatus.OK);
    }
}
