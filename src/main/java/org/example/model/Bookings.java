package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name="bookings")
@Entity
@Data
public class Bookings {
    @Id
    @Column(name="book_ref")
    private String bookRef;
    @Basic
    @Column(name="book_date")
    private java.time.ZonedDateTime bookDate;
    @Column(name="total_amount")
    private double totalAmount;

    @OneToMany(mappedBy="booking")
    List<Tickets> tickets;
}
