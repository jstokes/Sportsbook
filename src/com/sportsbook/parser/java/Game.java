package com.sportsbook.parser.java;

public class Game {

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getHome_score() {
        return home_score;
    }

    public void setHome_score(int home_score) {
        this.home_score = home_score;
    }

    public int getAway_score() {
        return away_score;
    }

    public void setAway_score(int away_score) {
        this.away_score = away_score;
    }

    public int getAway() {
        return away;
    }

    public void setAway(int away) {
        this.away = away;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    private long id;
    private char status;
    private int home_score;
    private int away_score;
    private int away;
    private int home;
}
