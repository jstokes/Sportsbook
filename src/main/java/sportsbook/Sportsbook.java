package sportsbook;

import sportsbook.dao.GameDAO;
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
        //final String src = "http://scores.espn.go.com/nfl/scoreboard";
        ScoreParser parser = new ScoreParser();
        //Game[] games = parser.parse(src);

        GameDAO gDAO = new GameDAO();
        //gDAO.postToDB(games);
    }
}