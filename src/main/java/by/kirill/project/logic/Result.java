package by.kirill.project.logic;

import by.kirill.project.logic.Match;

/**
 * Created by Acer on 20.03.2018.
 */
public class Result {

    private String champion;
    private double prize;

    public Result(){}

    public Result(String champion) {
        this.champion = champion;
    }

    public double getPrize() { return prize; }

    public void setPrize(double prize) { this.prize = prize; }

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }

    public void showResults(Match match){
        System.out.println("Результаты:");
        countPrize(match) ;
    }

    private double countPrize(Match match){
        double cashbox = 0;
        double prizecash = 0;
        for(int i = 0;i<match.getBets().size();i++){
            cashbox = cashbox + match.getBets().get(i).getBet();
            prize = match.getBets().get(i).getBet()*match.CountKoef(match.getMargin(),match.getBets().get(i).getTeam().getProbability());
            if(match.getBets().get(i).getTeam().getName()!=champion) prize = 0;
            prizecash = prizecash + prize - match.getBets().get(i).getBet();
            match.getBets().get(i).getClient().setMoney(prize+match.getBets().get(i).getClient().getMoney());
            System.out.println(match.getBets().get(i).getClient().toString() + " Выйгрыш: " + prize);
        }
            System.out.println("Выручка: " + (cashbox - prizecash));
            return prize;
    }
}
