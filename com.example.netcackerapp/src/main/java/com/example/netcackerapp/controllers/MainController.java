package com.example.netcackerapp.controllers;


import com.example.netcackerapp.Models.Users;
import com.example.netcackerapp.repo.UsersRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedHashMap;


@RestController
public class MainController {

    @Autowired
    private UsersRepository usersRepository;


    @GetMapping("/info")
    public String info(Model model){
        Iterable<Users> users = usersRepository.findAll();
        users.forEach(i->{
            System.out.println(i.getUserid()+" - "+i.getName()+" - "+i.getSurname()+" - "+i.getEmail()+" - "+i.getPhone());
        });
        System.out.println("-----------");

        return "info";
    }

    @GetMapping("/")
    public String mainPage(Model model){

        return "home";
    }


    @RequestMapping("/user")
    public String user(OAuth2Authentication authentication) {
        LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
        JSONObject object = new JSONObject();
        try {
            String [] fio = properties.get("name").toString().split(" ");
            object.put("email",properties.get("email").toString()).
                    put("name",fio[0]).put("surname",fio[1]);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object.toString();
    }

    @GetMapping("/add")
    public String addNewUser(Model model){
        return "add";
    }

    @PostMapping("/add")
    public String addNewUser(@RequestParam String name, @RequestParam String surname,
                             @RequestParam String phone, @RequestParam String email, Model model){

        Users users = new Users(name,surname,phone,email);
        usersRepository.save(users);
        return "redirect:/info";
    }


    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable(value = "id") Integer id,Model model){
        Users users = usersRepository.findById(id).orElseThrow();
        usersRepository.delete(users);
        return "redirect:/info";
    }
}
