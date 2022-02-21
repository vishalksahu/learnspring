package com.jashi.learnspring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Scanner;
@RestController
@RequestMapping("/calculate")
public class MathsResource {

    @GetMapping(value = "/printvalue")
    public ResponseEntity printValue (@RequestParam("value") int value) {

        Scanner reader = new Scanner(System.in);

        System.out.print("Enter a value: ");


        if (value % 2 == 0) {
            System.out.println(value + " is even");
            return new ResponseEntity(value + " is even", HttpStatus.OK);
        }
        else {
            System.out.println(value + " is odd");
            return new ResponseEntity(value + " is odd", HttpStatus.OK);
        }

    }
    }
