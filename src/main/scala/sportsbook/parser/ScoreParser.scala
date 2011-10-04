package sportsbook.parser;

import scala.xml._
import sportsbook.types.{Game}

class ScoreParser extends IParser {
  
  def parse(src:String):Array[Game] = {
    val xml:Elem = XML.load(src)
    null
  }

}