//package com.hcc.controllers;
//
//import com.hcc.entities.Hello;
////import com.hcc.services.HelloService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//// this is an example controller feel free to delete this once you have created your own.
//@RestController
//@RequestMapping("/")
//public class HelloController {
//    @Autowired
//    HelloService helloService;
//    @GetMapping
//    ResponseEntity<?> welcomeLearner() {
//        Hello greeting = helloService.greetLearner();
//        return ResponseEntity.ok(greeting);
//    }
//}
//Endpoints go in controllers
//controllers pass things to service
//service maybe goes to repository
