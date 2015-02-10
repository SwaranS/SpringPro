package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 27/01/2015.
 */
@Controller
public class SmartController {
    private List<String> stringList = new ArrayList<String>();


    @RequestMapping(value="/AddUser",method= RequestMethod.GET)
    public String showForm(){
        return "AddUser";
    }

    @RequestMapping(value="/AddUser.htm",method=RequestMethod.POST)
    public @ResponseBody
    String addUser(@ModelAttribute(value="name") String name, BindingResult result ){
        String returnText;
        if(!result.hasErrors()){
            stringList.add(name);
            returnText = "User has been added to the list. Total number of users are " + stringList.size();
        }else{
            returnText = "Sorry, an error has occur. User has not been added to list.";
        }
        return returnText;
    }


}
