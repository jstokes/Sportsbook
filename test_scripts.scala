import java.io.{FileInputStream, File}
import sportsbook._
import parser._
import org.xml.sax.InputSource

val hp = new HTMLParser
val sp = new ScoreParser

val JSExtractor = """(?s)<script type="text/javascript">\s*function gameObj(?:(?!</script>)[\s\S]).*""".r
val GameExtractor = """.*var thisGame = new gameObj\(\"(\\d+)\", \"(\\d+)\", \"(\\d+)\".*""".r

val xml = hp.loadXML(new InputSource(new FileInputStream(
  new File("src/test/scala/sportsbook/parser/testscores.txt"))))

