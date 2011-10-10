package sportsbook.types;

import java.io.Serializable;

public class Team implements Serializable {

    public Team() { }
    public Team(long espn_id, String name, String league) {
        this.espn_id = espn_id;
        this.name = name;
        this.league = league;
    }
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

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String toString() {
        return name + " (" + id + ")";
    }

    public long getEspn_id() {
        return espn_id;
    }

    public void setEspn_id(long espn_id) {
        this.espn_id = espn_id;
    }
    
    protected String league;
    protected long id;
    protected String name;
    protected long espn_id;

}
