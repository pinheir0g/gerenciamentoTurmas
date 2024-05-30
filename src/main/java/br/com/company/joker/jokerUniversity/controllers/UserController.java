package br.com.company.joker.jokerUniversity.controllers;

import br.com.company.joker.jokerUniversity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


}
