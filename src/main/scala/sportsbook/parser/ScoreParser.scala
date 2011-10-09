package sportsbook.parser;

import scala.xml._
import sportsbook.types.{Game}
import util.matching.Regex


class ScoreParser extends IParser {
  
  def parse(xml:Node):Array[Game] = {
    def scoresById(id:Int):(Int, Int) = {
      lazy val home_score:Int = get_score('h')
      lazy val away_score:Int = get_score('a')

      def get_score(homeOrAway:Char):Int = {
        val attrStr = "%s-%cTotal"
        def attributeEquals(name:String, value:String)(node: Node) = {
          node.attribute(name).filter(_.toString==value).isDefined
        }
        def attrCond: (Node) => Boolean = {
          attributeEquals("id", attrStr.format(id.toString, homeOrAway))
        }

        def filterbyAttr:String = {
          (xml \\ "_").filter(attrCond).text
        }

        Integer.parseInt(filterbyAttr)
      }

      (home_score, away_score)
    }

    val JSExtractor =
      """<script type="text/javascript">[\S\s]*?function gameObj([\S\s]*?)</script>""".r
    val GameExtractor =
      """.*var thisGame = new gameObj\("(\d+)", "(\d+)", "(\d+)".*""".r

    val jsExtract: Option[String] = JSExtractor findFirstIn (xml toString)

    def extractGames(src:String):List[Game] = {
      val rplSrc = src.replaceAll("&quot;", "\"")
      val match_data = (GameExtractor findAllIn rplSrc).matchData

      def extractGame(m:Regex.Match):Game = {
        val values = 1 to 3 map m.group
        val Seq(game_id, home_id, away_id) = values map Integer.parseInt
        val (homeScore, awayScore) = scoresById(game_id)
        new Game(game_id, 'n', homeScore, awayScore, home_id, away_id)
      }

      val gameItr = for (m <- match_data) yield extractGame(m)
      gameItr.toList
    }

    val games:List[Game] = jsExtract match {
      case Some(src:String) =>
        extractGames(src)
      case _ =>
        println("Match error")
        null
    }
    if (games != null) games.toArray else null
  }
  
  def parse(src:String):Array[Game] = {
    val hp = new HTMLParser
    val xml = hp.loadXML(src)
    parse(xml)
  }
}

/*
311002003,
311002004,
311002005,
311002006,
311002012,
311002014,
311002021,
311002030,
311002034,
311002022,
311002026,
311002009,
311002013,
311002024,
311002033
*/
  /*
      gameObj(gameId, homeTeamId, awayTeamId, sortValue)
      var thisGame = new gameObj("311002003", "3", "29", "1")
        Bears, Panthers
			var thisGame = new gameObj("311002004", "4", "2", "2")
			  Bengals, Bills
			var thisGame = new gameObj("311002005", "5", "10", "3")
			  Browns, Titans
			var thisGame = new gameObj("311002006", "6", "8", "4")
			  Cowboys, Lions
			var thisGame = new gameObj("311002012", "12", "16", "5")
			  Chiefs, Vikings
			var thisGame = new gameObj("311002014", "14", "28", "6")
			  Rams, Redskins
			var thisGame = new gameObj("311002021", "21", "25", "7")
			  Eagles, 49ers
			var thisGame = new gameObj("311002030", "30", "18", "8")
			  Jaguars, Saints
			var thisGame = new gameObj("311002034", "34", "23", "9")
			  Texans, Steelers
			var thisGame = new gameObj("311002022", "22", "19", "10")
			  Cardinals, Giants
			var thisGame = new gameObj("311002026", "26", "1", "11")
			  Seahawks, Falcons
			var thisGame = new gameObj("311002009", "9", "7", "12")
			  Packers, Broncos
			var thisGame = new gameObj("311002013", "13", "17", "13")
			  Raiders, Patriots
			var thisGame = new gameObj("311002024", "24", "15", "14")
			  Chargers, Dolphins
			var thisGame = new gameObj("311002033", "33", "20", "15")
			  Jets, Ravens

        Buccaneers=27
        Colts=11
			
			
*/

