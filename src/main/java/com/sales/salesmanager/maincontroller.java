package com.sales.salesmanager;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
@RestController
@CrossOrigin("*")

public class maincontroller {
    long totalamount = 0;
    @Autowired
    UserRepository repo;
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        user existing = repo.findByEmail(email);
        if(existing != null){
            return "Email Already Exist";
        }
        user u = new user();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(password);
         repo.save(u);
         return "Signup success";
    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        user user = repo.findByEmail(email);
        if(user == null){
            return "User not found";
        }
        if(user.getPassword().equals(password)){
            return "success";
        }
        return "Invalid password";
    }
    @Autowired
    SalesrecordRepository salesrepo;
    @GetMapping("/record")
    public salesrecord record(@RequestParam String productname, @RequestParam String month, @RequestParam int quantity, @RequestParam int price) {
        totalamount = quantity * price;
       salesrecord s = new salesrecord();
       s.setProductname(productname);
       s.setMonth(month);
       s.setQuantity(quantity);
       s.setPrice(price);
       s.setTotalamount(totalamount);
       return salesrepo.save(s);
    }
    @GetMapping("/detailrecord")
    public List<salesrecord> getRecord() {
        return salesrepo.findAll();
    }
    @GetMapping("/salescount")
    public long salescount() {
        return salesrepo.count();
    }
   
   
    
    
    
    
    
    
}
