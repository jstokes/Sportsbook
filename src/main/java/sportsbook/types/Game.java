package sportsbook.types;

import sportsbook.dao.TeamDAO;

import java.io.Serializable;

public class Game implements Serializable {

    public Game(long id, char status, int home_score, int away_score, long home, long away) {
        this.id = id;
        this.status = status;
        this.home_score = home_score;
        this.away_score = away_score;
        this.home = home;
        this.away = away;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getAway() {
        return away;
    }

    public void setAway(long away) {
        this.away = away;
    }

    public long getHome() {
        return home;
    }

    public void setHome(long home) {
        this.home = home;
    }

    public String toString() {
        TeamDAO teamDAO = new TeamDAO();
        Team tHome = teamDAO.get(getHome());
        Team tAway = teamDAO.get(getAway());
        return "Game: " +
                "\n\tid: = " + getId() +
                "\n\tstatus = " + getStatus() +
                "\n\tHome = " + tHome + " : " + getHome_score() +
                "\n\tAway = " + tAway + " : " + getAway_score();
    }

    private long id;
    private char status;
    private int home_score;
    private int away_score;
    private long away;
    private long home;
}
