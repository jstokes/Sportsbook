package sportsbook.parser

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import sportsbook.types.Game
import java.io.File;
import java.io.FileInputStream
import org.xml.sax.InputSource

class ScoreParserSpec extends FeatureSpec with GivenWhenThen {
  val NUM_GAMES = 15;
  val SCORE_FILE_PATH = "src/test/scala/sportsbook/parser/testscores.txt"

  feature("ScoreParser can read through html and retrieve game scores") {
    scenario("reading information from html") {
      given("html is in correct format")
        val file = new File(SCORE_FILE_PATH)
        val hp = new HTMLParser
        val xml = hp.loadXML(new InputSource(new FileInputStream(file)))
      when("parse is invoked")
        val sp = new ScoreParser
        val games:Array[Game] = sp.parse(xml)
      then ("game should not be empty")
        assert(games != null)
      then("there should be " + NUM_GAMES + " games returned")
        assert(games.length == 16)
      and("the scores should match hand entered scores")
    }
  }
}