package ca.sheridancollege.faquiri.assignment1.controller;

import ca.sheridancollege.faquiri.assignment1.model.PaperRock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaperRockScissorsController {
    //input page
    @GetMapping("/")
    public String inputPage(){

        return "input";
    }

    //when button is clicked, call the game and determine winner from PaperRock
    @PostMapping("processWinner")
    //grab user choices
    public String processWinner(Model model, @RequestParam(defaultValue = "0") int choice){
        //choice = user's choice

        //create game
        //pass in the choice of the user
        //determine winner
        PaperRock paperRock = new PaperRock();
        paperRock.setUserChoice(choice);

        //winner is an attribute, an string
       //paperRock.getWinnerName();

        //pass the winner into output as a model attribute

        //pass in the game and get the details from there???
        model.addAttribute("game", paperRock);

        //output page
        return "output";
    }

    @GetMapping("playAgain")
    public String reset(){
        return ("redirect:/");
    }

}
