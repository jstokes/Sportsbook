package com.sportsbook.parser.scala

import _root_.java.net.{URL, URLConnection}
import com.sportsbook.parser.java.{Game, League, Team}
import com.sportsbook.parser.IParser
import _root_.scala.xml._

class ScoreParser extends IParser {
   def getSource:Elem = {
      import java.net.{URLConnection, URL}
      val source = """"http://scores.espn.go.com/nfl/scoreboard"""
      val url = new URL(source)
      val connection:URLConnection = url.openConnection
      XML.load(connection.getInputStream)
   }
   def parse = null

  def readSource() = {
    getSource.toString();
  }
}