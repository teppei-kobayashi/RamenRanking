package models;

public class RankingAvg {

    private String ramen_name;

    private double point;

    public RankingAvg(){

    }

    public RankingAvg(String ramen_name, double point){
        this.ramen_name = ramen_name;
        this.point = point;
    }

    public String getRamen_name() {
        return ramen_name;
    }

    public void setRamen_name(String ramen_name) {
        this.ramen_name = ramen_name;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }







}
