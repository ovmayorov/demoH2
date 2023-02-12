package org.example.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Table(name="tickets")
@Entity
@Data
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Tickets {
    @Id
    @Column(name="ticket_no")
    private long ticketNo;

    @ManyToOne
    @JoinColumn(name="book_ref", referencedColumnName= "book_ref")
    private Bookings booking;

    @Column(name="passenger_id")
    private String passengerId;

    @Column(name="passenger_name")
    private String passengerName;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String contactData;

    @OneToMany(mappedBy="ticket")
    List<TicketFlights> ticketFlights;

}
