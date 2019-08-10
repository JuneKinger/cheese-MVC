package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.standard.processor.StandardSrcTagProcessor;

import java.util.ArrayList;

@Controller

/* the cheese below will need to have a cheese directory under templates for
   better organization - templates.cheese

 */

@RequestMapping("cheese")
public class CheeseController {

    // this list is accessible to all methods within this class
    static ArrayList<String> cheeses = new ArrayList<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    // parameter model of class type Model - pass data from Controller to view with using Model
    public  String index(Model model) {

        // pass object cheeses into the view
        model.addAttribute("cheeses", cheeses);
        // title is accessible within the view (index.html)
        model.addAttribute("title", "My Cheeses");
        // tell Spring which template to render by giving it the name of the template
        return "cheese/index";
    }
    // handler to display the form
    @ RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";

    }
    /* handler to process the form
    Even though both display and process of form has same url value="add", the different
    methods they have distinguishes them - .GET and .POST
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    /* get data out of the request
    my handler/controller method expects to be passed a parameter that is a string
    and we ae going to refer to that as cheeseName
    what the @RequestParam does is it says that Spring should look for the request parameter,
    whether it is a get or a post request parameter, and it will look for it based on the name
    of the method input parameter cheeseName and this needs to match name="cheeseName" from add.html template
    and if it finds it, it should insert it into this method call.
     */
    public String processAddCheeseForm(@RequestParam String cheeseName) {
        cheeses.add(cheeseName);

        // Redirect to /cheese which is value = "" - localhost:8080/cheese/
        return  "redirect:";

    }
}

