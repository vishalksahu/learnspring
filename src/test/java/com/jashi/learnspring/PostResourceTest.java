package com.jashi.learnspring;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PostResourceTest {

    @Mock
    private RestTemplate restTemplate;

    private PostResource postResource;
    @BeforeEach
    void setUp() {
        postResource = new PostResource();
        postResource.setRestTemplate(restTemplate);
    }

    @Test
    public void testExchange() throws URISyntaxException {
        ResponseEntity<String> mockedResponse = new ResponseEntity<>("string", HttpStatus.OK);
        Mockito
                .when(restTemplate
                        .exchange(eq("https://test.url.com/path1/path2"), eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class)))
                .thenReturn(mockedResponse);


        ResponseEntity<String> result =  postResource.makePostCallWithExchange("https://test.url.com/path1/path2");

       Assertions.assertNotNull(result);
       Assertions.assertEquals("string", result.getBody());
       Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

}
