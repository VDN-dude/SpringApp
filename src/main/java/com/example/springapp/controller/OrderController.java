package com.example.springapp.controller;

import com.example.springapp.entity.TacoOrder;
import com.example.springapp.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/order")
@SessionAttributes("tacoOrder")
@ConfigurationProperties(prefix = "taco.order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    private int pageSize = 20;

    public void setPageSize(int pageSize){
        this.pageSize = pageSize;
    }

    @GetMapping("/current")
    public String orderForm(){
        System.out.println(pageSize);
        return "orderForm";
    }

    @PostMapping
    public String acceptOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()){
            return "orderForm";
        }
        log.info("Processing order {}", tacoOrder);
        orderService.save(tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
