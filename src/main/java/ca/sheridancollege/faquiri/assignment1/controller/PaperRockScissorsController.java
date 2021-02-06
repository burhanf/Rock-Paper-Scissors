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
        //create game
        PaperRock paperRock = new PaperRock();

        //pass in the choice of the user
        paperRock.setUserChoice(choice);

        //todo get winner from here or determine winner in output?
       //paperRock.getWinnerName();

        //pass the winner into output as a model attribute

        //pass in the entire game object to have access to all informtaion
        model.addAttribute("game", paperRock);

        //output page
        return "output";
    }

    @GetMapping("playAgain")
    //play again hyper link
    public String reset(){
        return ("redirect:/");
    }

}
