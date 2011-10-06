package sportsbook.types;

/**
 * Created by Jeff Stokes.
 * Date: 10/2/11
 * Time: 3:42 PM
 */
public class League {
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

    private long id;
    private String name;
}
