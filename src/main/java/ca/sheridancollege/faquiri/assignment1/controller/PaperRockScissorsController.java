package ca.sheridancollege.faquiri.assignment1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaperRockScissorsController {
    //input page
    @RequestMapping("/")
    public String inputPage(){

        return "input";
    }

    //grab user choices

    //when button is clicked, call the game and determine winner from PaperRock
    @PostMapping("processWinner")
    public String processWinner(Model model){


        return "output";
    }

    //pass the winner into output as a model attribute

    //output page

}
