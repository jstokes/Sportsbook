/*

import java.io.{FileInputStream, File}
import sportsbook._
import parser._
import org.xml.sax.InputSource

val hp = new HTMLParser
val sp = new ScoreParser

val JSExtractor =
  """<script type="text/javascript">\s*function gameObj([\S\s]*?)</script>""".r
val GameExtractor =
  """var thisGame = new gameObj\("(\d+)", "(\d+)", "(\d+)".*""".r

val xml = hp.loadXML(new InputSource(new FileInputStream(
  new File("src/test/scala/sportsbook/parser/testscores.txt"))))


List[Game] = matchList foreach { m =>
  val Seq(game, home_id, away_id) = 1 to 3 map m.group
  
}

for (m <- matchList) {
  val Seq(game_id, home_id, away_id) = 1 to 3 map m.group
  val (home_score, away_score) = scoresById(game_id)

  yield new Game()
}
(gameid, homeid, awayid)

(home_score, away_score)

game:
  id
  status
  home_score
  away_score
  away
  home
public Game(long id, char status, int home_score, int away_score, long home, long away)

*/