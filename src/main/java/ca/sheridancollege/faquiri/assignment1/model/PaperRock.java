package ca.sheridancollege.faquiri.assignment1.model;/*
 * Sheridan College, Ontario
 */

import java.io.Serializable;

public class PaperRock implements Serializable{
    
    // choices
    public static final int PAPER = 0, ROCK = 1, SCISSORS = 2;

    private int userChoice = ROCK;
    private int computerChoice = ROCK;

    private static final String[] choiceNames = {"Paper", "Rock", "Scissors"};

    // winner
    public static final int COMPUTER = 0, USER = 1, DRAW = 2;
    private String[] winnerNames = {"Computer", "User", "Draw"};
    
    // game logic
    // the first index is the computer choice, second is user, third is draw as the winner
    //second index[] is the actual choice thats made, [][1] is paper, [][2] is rock and [][3] is scissors
    private static final int[][] winnerSelect = 
    {   
        // computer selected paper
        {
            DRAW, // user selected paper 
            COMPUTER, // user selected rock
            USER // user selected scissors
        },
        
        // computer selected rock
        {
            USER, // user selected paper 
            DRAW, // user selected rock
            COMPUTER // user selected scissors
        },
        
        // computer selected scissors
        {
            COMPUTER, // user selected paper
            USER, // user selected rock
            DRAW // user selected scissors
        }
    };
    
    public PaperRock(){
        computerChoice = (int)(3*Math.random());
    }

    public int getUserChoice() {
        return userChoice;
    }

    public void setUserChoice(int userChoice) {
        //this is set by the user radio group
        if(userChoice >= 0 && userChoice <= 2){
            this.userChoice = userChoice;
        }else{
            throw new IllegalArgumentException("Illegal user choice value.");
        }
    }

    public int getComputerChoice() {
        return computerChoice;
    }

    public void setComputerChoice(int computerChoice) {
        if(computerChoice >= 0 && computerChoice <= 2){
            this.computerChoice = computerChoice;
        }else{
            throw new IllegalArgumentException("Illegal computer choice value.");
        }
    }

    //todo fix the names for the choices
    public String getUserChoiceName(){
        return choiceNames[userChoice];
    }
    
    public String getComputerChoiceName(){
        return choiceNames[computerChoice];
    }
    
    public int getWinner(){
        return winnerSelect[computerChoice][userChoice];
    }
    
    public String getWinnerName(){
        return winnerNames[getWinner()];
    }
    
    public void setComputerName(String computerName){
        winnerNames[COMPUTER] = computerName;
    }
    
    public String getComputerName(){
        return winnerNames[COMPUTER];
    }
    
    public void setUserName(String userName){
        winnerNames[USER] = userName;
    }
    
    public String getUserName(){
        return winnerNames[USER];
    }
    
}

