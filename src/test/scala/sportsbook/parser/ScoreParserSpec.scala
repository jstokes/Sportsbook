package sportsbook.parser

import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import sportsbook.types.Game

class ScoreParserSpec extends FeatureSpec with GivenWhenThen {
  val NUM_GAMES = 15;
  val SCORE_FILE_PATH = "src/test/scala/sportsbook/parser/testscores.txt"

  feature("ScoreParser can read through http and retrieve game scores") {
    scenario("reading information from html") {
      given("html is in correct format")
        val src = io.Source.fromFile(SCORE_FILE_PATH).mkString
      when("parse is invoked")
        val sp = new ScoreParser()
        val games:Array[Game] = sp.parse(src)
      then("there should be " + NUM_GAMES + " games returned")
        assert(games.length == 15)
      and("the scores should match hand entered scores")
    }
  }
}