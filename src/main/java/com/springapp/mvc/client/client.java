package com.springapp.mvc.client;

import org.springframework.web.client.RestTemplate;

/**
 * Check Domain Status
 */
public class client {

    static String SERVER_URI = "http://localhost:8080/contacts";
    public static void main(String[] args){
        System.out.println(getStatus());
    }
    private static Boolean getStatus(){
        try {
            return getResponseMessage().equals("Domain Active");
        }
        catch(Exception e){
            return false;
        }
    }


    //ResponseEntity.getStatusCode()
    private static String getResponseMessage(){
    RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(SERVER_URI, String.class);
    }
}
