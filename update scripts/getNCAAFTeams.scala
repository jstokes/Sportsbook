import sportsbook.parser.HTMLParser
import sportsbook.dao.TeamDAO
import sportsbook.types.Team

val hp = new HTMLParser
val xml = hp.loadXML("http://espn.go.com/college-football/teams")

val TeamExtractor = """college-football/team/_/id/(\d+)/.*?\>([^<]+)""".r

val match_data = (TeamExtractor findAllIn xml.toString).matchData

for (m <- match_data) {
  val id = Integer.parseInt(m.subgroups(0))
  val name = m.subgroups(1).replace("&amp;", "&")
  val team = new Team(id, name, 2)
  val dao = new TeamDAO
  dao.post(team)
}