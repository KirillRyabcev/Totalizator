package by.kirill.project.entity;

/**
 * Created by Acer on 20.03.2018.
 */
public class Team {

    private String name;
    private double probability;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability){
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", probability=" + probability +
                '}';
    }
}
