package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/email/{email}")
    public Optional<User> getEmailByPath(@PathVariable String email){
        return userService.findByEmail(email);
    }

    @GetMapping(value = "/cityAddress/{city}/{address}")
    public List<User> getCityAddress(@PathVariable String city,@PathVariable String address){
        return userService.findByCityAndAddress(city,address);
    }

    @GetMapping(value = "/ajq")
    public List<User> index() {
        // Change from UserRepository to UserService
        return userService.findAllByJpqlParamsQuery(0, "bangkok");
    }

    @GetMapping(value = "/a")
    public List<User> a(){
        return userService.findAll();
    }

    @GetMapping(value = "/id")
    public Optional<User> id(@RequestParam Integer id) {
        return  userService.findById(id);
    }

    @GetMapping(value = "/lim")
    public Page<User> lim(@RequestParam Integer start,@RequestParam Integer limit,@RequestParam String field){
        return userService.findAllByLimit(start,limit,field);
    }

    @GetMapping(value = "/caa")
    public List<User> caa(@RequestParam String city,@RequestParam Integer active,@RequestParam Integer age){
        return userService.findByCityAndActiveAndAge(city,active,age);
    }

    @GetMapping(value = "/age")
    public List<User> age(@RequestParam (name = "age") List<Integer> ages){
        return  userService.findByAgeIn(ages);
    }

    @GetMapping(value = "/q")
    public List<User> q(){
        return userService.findAllByQuery();
    }

    @GetMapping(value = "/pq")
    public List<User> pq(@RequestParam Integer active,@RequestParam String city){
        return  userService.findAllByParamsQuery(active,city);
    }

    @GetMapping(value = "/jq")
    public  List<User> jq(){
        return userService.findAllByJpqlQuery();
    }
}
