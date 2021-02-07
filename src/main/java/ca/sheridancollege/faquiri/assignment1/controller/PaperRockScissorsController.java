package ca.sheridancollege.faquiri.assignment1.controller;

import ca.sheridancollege.faquiri.assignment1.model.PaperRock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PaperRockScissorsController {
    //dictionary to store results which will be added to the model
    Map<String, String> gameResults = new HashMap<String, String>();

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

        //add game information to dictionary
        gameResults.put("userChoice", paperRock.getUserChoiceName());
        gameResults.put("computerChoice", paperRock.getComputerChoiceName());

        //determine the winner
        gameResults.put("winnerName", paperRock.getWinnerName());

        //add the results of the game to the model
        model.addAttribute("gameResults", gameResults);

        //output page
        return "output";
    }

    @GetMapping("playAgain")
    //play again hyper link
    public String reset(){
        //clear dictionary
        gameResults.clear();
        return ("redirect:/");
    }
}
