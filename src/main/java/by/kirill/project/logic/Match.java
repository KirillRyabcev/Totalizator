package by.kirill.project.logic;

import by.kirill.project.entity.Bet;
import by.kirill.project.entity.Client;
import by.kirill.project.entity.Team;
import by.kirill.project.exceptions.NoMoneyException;
import by.kirill.project.exceptions.SumOfProbabilityException;
import by.kirill.project.exceptions.WrongMarginException;

import java.util.ArrayList;

/**
 * Created by Acer on 20.03.2018.
 */
public class Match {

    private ArrayList<Team> teams = new ArrayList<Team>();
    private ArrayList<Bet> bets = new ArrayList<Bet>();
    private double margin;
    private double koef;

    public Match(ArrayList<Team> teams){
        this.teams = teams;
    }

    public Match(){}

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public ArrayList<Bet> getBets() {
        return bets;
    }

    public void setBets(ArrayList<Bet> bets) {
        this.bets = bets;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) throws WrongMarginException {
        if(margin<1.0 || margin>20.0) throw new WrongMarginException("Маржа не может быть меньше 1 и больше 20!!!");
        this.margin = margin;
    }

    public void makeBet(Team team, int bet, Client client) throws NoMoneyException {
        if(client.getMoney()<bet) throw new NoMoneyException("Не хватает денег на счету!!!");
        client.setMoney(client.getMoney() - bet);
        Bet b = new Bet(bet, team, client);
        bets.add(b);
    }

    public double CountKoef(double margin, double propability) {
        koef = 100 / (propability + margin);
        return koef;
    }

    public void checkProb() throws SumOfProbabilityException {
        double c = 0;
        for (int i = 0; i<teams.size();i++) {
            c = c + teams.get(i).getProbability();
        }
        if (c != 100.0) throw new SumOfProbabilityException("Сумма веротностей не равно 100");
    }

    @Override
    public String toString() {
        return "Match{" +
                "teams=" + teams + ", \n" +
                "      bets=" + bets + ", \n" +
                "      margin=" + margin +
                '}';
    }
}
