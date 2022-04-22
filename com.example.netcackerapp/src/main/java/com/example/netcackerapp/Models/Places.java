package com.example.netcackerapp.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Places {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placeid")
    private Integer id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "xcoor")
    private Double xcoor;

    @Column(name = "ycoor")
    private Double ycoor;

    @Column(name = "orient")
    private String orient;


    public Places(BigDecimal price){
        this.price=price;
    }
}
