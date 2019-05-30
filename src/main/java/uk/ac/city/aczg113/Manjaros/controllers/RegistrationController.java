package uk.ac.city.aczg113.Manjaros.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczg113.Manjaros.entities.RestaurantUser;
import uk.ac.city.aczg113.Manjaros.services.RegistrationService;

@Controller
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @RequestMapping (value = "/" , method = RequestMethod.GET)
    public ModelAndView showAbout(){
        return new ModelAndView("About.html", "RestaurantUser", registrationService.getCurrentUser());
    }

    @RequestMapping (value = "/Contact-Us", method = RequestMethod.GET)
    public ModelAndView showContactUs(){
        RestaurantUser restaurantUser = new RestaurantUser();
        return new ModelAndView("Contact-Us", "restaurantUser", new RestaurantUser());}

    @RequestMapping(value = "/Profile")
    public ModelAndView showUsers(){
        return new ModelAndView("/profile", "users", registrationService.getUsers());
    }
    @RequestMapping (value ="/Contact-Us", method = RequestMethod.POST)
    public String processContactUs(RestaurantUser restaurantUser) {
        restaurantUser.setEnabled(Boolean.TRUE);
        restaurantUser.setAuthority("ROLE_USER");
        registrationService.addUser(restaurantUser);
        return "redirect:/About.html";

    }

    }
