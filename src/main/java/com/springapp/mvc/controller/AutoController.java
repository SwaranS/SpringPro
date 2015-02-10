package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for Auto Complete
 */
@Controller
public class AutoController {

    @RequestMapping(value = "/auto", method = RequestMethod.GET)
    public ModelAndView getPages() {

        return new ModelAndView("autoExample");

    }

    @RequestMapping(value = "/getTags", method = RequestMethod.GET)
    public
    @ResponseBody
    List<String> getTags(@RequestParam String term) {
        System.out.println(simulateSearchResult(term));
        return simulateSearchResult(term);

    }

    private List<String> simulateSearchResult(String tagName) {
        System.out.println(tagName);
        List<String> result = new ArrayList<String>();

        result.add("India");
        result.add("Ireland");
        return result;
    }

}
