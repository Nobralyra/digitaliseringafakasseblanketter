package com.example.blanket.digitaliseringafakasseblanketter.controller;

import com.example.blanket.digitaliseringafakasseblanketter.model.AR225;
import com.example.blanket.digitaliseringafakasseblanketter.validatation.Validation;
import com.example.blanket.digitaliseringafakasseblanketter.validatation.ValidationEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String index()
    {
        return "home/index";
    }

    @PostMapping("/")
    public String index(AR225 form, HttpSession httpSession)
    {
      return "home/index";
    }

}
