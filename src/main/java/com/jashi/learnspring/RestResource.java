package com.jashi.learnspring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/learn")
public class RestResource {

    @GetMapping(value = "/printname")
    public ResponseEntity<String> printName (@RequestParam("name") String name) {
       System.out.println("Name recieved is "+name);

        return new ResponseEntity(name +" Thankyou",HttpStatus.OK);
    }

    @GetMapping(value = "/printname1/{name}")
    public ResponseEntity<String> printName1 (@PathVariable("name") String name) {
        System.out.println("Name recieved is "+name);

        return new ResponseEntity(name +" Thankyou from pathvariable",HttpStatus.OK);
    }


    @GetMapping(value = "/printname2")
    public ResponseEntity<String> printName2 (@RequestParam("name") String name) {
        System.out.println("Name recieved is "+name);

        return new ResponseEntity(name +" Thankyou",HttpStatus.OK);
    }

}

