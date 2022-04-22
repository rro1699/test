package com.example.netcackerapp.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Reservation {
    public Reservation(Integer userId, Integer placeId, Date startdatereser, Time starttimerreser, Date enddatereser, Time endtimereser) {
        UserId = userId;
        PlaceId = placeId;
        this.startdatereser = startdatereser;
        this.starttimerreser = starttimerreser;
        this.enddatereser = enddatereser;
        this.endtimereser = endtimereser;
    }

    @Id
    @Column(name="reservationid")
    private Integer reservationid;

    @Column(name="userid")
    private Integer UserId;

    @Column(name="placeid")
    private Integer PlaceId;

   @Column(name = "startdatereser")
    private Date startdatereser;

   @Column(name = "starttimerreser")
    private Time starttimerreser;

   @Column(name = "enddatereser")
    private Date enddatereser;

   @Column(name = "endtimereser")
    private Time endtimereser;

    /* @Column(name="starttimereser")
    //Мб тут нужно хранить в import java.sql.Time и import java.sql.Date.
    private LocalDateTime startTime;

    @Column(name="endtimereser")
    private LocalDateTime endTime; */

}
