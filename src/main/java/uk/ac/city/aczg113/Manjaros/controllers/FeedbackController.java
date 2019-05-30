package uk.ac.city.aczg113.Manjaros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.city.aczg113.Manjaros.entities.Feedback;
import uk.ac.city.aczg113.Manjaros.services.FeedbackService;

@Controller
public class FeedbackController {

    private FeedbackService feedbackService;


    @Autowired
    public FeedbackController(FeedbackService feedbackService){ this.feedbackService = feedbackService;}

    @RequestMapping(value = "feedback", method = RequestMethod.GET)
    public ModelAndView showFeedback(){
        Feedback feedback = new Feedback();
        return new ModelAndView("feedback", "feedback", feedback);
    }

    @RequestMapping (value = "feedbackSubmit", method = RequestMethod.POST)
    public String processFeedback(Feedback feedback){
        //Retrieves email address and feedback of user.
        feedbackService.makeFeedback(feedback);
        return "redirect:/Contact-Us";
    }
}
