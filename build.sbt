libraryDependencies ++= Seq(
  "nu.validator.htmlparser" % "htmlparser" % "1.2.1",
  "org.scalatest" % "scalatest_2.9.0" % "1.6.1" % "test"
)

// define the statements initially evaluated when entering 'console', 'console-quick', or 'console-project'
initialCommands := """
  import System.{currentTimeMillis => now}
  def time[T](f: => T): T = {
    val start = now
    try { f } finally { println("Elapsed: " + (now - start)/1000.0 + " s") }
  }
"""

// set the initial commands when entering 'console' only
initialCommands in console := "import sportsbook._"

defaultExcludes  := "test_scripts.scala"