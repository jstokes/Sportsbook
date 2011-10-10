package sportsbook.parser;

import scala.xml._
import sportsbook.types.{Game}
import util.matching.Regex
import sportsbook.dao.TeamDAO


class ScoreParser extends IParser {
  def parse(xml:Node, league:String):Array[Game] = {
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
        val Seq(game_id, homeId, awayId) = values map Integer.parseInt
        val (homeScore, awayScore) = scoresById(game_id)
        val tDAO = new TeamDAO
        val home_id = tDAO.getByESPN(homeId, league)
        val away_id = tDAO.getByESPN(awayId, league)

        if (home_id == -1) {
          println("unable to find team " + homeId)
          null
        } else if (away_id == -1) {
            println("unable to find team " + awayId)
            null
        } else {
            new Game(game_id, 'n', homeScore, awayScore, home_id, away_id)
        }
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

  def parse(src:String, league:String):Array[Game] = {
    val hp = new HTMLParser
    val xml = hp.loadXML(src)
    parse(xml, league)
  }
}

