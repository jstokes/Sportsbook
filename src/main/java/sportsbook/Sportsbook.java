package sportsbook;

import org.xml.sax.InputSource;
import sportsbook.dao.GameDAO;
import sportsbook.parser.ScoreParser;
import sportsbook.parser.HTMLParser;
import sportsbook.types.Game;

import javax.xml.soap.Node;

/**
 * Created by Jeff Stokes.
 * Date: 10/3/11
 * Time: 9:31 PM
 */
public class Sportsbook {

    /* Class variables */
    private static ScoreParser sp;


    public static void main(String[] args) {
        run();
    }

    private static void run() {
        init();
        updateDB();
    }

    private static void init() {
        sp = new ScoreParser();
    }

    private static void updateDB() {
        updateGameDB();
    }

    private static void updateGameDB() {
        //updateNFL();
        updateNCAAF();
    }

    private static void updateNFL() {
        final String src = "http://scores.espn.go.com/nfl/scoreboard";
        Game[] games = sp.parse(src, "NFL");
        GameDAO gameDAO = new GameDAO();
        gameDAO.post(games);
        for (Game g: games) { System.out.println("Added:" + g); }
    }

    private static void updateNCAAF() {
        final String src = "http://scores.espn.go.com/ncf/scoreboard";
        Game[] games = sp.parse(src, "NCAA");
        GameDAO gameDAO = new GameDAO();
        gameDAO.post(games);
        for (Game g: games) { System.out.println("Added:" + g); }
    }
}