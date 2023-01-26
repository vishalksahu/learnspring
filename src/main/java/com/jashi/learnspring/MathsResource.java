package com.jashi.learnspring;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;

@RestController
@RequestMapping("/tokenapi")
@Log4j2
public class MathsResource {

    @Value( "${mathresource.factor}" )
    private int factor;

    @Value( "${database.url}" )
    private String databaseUrl;


    @GetMapping(value = "/getToken")
    public ResponseEntity getToken(@RequestParam("key") String key) {
        String intermediateKey = TokenHelper.mixUpKey(key);
        String result = TokenHelper.obtainToken(intermediateKey);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping(value = "/printvalue")
    public ResponseEntity printValue(@RequestParam("value") int value) {
        System.out.print("Enter a value: ");
        if (value % 2 == 0) {
            System.out.println(value + " is even");
            return new ResponseEntity(value + " is even", HttpStatus.OK);
        } else {
            System.out.println(value + " is odd");
            return new ResponseEntity(value + " is odd", HttpStatus.OK);
        }
    }

    @GetMapping(value = "/divisibleByX")
    public ResponseEntity divisibleByX(@RequestParam("value") int value) {
        log.info("Database url is {}", databaseUrl);
        log.info("Received value is {}", value);
        log.debug("factor from properties file is {}", factor);
        if (value % factor == 0) {
          log.debug("divisible by {} is true", factor);
            return new ResponseEntity(value + " is divisible by "+factor, HttpStatus.OK);
        }
        else {
            log.debug("divisible by {} is false", factor);
            return new ResponseEntity(value + " is NOT divisible by "+factor, HttpStatus.OK);
        }
    }
}
