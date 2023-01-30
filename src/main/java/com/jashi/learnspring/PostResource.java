package com.jashi.learnspring;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/post")
@Log4j2
public class PostResource {

    RestTemplate restTemplate = new RestTemplate();
    @GetMapping(value = "/testForwardCall")
    public ResponseEntity testForwardCall() throws URISyntaxException {
        log.info("Request recieved for testForwardCall --> will be forwarded");
       // String result =  makePostCall();
        Object result = makePostCallWithExchange("https://httpbin.org/post").getBody();
        return new ResponseEntity(result , HttpStatus.OK);

    }
    private String makePostCall(String target) throws URISyntaxException {
        URI url = new URI(target);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", "bearer adasxyasdasddljlbkjd23b");
        headers.add(HttpHeaders.ACCEPT, "application/json");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        log.info("Headers set are {}", headers.toSingleValueMap());
        HttpEntity<String> request =
                new HttpEntity<String>("body here", headers);
        log.info("Sending Post request to host {} and path {}", url.getHost(), url.getPath());
        ResponseEntity<String> result =  restTemplate.postForEntity(url, request, String.class);
        return result.getBody();
    }

    public ResponseEntity makePostCallWithExchange(String url) throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", "bearer adasxyasdasddljlbkjd23b");
        headers.add(HttpHeaders.ACCEPT, "application/json");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        log.info("Headers set are {}", headers.toSingleValueMap());
        HttpEntity<String> request =
                new HttpEntity<String>("body here", headers);
        log.info("Sending Post request to url {}", url);
        ResponseEntity<String> result =  restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        return result;
    }

    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
