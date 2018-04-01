package by.kirill.project;

import by.kirill.project.entity.Client;
import by.kirill.project.logic.Match;
import by.kirill.project.logic.Result;
import by.kirill.project.entity.Team;
import by.kirill.project.exceptions.NoMoneyException;
import by.kirill.project.exceptions.SumOfProbabilityException;
import by.kirill.project.exceptions.WrongMarginException;

import java.util.ArrayList;

/**
 * Created by Acer on 20.03.2018.
 */
public class Main {
    public static void main(String[] args){
        Team team = new Team("man. united");
        Team team1 = new Team("real madrid");
        ArrayList<Team> teams = new ArrayList<Team>();
        teams.add(team);
        teams.add(team1);
        try{
            Match match = new Match(teams);
            team.setProbability(30);
            team1.setProbability(70);
            try {
                match.checkProb();
            }catch (SumOfProbabilityException ex){
                ex.getMessage();
                ex.printStackTrace();
            }
            match.setMargin(10.0);
            Client client = new Client("Kirill", 500);
            Client client2 = new Client("Ivan", 500);
            Client client3 = new Client("Gleb", 500);
            try {
                match.makeBet(team, 200, client);
                match.makeBet(team, 100, client2);
                match.makeBet(team1, 300, client3);
            }catch (NoMoneyException ex){
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
            System.out.println(match);
            Result res = new Result("man. united");
            res.showResults(match) ;
        }catch (WrongMarginException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
