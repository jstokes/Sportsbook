package com.sportsbook.parser.java;

public class Team {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public long getLeague() {
        return league;
    }

    public void setLeague(long league) {
        this.league = league;
    }

    public long league;
    private long id;
    private String name;
}
