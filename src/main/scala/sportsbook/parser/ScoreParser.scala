package sportsbook.parser;

import scala.xml._
import sportsbook.types.{Game}

class ScoreParser extends IParser {
  
  def parse(src:String):Array[Game] = {
    val xml:Node = getXHTML


    def getXHTML:Node = {
      val hp = new HTMLParser
      hp.loadXML(new InputSource(src))
    }
    null
  }

}