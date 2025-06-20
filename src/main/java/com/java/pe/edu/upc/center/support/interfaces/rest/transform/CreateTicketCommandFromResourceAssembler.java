package com.java.pe.edu.upc.center.support.interfaces.rest.transform;

import com.java.pe.edu.upc.center.support.domain.model.commands.CreateTicketCommand;
import com.java.pe.edu.upc.center.support.interfaces.rest.resources.CreateTicketResource;

public class CreateTicketCommandFromResourceAssembler {

    public static CreateTicketCommand toCommandFromResource(CreateTicketResource resource) {
        return new CreateTicketCommand(
                resource.name(),
                resource.mail(),
                resource.description()
        );
    }
}