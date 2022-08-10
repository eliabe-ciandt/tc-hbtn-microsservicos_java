package com.example.user.controller;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {

        String msg = "";

        if(id <= 0 || id >= 100) {
            throw new UserIdException("You have entered invalid ID: " + id);
        }

        msg = "You have entered valid ID";

        return msg;
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {

        String msg = "";

        if(userName.length() <= 3 || userName.length()>= 15) {
            throw new UserNameException("You have entered invalid USERNAME: " + userName);
        }

        msg = "You have entered valid USERNAME";

        return msg;
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {

        String msg = "";
        boolean isCPFValid = isCPF(cpf);

        if(!isCPFValid) {
            throw new CPFException("You have entered invalid CPF: " + cpf);
        }

        msg = "You have entered valid CPF";

        return msg;

    }

    public boolean isCPF(String CPF) {

        if(CPF.length() >= 15 || CPF.length() <= 3)
            return false;

        return true;
    }
}
