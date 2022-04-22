package com.example.netcackerapp.controllers;

import com.example.netcackerapp.Models.Reservation;
import com.example.netcackerapp.repo.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;

@RestController
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;


    @GetMapping("/reservation/info")
    public String ReservationInfo(Model model){
        Iterable<Reservation> places = reservationRepository.findAll();
        places.forEach(i->{
            System.out.println(i.getReservationid()+"- "+i.getUserId()+" - "+i.getPlaceId());
        });
        System.out.println("---------");
        return "redirect:/";
    }

    @GetMapping("/reservation/addReservation")
    public String AddNewPlace(Model model){
        return "addReservation";
    }

    @PostMapping("/reservation/addReservation")
    //userId placeId timeStart timeEnd
    public String AddNewPlace(Model model, @RequestParam Integer userId, @RequestParam Integer placeId, @RequestParam Date startData, @RequestParam Time startTime, @RequestParam Date endData, @RequestParam Time endTime){
        reservationRepository.save(new Reservation(userId,placeId, startData, startTime, endData, endTime));
        return "redirect:/reservation/info";
    }
}
