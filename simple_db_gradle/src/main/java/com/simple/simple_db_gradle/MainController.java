package com.simple.simple_db_gradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user")
public class MainController {
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email){

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);

        return "Save!!";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUers(){
        return userRepository.findAll();
    }

}
