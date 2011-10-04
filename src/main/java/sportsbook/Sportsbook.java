package sportsbook;

import sportsbook.dao.GameDAO;
import sportsbook.http.MyConnection;
import sportsbook.parser.ScoreParser;
import sportsbook.types.Game;

/**
 * Created by Jeff Stokes.
 * Date: 10/3/11
 * Time: 9:31 PM
 */
public class Sportsbook {

    public static void main(String[] args) {
        run();
    }


    private static void run() {
        updateDB();
    }

    private static void updateDB() {
        updateGameDB();
    }

    private static void updateGameDB() {
        MyConnection con = new MyConnection("http://scores.espn.go.com/nfl/scoreboard");
        String src = con.getSource();

        ScoreParser parser = new ScoreParser();
        Game[] games = parser.parse(src);

        GameDAO gDAO = new GameDAO();
        gDAO.postToDB(games);
    }
}
