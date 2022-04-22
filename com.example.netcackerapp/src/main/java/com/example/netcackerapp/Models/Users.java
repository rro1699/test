package com.example.netcackerapp.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userid;

    @Column(name = "name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

   /* public Users() {
    } */

    public Users(String name, String surname, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

}
