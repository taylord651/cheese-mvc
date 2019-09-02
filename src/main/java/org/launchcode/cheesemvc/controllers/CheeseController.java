package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by Domonique Taylor
 */

@Controller
@RequestMapping("cheese")
public class CheeseController {


    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());

        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheesesForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese) {

        /* Code that is being implicitly run for us by Spring Boot
        *
        * Cheese newCheese = new Cheese();  //Call the default constructor
        * newCheese.setName(Request.getParameter("name")); //Go to request, look for a parameter that corresponds to the name of the field that we are trying to set, and call that
        * newCheeses.setDescription(Request.getParameter("description"));
        *
        * */
        
        CheeseData.add(newCheese);

        // Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String removeCheesesForm(Model model) {
        model.addAttribute("title", "Remove Cheese");

        model.addAttribute("cheeses", CheeseData.getAll());

        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String removeCheeseForm(@RequestParam int[] cheeseIds) {

        for (int cheeseId : cheeseIds) {
            CheeseData.remove(cheeseId);
        }

        // Redirect to /cheese
        return "redirect:";
    }
}

