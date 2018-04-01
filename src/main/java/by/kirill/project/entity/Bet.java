package by.kirill.project.entity;

/**
 * Created by Acer on 20.03.2018.
 */
public class Bet {

    private int bet;
    private Team team;
    private Client client;

    public Bet(){}

    public Bet(int bet, Team team, Client client) {
        this.bet = bet;
        this.team = team;
        this.client = client;
    }

    public int getBet() {
        return bet;
    }

    public Team getTeam() {
        return team;
    }

    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "bet=" + bet +
                ", team='" + team + '\'' +
                ", client=" + client +
                '}';
    }
}

