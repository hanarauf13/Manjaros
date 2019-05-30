package uk.ac.city.aczg113.Manjaros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestaurantController {
    @RequestMapping (value = "/About")
    public ModelAndView showAbout() { return new ModelAndView("About");}


    @RequestMapping(value ="/Menu")
    public ModelAndView showMenu(){ return new ModelAndView("Menu");}

    @RequestMapping(value="/Contact-Us")
    public ModelAndView showContactUs(){ return new ModelAndView("Contact-Us");}
}


