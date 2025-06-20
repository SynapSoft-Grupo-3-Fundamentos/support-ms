package com.java.pe.edu.upc.center.support.domain.model.aggregates;

import com.java.pe.edu.upc.center.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.java.pe.edu.upc.center.support.domain.model.commands.CreateTicketCommand;
import com.java.pe.edu.upc.center.support.domain.model.valueobjects.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tickets")
public class Ticket extends AuditableAbstractAggregateRoot<Ticket> {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status = TicketStatus.IN_PROGRESS;

    public Ticket() {}

    public Ticket(String name, String mail, String description, TicketStatus status) {
        this.name = name;
        this.mail = mail;
        this.description = description;
        this.status = status;
    }

    public Ticket(CreateTicketCommand command) {
        this.name = command.name();
        this.mail = command.email();
        this.description = command.description();
    }

}
