package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Table(name="ticket_flights")
@Entity
@Data
public class TicketFlights {
    @Id
    @Column(name="ticket_no")
    private long fTicketNo;

    @Id
    @Column(name="flight_id")
    private long flightId;

    @Column(name="fare_condition")
    private String fareCondition;
    @Column(name="amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name="ticket_no", referencedColumnName= "ticket_no")
    Tickets ticket;
}
