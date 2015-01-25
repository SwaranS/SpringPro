package com.springapp.mvc.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Check Domain Status
 */
public class client {

    static String SERVER_URI = "http://localhost:8080/contacts";
    public static void main(String[] args){
        System.out.println(getResponseMessage().is2xxSuccessful());
    }

   /* private static Boolean getStatus(){
        try {
            return getResponseMessage().equals(200);
        }
        catch(Exception e){
            return false;
        }
    }*/


    //ResponseEntity.getStatusCode()
    private static HttpStatus getResponseMessage(){
        RestTemplate restTemplate = new RestTemplate();
        ((SimpleClientHttpRequestFactory)restTemplate.getRequestFactory()).setReadTimeout(1000*30);
        ResponseEntity<String> response = restTemplate.getForEntity(SERVER_URI, String.class);
        /*String restCall = response.getBody();*/
        return response.getStatusCode();
    }
}
