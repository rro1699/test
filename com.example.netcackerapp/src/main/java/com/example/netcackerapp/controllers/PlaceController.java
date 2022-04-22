package com.example.netcackerapp.controllers;

import com.example.netcackerapp.Models.Places;
import com.example.netcackerapp.repo.PlaceRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PlaceController {
    @Autowired
    private PlaceRepository placeRepository;


    @GetMapping("/places/info")
    public String placesInfo(Model model) throws JSONException {
        JSONObject obj = new JSONObject();
        Iterable<Places> places = placeRepository.findAll();
        JSONObject obj1 = new JSONObject();

        places.forEach(i->{
            try {
                obj.put("id: ",i.getId()).put("price: ",i.getPrice());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        obj1.put("",obj.toString());
        return obj1.toString();
    }

    @GetMapping("/places/addPlace")
    public String AddNewPlace(Model model){
        return "addPlace";
    }

    @PostMapping("/places/addPlace")
    public String AddNewPlace(Model model, @RequestParam String price){
        BigDecimal p = BigDecimal.valueOf(Double.parseDouble(price));
        Places places = new Places(p);
        placeRepository.save(places);
        return "redirect:/places/info";
    }
}
