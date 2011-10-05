package sportsbook.parser;

import scala.xml._
import sportsbook.types.{Game}

class ScoreParser extends IParser {
  
  def parse(src:String):Array[Game] = {
    lazy val myxml:Node = getXHTML

    def getXHTML:Node = {
      val hp = new HTMLParser
      hp.loadXML(new InputSource(src))
    }
    null
  }
}

/*
scala> def attributeEquals(name:String, value:String)(node: Node) =
     | node.attribute(name).filter(_.toString==value).isDefined
attributeEquals: (name: String, value: String)(node: scala.xml.Node)Boolean

scala> snippet \\ "_" filter attributeEquals("class", "score-row")
res88: scala.xml.NodeSeq = NodeSeq()
*/